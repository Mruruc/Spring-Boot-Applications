package com.mruruc;

import com.mruruc.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Read {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager= entityManagerFactory.createEntityManager();


   /*     Employee employee = entityManager.find(Employee.class, 2);
        System.out.println(employee);

        Employee employee2 = entityManager.find(Employee.class, 1);
        System.out.println(employee2);*/



        List<Employee> list=null;

        String queryString="Select e from Employee e";
        TypedQuery<Employee> query=entityManager.createQuery(queryString,Employee.class);
        list=query.getResultList();

       for (Employee name: list){
           System.out.println(name.getFname());
       }



    }
}
