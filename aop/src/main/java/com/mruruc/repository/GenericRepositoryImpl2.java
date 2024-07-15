package com.mruruc.repository;

import com.mruruc.aspectJCofig.TransactionAspect;
import com.mruruc.exceptions.IdFieldNotFoundException;
import com.mruruc.jpa_util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@SuppressWarnings("unchecked")
@Repository(value = "repo")
public class GenericRepositoryImpl2<T, ID> {
    private final Class<T> entityClazz;
    private final TransactionAspect aspect;

    @Autowired
    public GenericRepositoryImpl2(@Qualifier("entityClazz") final Class<T> entityClazz, TransactionAspect aspect) {
        this.entityClazz = entityClazz;
        this.aspect = aspect;
    }

    public T save(T entity) {
        EntityManager entityManager = aspect.getEntityManager();
        if (isNew(entity)) entityManager.persist(entity);
        else entityManager.merge(entity);
        return entity;
    }


    public Optional<T> findById(ID id) {
        return ofNullable(aspect.getEntityManager().find(entityClazz, id));
    }

    public List<T> findAll() {
        return aspect.getEntityManager()
                .createQuery("FROM " + entityClazz.getSimpleName(), entityClazz)
                .getResultList();
    }

    public void delete(ID id) {
        EntityManager entityManager = aspect.getEntityManager();
        ofNullable(entityManager.find(entityClazz, id))
                .ifPresentOrElse(entityManager::remove, () -> {
                    throw new EntityNotFoundException("Entity Not Found");
                });
    }

    private boolean isNew(T entity) {
        try (EntityManager entityManager = JPAUtil.getEmf().createEntityManager()) {
            ID entityId = this.getEntityId(entity);
            return entityId == null || entityManager.find(entityClazz, entityId) == null;
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unable to get ID from entity.", e);
        }
    }

    private ID getEntityId(T entity) throws IllegalAccessException {
        Field idField = getEntityIdField();
        idField.setAccessible(true);
        return (ID) idField.get(entity);
    }

    private Field getEntityIdField() {
        for (Field idField : entityClazz.getDeclaredFields())
            if (idField.isAnnotationPresent(Id.class)) return idField;
        throw new IdFieldNotFoundException("Id Field Not Found");
    }
}