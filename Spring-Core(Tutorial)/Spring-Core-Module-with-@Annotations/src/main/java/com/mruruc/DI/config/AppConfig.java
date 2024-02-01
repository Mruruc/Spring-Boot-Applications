package com.mruruc.DI.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.mruruc.DI")
public class AppConfig {

    /*
    @Bean(
            name = "book"
    )
    public Book book(){
        return new Book(1,"After Winter");
    }

    @Bean(
            name = "shelf"
    )
    public Shelf shelf(){
        return new Shelf();
    }

    @Bean
    public BookService service(Shelf shelf){
        return new BookService(shelf);
    }
*/
}
