package com.mruruc.entityRelationship;

import com.mruruc.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class Create {
    public static void main(String[] args) {


        Employee employee1 = new Employee();

        employee1.setFname("Neloo");
        employee1.setLast_name("Harness");
        employee1.setBirth_date(new Date());
        employee1.setGender(Gender.FEMALE);
        employee1.setDont_persist("something");
        employee1.setEmail("nelobombelo234@gmail.com");

        AccessCard accessCard1 = new AccessCard();
        accessCard1.setIssuedDate(new Date());
        accessCard1.setIsActive(true);
        accessCard1.setFirmWareVersion("1.0.0");

        employee1.setCard(accessCard1);
        accessCard1.setEmployee(employee1);

        Employee employee2 = new Employee();

        employee2.setFname("Wafloo");
        employee2.setLast_name("Harness");
        employee2.setBirth_date(new Date());
        employee2.setGender(Gender.MALE);
        employee2.setDont_persist("something");
        employee2.setEmail("waflo-bombeloo@gmail.com");

        AccessCard accessCard2 = new AccessCard();
        accessCard2.setIssuedDate(new Date());
        accessCard2.setIsActive(false);
        accessCard2.setFirmWareVersion("1.0.5");

        employee2.setCard(accessCard2);
        accessCard2.setEmployee(employee2);

        //=============PayStub===================
        PayStub payStub=new PayStub();
        payStub.setPayPeriodStart(new Date());
        payStub.setGetPayPeriodEnd(new Date());
        payStub.setSalary(1000D);

        payStub.setEmployee(employee1);
        employee1.addPayStub(payStub);

        PayStub payStub2=new PayStub();
        payStub2.setPayPeriodStart(new Date());
        payStub2.setGetPayPeriodEnd(new Date());
        payStub2.setSalary(1250D);

        payStub2.setEmployee(employee1);
     //   employee2.setListOfPayStub(List.of(payStub,payStub2)); //one options to do that
        employee2.addPayStub(payStub2);

  //===================EmailGroup==============
        EmailGroup emailGroup1=new EmailGroup();
        emailGroup1.setName("Weekly Report");

        emailGroup1.setGroupMember(List.of(employee1));


        EmailGroup emailGroup2=new EmailGroup();
        emailGroup2.setName("Announcement to All Employee");

        emailGroup2.setGroupMember(List.of(employee1,employee2));

        employee1.setEmailGroups(List.of(emailGroup1,emailGroup2));
        employee2.setEmailGroups(List.of(emailGroup2));


       //Hibernate magic :))

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(employee1);
        entityManager.persist(employee2);

        entityManager.persist(accessCard1);
        entityManager.persist(accessCard2);

        entityManager.persist(payStub);
        entityManager.persist(payStub2);

        entityManager.persist(emailGroup1);
        entityManager.persist(emailGroup2);

        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();


    }
}
