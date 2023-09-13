package com.mruruc;

import com.mruruc.model.Employee;
import com.mruruc.model.Gender;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Update {
    public static void main(String[] args) {

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager= emf.createEntityManager();

        Employee employee=entityManager.find(Employee.class,1);
        System.out.println(employee);
        employee.setEmail("neloo_bombelooo@hotmali.com");
        employee.setGender(Gender.OTHERS);

        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(employee);
        transaction.commit();

        System.out.println(entityManager.find(Employee.class,1));

        entityManager.close();
        emf.close();

    }
}
