package com.mruruc.exercise;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


import java.util.Arrays;
@Configuration
@ComponentScan(value = "com.mruruc.exercise")
public class App {
    public static void main(String[] args) {

        ///==============Without Spring Framework ============

//        DataService dataServicePostgreSql=new PostgreSqlDataService();
//
//        DataService dataServiceMongoDb=new MongoDbDataService();
//
//        Business business=new Business(dataServicePostgreSql);
//        int max = business.findMax();
//
//        System.out.println(max);




        ///==============WithSpring Framework ============


        var context=new AnnotationConfigApplicationContext(App.class);

       Arrays.stream( context.getBeanDefinitionNames()).forEach(System.out::println);


//        Business bean = context.getBean(Business.class);
//
//        int max = bean.findMax();
//        System.out.println(max);
//
//       PostgreSqlDataService postgreSqlDataService =  context.getBean(PostgreSqlDataService.class);
//        Arrays.stream(postgreSqlDataService.retrieveData()).forEach(s-> System.out.print(s +" "));

        context.close();

    }
}
