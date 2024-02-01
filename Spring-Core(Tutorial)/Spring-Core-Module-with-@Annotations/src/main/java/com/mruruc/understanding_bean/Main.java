package com.mruruc.understanding_bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        var context= new AnnotationConfigApplicationContext(Employee_Config.class);

           System.out.println(context.getBean("Security"));
        // System.out.println(context.getBean("manager"));


     /*   System.out.println("=======Testing Bean Aliases=========");
        System.out.println(context.getBean("garden"));
        System.out.println(context.getBean("gardener"));
        System.out.println(context.getBean("Mr_Atolos"));*/

       // System.out.println(context.getBean("teacher"));

       // Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);

        context.close();


    }
}
