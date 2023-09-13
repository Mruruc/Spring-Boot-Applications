package com.mruruc.bean_with_annotations;

import java.util.List;

public class Shelf {
    private List<Book> list;
    public Shelf(){
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Shelf{" +
                "list=" + list +
                '}';
    }
}
