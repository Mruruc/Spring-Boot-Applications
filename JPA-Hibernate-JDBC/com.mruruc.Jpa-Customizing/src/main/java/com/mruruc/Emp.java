package com.mruruc;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Emp {
    @Id
    private Integer id;
    private String name;

    public Emp() {

    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
