package com.mruruc.entityRelationship;

import com.mruruc.model.EmailGroup;
import com.mruruc.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Update {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager=entityManagerFactory.createEntityManager();

        Employee employee = entityManager.find(Employee.class, 2);
        EmailGroup emailGroup1 = entityManager.find(EmailGroup.class, 1);
        EmailGroup emailGroup2 = entityManager.find(EmailGroup.class, 2);

        employee.setEmailGroups(List.of(emailGroup1,emailGroup2));
        emailGroup1.setGroupMember(List.of(employee));
        emailGroup2.setGroupMember(List.of(employee));


        EntityTransaction transaction=entityManager.getTransaction();

        transaction.begin();

        entityManager.persist(employee);
        entityManager.persist(emailGroup1);
        entityManager.persist(emailGroup2);

        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();


    }
}
