package com.mruruc.bean_with_annotations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration(value = "config_class")
public class Book_Config {

    @Bean(name ="getName")
    public String name(){
        return "Wafloo";
    }

    @Bean(name = "Book1_id")
    public Long bookId(){
        return 4645L;
    }

    @Bean
    public String book1Name(){
        return "Book1";
    }
    @Bean
    public Book book2(){
        return  new Book(57476L,"Book2");
    }
    @Bean
    public Book book1(){
        return new Book(bookId(),book1Name());
    }
    
    @Bean
    public Book book3(Long id, @Qualifier("getName") String name){
        return new Book(id,name);
    }

}
