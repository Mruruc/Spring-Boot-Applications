package com.mruruc.understanding_bean.Lazy_Eagerly_initialzation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        var context=new AnnotationConfigApplicationContext(Student_Config.class);

        System.out.println("==============Before calling Lazy initialize Bean========= ");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

          Student student1 = (Student) context.getBean("student1");
        System.out.println(student1);

        System.out.println("==============After calling Lazy initialize Bean========= ");

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        // Student student2= (Student) context.getBean("student2");
       // System.out.println(student2);


        context.close();

    }
}
