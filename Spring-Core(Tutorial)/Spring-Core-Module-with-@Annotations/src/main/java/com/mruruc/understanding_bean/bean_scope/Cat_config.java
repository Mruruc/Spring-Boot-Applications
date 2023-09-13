package com.mruruc.understanding_bean.bean_scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Cat_config {

    /**
     *Singleton (default): This is the default scope. For a single Spring IoC container,only one instance of the bean is created.
     *  Singleton scope is appropriate for stateless beans where the same instance can be used by different clients.
     */

    @Bean
    @Scope(scopeName = "singleton")
    public Cat cat1(){
        return new Cat();
    }

    /**
    *  Prototype: A new instance is created each time a bean is requested from the container.
     * This scope is useful for stateful beans where the instance variables can contain client-specific information that is not shareable.
    * */

    @Bean
    @Scope(scopeName = "prototype")
    public Cat cat2(){
        return new Cat();
    }
}
