package com.mruruc.exercise4;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Component(value = "db-bean")
public class Db implements Repository{
    private List<Product> products;

    public Db(){
        this.products=new LinkedList<>();
    }

    @Override
    public void save(Product product) {
        this.products.add(product);
    }
    @Override
    public void update(Product product) {
        for(Product p: this.products){
            if(p.getProductId().equals(product.getProductId())){
                p.setProductTitle(product.getProductTitle());
            }
        }
    }

    @Override
    public List<Product> getProducts() {
        return Collections.unmodifiableList(this.products);
    }
    @Override
    public void delete(Product product) {
        this.products.remove(product);
    }
}
