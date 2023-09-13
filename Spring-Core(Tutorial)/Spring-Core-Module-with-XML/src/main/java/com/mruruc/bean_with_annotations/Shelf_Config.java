package com.mruruc.bean_with_annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan(value = "com.mruruc.bean_with_annotations")
public class Shelf_Config {
    private Book book1;
    private Book book2;
    @Autowired
    public  Shelf_Config(Book book1, Book book2){
        this.book1=book1;
        this.book2=book2;
    }
    @Bean
    public Shelf shelf1(){
        Shelf shelf = new Shelf();
        shelf.setList(List.of(book1,book2));
        return shelf;
    }
}
