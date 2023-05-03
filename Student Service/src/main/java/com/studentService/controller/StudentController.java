package com.studentService.controller;

import com.studentService.model.Student;
import com.studentService.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class StudentController {
    @Autowired
    private final StudentService service;

    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        return service.findAll();
    }
    @GetMapping("/getById/{id}")
   public Optional<Student> getById(@PathVariable String id){
        if(service.findById(id).isPresent()){
            return service.findById(id);
        }
        else{
            throw new NoSuchElementException("Not Valid Id!");
        }
    }

    @PostMapping("/addStudent")
    public ResponseEntity<HttpStatus> addStudent(@RequestBody Student student) {
        if (service.findByEmail(student.getEmail()).isPresent()) {
            System.out.println(student + "is already Exists!");
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } else {
            service.addStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    }
    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<HttpStatus> updateStudent(@PathVariable String id,@RequestBody Student student) {
       if(service.findById(id).isPresent()){
           service.update(student);
           return ResponseEntity.status(HttpStatus.ACCEPTED).build();
       }
       else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
    }

    @DeleteMapping("deleteStudent/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable String id){
        if(service.findById(id).isPresent()){
             service.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }


//    @PostMapping("/addStudent")
//    public HttpStatus insertStudent(Student student){
//       service.findByEmail(student.getEmail()).ifPresentOrElse(s -> {
//           System.out.println(student + "is already Exists!");
//           return HttpStatus.CONFLICT;
//
//
//       }, ()->{
//           service.addStudent(student);
//           return HttpStatus.CREATED;
//               }
//       );
//       return HttpStatus.INTERNAL_SERVER_ERROR;
//    }

}
