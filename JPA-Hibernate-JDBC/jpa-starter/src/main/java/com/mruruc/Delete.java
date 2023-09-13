package com.mruruc;

import com.mruruc.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Delete {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager=entityManagerFactory.createEntityManager();

        Employee employee=entityManager.find(Employee.class,2);

        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();

        entityManager.remove(employee);

        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();

    }
}
