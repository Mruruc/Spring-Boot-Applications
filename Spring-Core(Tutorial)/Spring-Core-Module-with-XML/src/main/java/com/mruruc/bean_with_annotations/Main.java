package com.mruruc.bean_with_annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context
                =new AnnotationConfigApplicationContext(Book_Config.class,Shelf_Config.class);

        // getBeanDefinitionNames() method is a method of AbstractApplicationContext abstract class,
        //its return array of string which is hold exists bean in Configuration class.

         String[] beanDefinitionNames = context.getBeanDefinitionNames();

       Arrays.stream(beanDefinitionNames).forEach(System.out::println);
        System.out.println("==========================================");

//        System.out.println(context.getBean("getName"));
//        System.out.println(context.getBean("Book1 id"));
//        System.out.println(context.getBean("book1Name"));
//
//        System.out.println(context.getBean("book2"));
//
//        System.out.println(context.getBean("book1"));



    //    System.out.println(context.getBean("book3"));

        System.out.println(context.getBean("shelf1"));

        context.close();



    }
}
