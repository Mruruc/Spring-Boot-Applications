package com.mruruc.DI.repository;

import com.mruruc.DI.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    void save(Book book);
    Optional<Book> findBook(Integer id);

    List<Book> getBooks();

}
