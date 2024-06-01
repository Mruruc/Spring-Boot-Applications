package com.mruruc.exercise4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration("config-bean")
@ComponentScan(value = "com.mruruc.exercise4")

public class App {
    public static void main(String[] args) {
        Product product1 = new Product(1L, "Product 1");
        Product product2 = new Product(2L, "Product 2");
        Product product3 = new Product(3L, "Product 3");

        ApplicationContext applicationContext= new AnnotationConfigApplicationContext(App.class);


        /*
        Service service = applicationContext.getBean(Service.class);
        service.save(product1);
        service.save(product2);
        service.save(product3);

        service.getProducts().forEach(System.out::println);
        */


        for(String bean:applicationContext.getBeanDefinitionNames()) System.out.println(bean);




    }
}
