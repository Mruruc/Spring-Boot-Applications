package com.mruruc.exercise3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {

        var context=new AnnotationConfigApplicationContext(UserBean.class);

        User getUser1 = (User) context.getBean("getUser");
     //   System.out.println(getUser1);

        User getUser2 = (User) context.getBean("getUser");
       // System.out.println(getUser2);


        /*
        ObjProducer producer=new ObjProducer();
        User user2 = producer.getUser();
        User user1 = producer.getUser();
        System.out.println(user2);
        System.out.println(user1);

         */

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);

        context.close();


    }
}
