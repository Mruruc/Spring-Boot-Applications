package com.mruruc;

import javax.persistence.EntityTransaction;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class Create<T, Id> implements Repo<T, Id> {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction transaction;
    private Class<T> entity;

    public Create(Class<T> entity){
        this.entityManagerFactory= Persistence.createEntityManagerFactory("com.mruruc.Jpa-Customizing");
        this.entityManager= entityManagerFactory.createEntityManager();
        this.entity=entity;
    }

    private EntityTransaction startTransactions(){
        this.transaction= entityManager.getTransaction();
        return transaction;
    }

    @Override
    public void save(T t){
        EntityTransaction transaction1 = startTransactions();
        transaction1.begin();
        entityManager.persist(t);
        transaction1.commit();

    }
   @Override
   public void closeEmf_Em(){
        this.entityManagerFactory.close();
        this.entityManager.close();
    }

    @Override
    public T findById(Id id) throws SQLException {
        if(id!=null){
            return entityManager.find(entity,id);
        }
        else throw new SQLException(id +"is null!");
    }

    @Override
    public void update(T t,Id id) throws SQLException {
        T t1 = entityManager.find(entity, id);
        if(t1!=null){
            EntityTransaction transaction1 = startTransactions();
            transaction1.begin();
            entityManager.persist(t1);
            transaction1.commit();
        }
        else throw new SQLException(id +" is null!");
    }

    @Override
    public void delete(Id id) throws SQLException {
        EntityTransaction transaction1 = startTransactions();
        T byId = findById(id);
        transaction1.begin();
        entityManager.remove(byId);
        transaction1.commit();
    }

}
