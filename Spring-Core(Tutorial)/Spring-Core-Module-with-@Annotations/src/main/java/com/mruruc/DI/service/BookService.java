package com.mruruc.DI.service;

import com.mruruc.DI.db.Shelf;
import com.mruruc.DI.model.Book;
import com.mruruc.DI.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookService implements BookRepository {
    private Shelf shelf;

    @Autowired
    public BookService(Shelf shelf){
        this.shelf=new Shelf();
    }

    @Override
    public void save(Book book) {
        shelf.addBook(book);
    }

    @Override
    public Optional<Book> findBook(Integer id) {
      return shelf.getList().stream()
              .filter(book ->book.getId().equals(id))
              .findFirst();
    }

    @Override
    public List<Book> getBooks() {
        return shelf.getList();
    }
}
