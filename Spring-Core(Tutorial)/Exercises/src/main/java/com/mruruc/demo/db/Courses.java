package com.mruruc.demo.db;

import com.mruruc.demo.model.Course;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
@Component
public class Courses {
    private List<Course> list;

    public Courses(){
        this.list=new LinkedList<>();
    }

    public List<Course> getCourses(){
        return Collections.unmodifiableList(list);
    }

    public void addCourse(Course course){
         list.addLast(course);
    }
}
