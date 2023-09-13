package com.mruruc.Injecting_Objects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context=
                new ClassPathXmlApplicationContext("injecting_objects.xml");

        Rectangle rectangle =
                (Rectangle) context.getBean("rectangle");

        System.out.println(rectangle);
        System.out.println("================Rectangle2======================");
        Object rectangle2 = context.getBean("rectangle2");
        System.out.println(rectangle2);
        System.out.println("======================List Of Bean=========");
        for(String s: context.getBeanDefinitionNames()){
            System.out.print(s +" ->");
        }

    }
}
