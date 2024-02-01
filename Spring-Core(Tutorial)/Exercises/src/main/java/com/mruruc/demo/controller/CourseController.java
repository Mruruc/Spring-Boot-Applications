package com.mruruc.demo.controller;

import com.mruruc.demo.db.Courses;
import com.mruruc.demo.model.Course;
import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private Course course1;
    @Autowired
    private Course course2;
    @Autowired
    private Course course3;

    private final Courses courses;

    @Autowired
    public CourseController(Courses courses){
        this.courses=courses;
    }

    @PostConstruct
    public void fillCourses() {
        courses.addCourse(course1); // Add course1 to Courses
        courses.addCourse(course2); // Add course2 to Courses
        courses.addCourse(course3);
    }

    @GetMapping("/")
    public List<Course> getAllCourses(){
        return courses.getCourses();
    }
}
