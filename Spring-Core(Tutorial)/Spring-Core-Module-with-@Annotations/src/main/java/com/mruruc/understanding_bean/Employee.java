package com.mruruc.understanding_bean;

public class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }



//    public void init(){
//        System.out.println("Manager Bean is Created");
//    }


//    public void destroy(){
//        System.out.println("Manager Bean is Destroyed!");
//    }


}
