package com.Mruruc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class,args);
        System.out.println();

    }
    @GetMapping("/greet")
    public GreetResponse greet(){

        GreetResponse response=new GreetResponse("Hello",
                List.of("Java","Golang","Javascript"),
                new Person("Alex",28,20012)
        );
        return response;
    }

    record Person (String name,int age,double savings){}

    record GreetResponse(
            String greet,
            List<String> favProgramingLanguage,
            Person person) {
    }

 /*   class GreetResponse{
        private final String greet;

        GreetResponse(String greet) {
            this.greet = greet;
        }

        public String getGreet() {
            return greet;
        }

        @Override
        public String toString() {
            return "GreetRespose{" +
                    "greet='" + greet + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
    }*/


}
