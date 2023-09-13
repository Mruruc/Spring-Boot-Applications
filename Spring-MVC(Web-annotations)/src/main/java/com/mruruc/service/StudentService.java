package com.mruruc.service;

import com.mruruc.model.Student;
import com.mruruc.repository.CustomQuery;
import com.mruruc.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService{

    private StudentRepository repo;
    private CustomQuery query;
    @Autowired
    public StudentService(StudentRepository repo,CustomQuery query){
        this.repo=repo;
        this.query=query;
    }
    public List<Student> getAllStudent(){
        return repo.findAll();
    }

    public List<Student> findByName(String name){
       return query.findStudentByName(name);
    }
    public Optional<Student> findStudentById(Integer id){
        return repo.findById(id);
    }


    public void add(Student student){
        repo.save(student);
    }

    public void deleteStudent(Integer id){
        repo.deleteById(id);
    }




}
