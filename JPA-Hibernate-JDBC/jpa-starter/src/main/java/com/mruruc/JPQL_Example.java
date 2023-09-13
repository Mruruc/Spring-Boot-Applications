package com.mruruc;

import com.mruruc.model.EmailGroup;
import com.mruruc.model.Employee;

import javax.persistence.*;
import java.util.List;

public class JPQL_Example {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
        List<Employee> resultList = query.getResultList();
      //  resultList.forEach(System.out::println);
//        for (Employee e:resultList) {
//            System.out.println(e.getFname() + " "+ e.getEmail());
//        }
        TypedQuery<EmailGroup> query1 = entityManager.createQuery("SELECT e from EmailGroup e where e.id=2", EmailGroup.class);
        List<EmailGroup> resultList1 = query1.getResultList();
   //    resultList1.forEach(System.out::println);

        TypedQuery<Employee> query2 = entityManager.createQuery("SELECT e FROM Employee e ORDER BY e.birth_date", Employee.class);
        List<Employee> resultList2 = query.getResultList();
       // System.out.println(resultList2);

        //joins

        TypedQuery<Employee> query3 = entityManager.createQuery("SELECT e FROM Employee e WHERE e.card.isActive=true", Employee.class);
        List<Employee> resultList3 = query3.getResultList();
       // System.out.println(resultList3);

        TypedQuery<String> query4 = entityManager.createQuery("SELECT  e.fname from Employee  e", String.class); //because i am fetching name and name is a String so class type must be String.
      //  query4.getResultList().forEach(System.out::println);

        TypedQuery<Object[]> query5 = entityManager.createQuery("select e.fname , e.email from Employee e", Object[].class);
        List<Object[]> resultList4 = query5.getResultList();
     //   resultList4.forEach(e-> System.out.println(e[0] +" "+ e[1]));

        //in order to avoid sql injection we should use JPQL parameter which is make sure that expected argument and present argument is match.
        int id=2;
        TypedQuery<Employee> query6 = entityManager.createQuery("Select e from  Employee e where e.id= :input_id", Employee.class);
        query6.setParameter("input_id",id);
        List<Employee> resultList5 = query6.getResultList();
        resultList5.forEach(System.out::println);


        entityManager.close();
        entityManagerFactory.close();


    }
}
