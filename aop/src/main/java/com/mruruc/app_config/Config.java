package com.mruruc.app_config;

import com.mruruc.model.Employee;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.mruruc")
@EnableAspectJAutoProxy
public class Config {

    @Bean(name = "entityClazz")
    public Class<?> entityClazz() {
        return Employee.class;
    }

    @Bean(name = "entityManagerFactory", destroyMethod = "close")
    @Scope(scopeName = "singleton")
    public EntityManagerFactory getEmf() {
        return Persistence.createEntityManagerFactory("persistence-unit");
    }

}
