package com.mruruc.Initializing_collections;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=
                new ClassPathXmlApplicationContext("initializing_collections.xml");

        Shelf shelf=(Shelf) context.getBean("Biographic-Shelf");
        shelf.getListOfBook();

    }
}
