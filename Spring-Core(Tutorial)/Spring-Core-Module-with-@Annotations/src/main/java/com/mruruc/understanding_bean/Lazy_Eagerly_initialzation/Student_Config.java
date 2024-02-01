package com.mruruc.understanding_bean.Lazy_Eagerly_initialzation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
@Configuration
public class Student_Config {

    /**
     * Eager Initialization: By default, Spring beans are eagerly initialized,
     * meaning that they are created and configured at startup of the application context.
     * This is useful when your application needs to have everything ready to go as soon as it starts,
     * but it can slow down the startup time if you have a large number of beans or heavy startup logic.
     */

    @Bean
    public Student student1(){
        return new Student("Wafloo");
    }


    /**
     * Lazy Initialization: On the other hand, when a bean is lazily initialized,
     * it is created and configured only when it is first requested. Until then, the bean does not exist.
     * This strategy can help spread out the cost of initialization and reduce startup time.
     * However, the first request to the lazy bean may experience a delay while the bean is being created
     *
     * To mark a bean as lazily initialized in Spring,
     * you can use the @Lazy annotation or set the lazy-init attribute in XML configuration.
     */

    @Bean(value = "student2")
    @Lazy
    public Student student2(){
        return new Student("Neloo");
    }


}
