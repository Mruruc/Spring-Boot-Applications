package com.mruruc.controller;

import com.mruruc.model.Student;
import com.mruruc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class StudentController {
    private  StudentService service;
    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }
    @GetMapping(path = "/students",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> studentList(){
        List<Student> students = service.studentList();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable("id") Integer studentId){
        Optional<Student> student = service.getStudentById(studentId);
            return new ResponseEntity<>(student,HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,String>> deleteStudentById(final @PathVariable Integer id){
         service.deleteStudent(id);

        Map<String,String> response=new HashMap<>();
        response.put("status","REMOVED");
        response.put("message","Student with Id: " + id + " REMOVED");
        response.put("timestamp", LocalDateTime.now().toString());

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
