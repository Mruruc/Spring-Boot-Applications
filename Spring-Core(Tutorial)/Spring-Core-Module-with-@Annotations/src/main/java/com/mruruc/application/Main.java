package com.mruruc.application;

import com.mruruc.DI.config.AppConfig;
import com.mruruc.DI.model.Book;
import com.mruruc.DI.service.BookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Main {
    public static void main(String[] args) {

        var context=new AnnotationConfigApplicationContext(AppConfig.class);

        BookService service = context.getBean(BookService.class);

        Book book=new Book(1,"After Winter");
        Book book2=new Book(2,"Spring ");

        service.save(book);
        service.save(book2);

        service.getBooks().stream().forEach(System.out::println);
        context.close();




    }
}
