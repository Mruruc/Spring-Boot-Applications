package com.mruruc.demo.appConfig;

import com.mruruc.demo.db.Courses;
import com.mruruc.demo.model.Course;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${course.id}")
    private Integer id;

    @Value("${course.name}")
    private String name;

    @Value("${course.author}")
    private String author;


    @Bean
    public Course course1(){
        return new Course(1,"Spring In Depth","Mr.Doe");
    }

    @Bean
    public Course course2(){
        return new Course(2,"After Winter","Mr.Waffle");
    }


    @Bean
    public Course course3(){
        return new Course(id,name,author);
    }
    @Bean
    public Courses courses() {
        return new Courses();
    }


}
