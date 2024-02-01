package com.mruruc.understanding_bean.bean_scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context= new AnnotationConfigApplicationContext(Cat_config.class);

        System.out.println("==================Singleton=======================");

        System.out.println("cat1.1: "+context.getBean("cat1").hashCode());
        System.out.println("cat1.2: "+context.getBean("cat1").hashCode());
        System.out.println("cat1.3: " +context.getBean("cat1").hashCode());

        System.out.println("==================Prototype=======================");

        System.out.println("cat2.1: "+context.getBean("cat2").hashCode());
        System.out.println("cat2.2: "+context.getBean("cat2").hashCode());
        System.out.println("cat2.3: "+context.getBean("cat2").hashCode());

        context.close();
    }
}
