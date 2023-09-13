package com.mruruc.Initializing_collections;

import java.util.List;

public class Shelf {
    private List<Book> bookList;

    public Shelf() {
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void getListOfBook() {
        this.bookList.forEach(book -> System.out.println(book));
    }

}
