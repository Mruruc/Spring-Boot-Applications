package com.mruruc.exercise4;

import org.springframework.stereotype.Component;

import java.util.List;


public interface Repository {
    void save(Product product);
    void delete(Product product);
    void update(Product product);
    List<Product> getProducts();
}
