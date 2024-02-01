package com.mruruc.DI.db;

import com.mruruc.DI.model.Book;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Component
public class Shelf {
    private List<Book> list;
    public Shelf(){
        this.list=new LinkedList<>();
    }

    public List<Book> getList() {
        return Collections.unmodifiableList(list);
    }

    public void addBook(Book book) {
        list.add(book);
    }

    @Override
    public String toString() {
        return "Shelf{" +
                "list=" + list +
                '}';
    }
}
