package com.mruruc.DI;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(Book_Config.class, Shelf_Config.class);

        // getBeanDefinitionNames() method is a method of AbstractApplicationContext abstract class,
        //its return array of string which is hold exists bean in Configuration class.



   //    Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    //    System.out.println("==========================================");




       // System.out.println(context.getBean("getName"));
      //  System.out.println(context.getBean("Book1_id"));
     //   System.out.println(context.getBean("book1Name"));

//        System.out.println(context.getBean("book2"));

//        System.out.println(context.getBean("book1"));

     //   System.out.println(context.getBean("book3"));

    //    System.out.println(context.getBean("shelf1"));

       // System.out.println(context.getBean("shelf1"));


//        System.out.println(context.getBean("book3"));
//        System.out.println(context.getBean("book4"));
       // System.out.println(context.getBean("id"));

        System.out.println(context.getBean(Book.class));

        context.close();



    }
}
