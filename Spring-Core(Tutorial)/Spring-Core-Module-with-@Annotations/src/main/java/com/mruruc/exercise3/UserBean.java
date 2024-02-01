package com.mruruc.exercise3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration(
        value = "userBean-Config"
)
public class UserBean {


    @Bean(
            name = "getUser"
    )
    @Scope(
            scopeName = "prototype"
    )
    public User user(){
        return new User("Mr.Doe");
    }

}
