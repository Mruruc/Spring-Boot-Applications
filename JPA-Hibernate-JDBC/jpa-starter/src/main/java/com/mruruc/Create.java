package com.mruruc;

import com.mruruc.model.AccessCard;
import com.mruruc.model.Employee;
import com.mruruc.model.Gender;

import javax.persistence.*;
import java.util.Date;

public class Create {
    public static void main( String[] args ) {


        Employee employee=new Employee();

        employee.setFname("Neloo");
        employee.setLast_name("Harness");
        employee.setBirth_date(new Date());
        employee.setGender(Gender.FEMALE);
        employee.setDont_persist("something");
        employee.setEmail("nelobombelo234@gmail.com");


        AccessCard accessCard1=new AccessCard();
        accessCard1.setIssuedDate(new Date());
        accessCard1.setIsActive(true);
        accessCard1.setFirmWareVersion("1.0.0");


        Employee employee2=new Employee();

        employee2.setFname("Wafloo");
        employee2.setLast_name("Harness");
        employee2.setBirth_date(new Date());
        employee2.setGender(Gender.MALE);
        employee2.setDont_persist("something");
        employee2.setEmail("waflo-bombeloo@gmail.com");

        AccessCard accessCard2=new AccessCard();
        accessCard2.setIssuedDate(new Date());
        accessCard2.setIsActive(false);
        accessCard2.setFirmWareVersion("1.0.5");


   EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager=entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(employee);
        entityManager.persist(employee2);
        entityManager.persist(accessCard1);
        entityManager.persist(accessCard2);

        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();


    }
}
