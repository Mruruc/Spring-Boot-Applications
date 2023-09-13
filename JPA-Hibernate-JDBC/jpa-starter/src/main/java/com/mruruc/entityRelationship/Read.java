package com.mruruc.entityRelationship;

import com.mruruc.model.EmailGroup;
import com.mruruc.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Read {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager=entityManagerFactory.createEntityManager();

       // Employee employee1 = entityManager.find(Employee.class, 1);
     //   System.out.println(employee1);
    /*    System.out.println("=============Fetched Employee===========");
        System.out.println(employee1.getFname());
        System.out.println("============Accessed Card===============");
        System.out.println(employee1.getCard());*/
     //   AccessCard accessCard = entityManager.find(AccessCard.class, 2);
     //   System.out.println(accessCard);

        System.out.println("=========Fetched PayStub==========");
       // PayStub payStub = entityManager.find(PayStub.class, 1);
      //  System.out.println(payStub);
        System.out.println("=============Fetched Employee===========");
      //  Employee employee = entityManager.find(Employee.class, 1);

      /*  for (PayStub p : employee.getListOfPayStub()) {
            System.out.println(p.getId() +" "+ p.getEmployee().getFname());
        }*/
    //   System.out.println(employee.getListOfPayStub());
        System.out.println("============Fetched Email Group============");
        EmailGroup emailGroup = entityManager.find(EmailGroup.class, 1);
       for (Employee e: emailGroup.getGroupMember()) System.out.println(e.getFname());

        entityManager.close();
        entityManagerFactory.close();



    }
}
