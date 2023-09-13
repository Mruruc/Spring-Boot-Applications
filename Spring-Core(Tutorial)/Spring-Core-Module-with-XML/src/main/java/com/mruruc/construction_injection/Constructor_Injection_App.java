package com.mruruc.construction_injection;

import com.mruruc.construction_injection.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Constructor_Injection_App {
    public static void main(String[] args) {

        ApplicationContext context=
                new ClassPathXmlApplicationContext("constructor_injection.xml");

        Circle circle =(Circle) context.getBean("circle1");
        circle.calculateTheArea();
    	circle.draw();

        System.out.println("======================================");

        Circle circle2=(Circle) context.getBean("circle2");
        circle2.calculateTheArea();
        circle2.draw();

        System.out.println("============List Of Bean==============");
        Arrays.stream(context.getBeanDefinitionNames())
                                                 .forEach(bean->System.out.print(bean +","));

    }
}
