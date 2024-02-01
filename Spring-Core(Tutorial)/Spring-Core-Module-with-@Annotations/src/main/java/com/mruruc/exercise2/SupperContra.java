package com.mruruc.exercise2;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SupperContra implements CommonAction{
    public SupperContra(){}
    @Override
    public void up(){
        System.out.println("Jump");
    }
    @Override
    public void down(){
        System.out.println("Go Back");
    }

    @Override
    public String toString() {
        return "SupperContra";
    }
}
