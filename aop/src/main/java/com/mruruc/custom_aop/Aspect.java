package com.mruruc.custom_aop;

import com.mruruc.jpa_util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class Aspect {
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public void before() {
        this.entityManager = JPAUtil.getEmf().createEntityManager();
        this.entityTransaction = entityManager.getTransaction();
        this.entityTransaction.begin();
        System.out.println("Transaction starting ... ");
    }

    public void after() {
        if (entityTransaction != null && entityTransaction.isActive())
            entityTransaction.commit();
        entityManager.close();
        System.out.println("Transaction Committed.");
    }

    public void onException() {
        if (entityTransaction != null && entityTransaction.isActive()) {
            entityTransaction.rollback();
            System.out.println("Transaction Rolled Back.");
        }
        entityManager.close();
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }
}
