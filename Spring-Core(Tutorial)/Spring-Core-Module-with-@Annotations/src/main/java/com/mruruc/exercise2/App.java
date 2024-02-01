package com.mruruc.exercise2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration(
        value = "app-bean"
)
@ComponentScan("com.mruruc.exercise2")
public class App {

    public static void main(String[] args) {

        try(var context=new AnnotationConfigApplicationContext(App.class)){
        //    Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

//            CommonAction action=new MarioGame();
//            GameRunner gameRunner=new GameRunner(action);

            MarioGame bean = (MarioGame) context.getBean("mario-game");
            MarioGame bean2 = (MarioGame) context.getBean(MarioGame.class);
            System.out.println("Magic1: "+bean2.hashCode());
            System.out.println("Magic: "+bean.hashCode());

         //   GameRunner gameRunner1= (GameRunner) context.getBean("game-runner");
            GameRunner gameRunner2 = (GameRunner) context.getBean(GameRunner.class);
            gameRunner2.run();

        }





    }
}
