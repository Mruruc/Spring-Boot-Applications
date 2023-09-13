package com.mruruc.bean_definition_inheritance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context=
                new ClassPathXmlApplicationContext("bean_definition_inheritance.xml");

        Rectangle rectangle1 = (Rectangle) context.getBean("rectangle1");
        Rectangle rectangle2 = (Rectangle) context.getBean("rectangle2");

       // System.out.println(rectangle1);
       // System.out.println(rectangle2);

        for (String beansName: context.getBeanDefinitionNames()) {
            System.out.println(beansName);
        }

        System.out.println("================rectangle3===============");
        System.out.println(((Rectangle)context.getBean("rectangle3")));

    }
}
