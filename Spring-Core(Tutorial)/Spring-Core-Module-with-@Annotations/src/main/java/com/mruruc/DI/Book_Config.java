package com.mruruc.DI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration(value = "config_class")
public class Book_Config {

    @Bean(name ="getName")
    public String name(){
        return "Wafloo";
    }

    @Bean (name = "bookId")
    public Long bookId(){
        return 4645L;
    }

    @Bean()
    public String book1Name(){
        return "Shipoo_Life";
    }
    @Bean()
    @Primary
    public Book book2(){
        return  new Book(57476L,"Neloo-Bombelo");
    }
    @Bean
    public Book book1(){
        return new Book(bookId(),book1Name());
    }
    @Bean(name ="id")
    public Long id(){
        return 111111L;
    }

    @Bean(name = "book3")
    public Book book3(Long bookId, String getName){
        return new Book(bookId,getName);
    }

    @Bean(name = "book4")
    public Book book4( @Qualifier("id")Long id, @Qualifier("book1Name")  String name){
        return new Book(id,name);
    }



}
