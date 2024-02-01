package com.mruruc.exercise2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(
        value = "mario-game"
)
@Scope(scopeName = "prototype")
@Qualifier("mario-qualifier")
public class MarioGame implements CommonAction{
    public void up(){
        System.out.println("Jump");
    }
    public void down(){
        System.out.println("Go Back");
    }

    @Override
    public String toString() {
        return "MarioGame ";
    }
}
