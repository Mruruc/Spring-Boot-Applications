package com.mruruc.entityRelationship;

import com.mruruc.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Delete {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManger=entityManagerFactory.createEntityManager();

        Employee employee = entityManger.find(Employee.class, 1);


        EntityTransaction transaction = entityManger.getTransaction();
        transaction.begin();

        entityManger.remove(employee);

        transaction.commit();
        entityManger.close();
        entityManagerFactory.close();



    }
}
