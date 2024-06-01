package com.mruruc.exercise4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The @Component annotation in Spring is a class-level annotation that marks a java class as a bean.
 *  A bean is an object that is instantiated, assembled and managed by the Spring IoC conatiner.
 *
 *  When a class is annotated with @Component,
 *  Spring will automatically detect is during classpath scanning and create an instance of it as a bean.
 *  This instance can then be autowired into other beans using @Autowired annotation.
 */
@Component("service-bean")
public class Service {

    private Repository repository;
    @Autowired
    public Service(Repository repository) {
        this.repository = repository;
    }

    public void save(Product product) {
        this.repository.save(product);
    }

    public void update(Product product) {
        this.repository.update(product);
    }

    public void delete(Product product) {
        this.repository.delete(product);
    }

    public List<Product> getProducts() {
       return this.repository.getProducts();
    }
}
