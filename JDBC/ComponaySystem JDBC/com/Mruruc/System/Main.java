package com.Mruruc.System;

public class Main {
    public static void main(String[] args) {


        Employee employee1=new Employee(1,"Waflo","Maflo","waflo@gmail.com");
        Employee employee2=  new Employee(2,"Shipo","Maflo","shipo@gmail.com");

        CompanySystem system=new CompanySystem();
        system.add(employee1);
        system.add(employee2);

        system.read();



    }
}
