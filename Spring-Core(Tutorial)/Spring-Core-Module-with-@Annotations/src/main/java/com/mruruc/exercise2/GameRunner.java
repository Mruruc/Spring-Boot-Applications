package com.mruruc.exercise2;

import org.springframework.stereotype.Component;

@Component(value = "game-runner")
public class GameRunner {
    private CommonAction action;

    public GameRunner(CommonAction action){
        this.action=action;
    }
    public void run(){
        System.out.println("Running Game: "+ action);
        action.up();
        action.down();
    }
}
