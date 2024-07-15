package com.mruruc.repository;

import com.mruruc.custom_aop.Aspect;
import com.mruruc.exceptions.IdFieldNotFoundException;
import com.mruruc.jpa_util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Id;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@SuppressWarnings("unchecked")
public class GenericRepositoryImpl<T, ID> implements GenericRepository<T, ID> {
    private final Class<T> entityClazz;
    private final Aspect aspect;

    public GenericRepositoryImpl(final Class<T> entityClazz, Aspect aspect) {
        this.entityClazz = entityClazz;
        this.aspect = aspect;
    }

    @Override
    public T save(T entity) {
        EntityManager entityManager = aspect.getEntityManager();
        try {
            if (isNew(entity)) entityManager.persist(entity);
            else entityManager.merge(entity);
            return entity;
        } catch (Exception exception) {
            throw exception;
        }
    }

    @Override
    public Optional<T> findById(ID id) {
        return ofNullable(aspect.getEntityManager().find(entityClazz, id));
    }

    @Override
    public List<T> findAll() {
        return aspect.getEntityManager()
                .createQuery("FROM " + entityClazz.getSimpleName(), entityClazz)
                .getResultList();

    }

    @Override
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