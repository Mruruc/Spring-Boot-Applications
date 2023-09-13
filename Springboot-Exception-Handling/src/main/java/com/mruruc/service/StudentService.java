package com.mruruc.service;

import com.mruruc.model.Student;
import com.mruruc.exception.NotFoundException;
import com.mruruc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository repo;
    @Autowired
    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> studentList(){
        return repo.findAll();
    }

    public Optional<Student> getStudentById(Integer id){
        if(repo.existsById(id)){
            return repo.findById(id);
        }
        throw new NotFoundException("Specified Student Id Does Not Exist!");
    }
    public Student addStudent(Student student){
        return repo.save(student);
    }
    public boolean isExist(Integer id){
        return repo.existsById(id);
    }

    public Student updateStudent(Integer id, Student student) {
        Optional<Student> byId = repo.findById(id);

        if(byId.isPresent()){
            byId.get().setFirstName(student.getFirstName());
            byId.get().setLastName(student.getLastName());
            byId.get().setGender(student.getGender());
            byId.get().setFacultyName(student.getFacultyName());
            return repo.save(byId.get());
        }
        throw new NotFoundException("Specified Student Id Does Not Exist!");
    }

    public void deleteStudent(Integer id) {
        Optional<Student> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.deleteById(id);
            return;
        }
        throw new NotFoundException("Specified Student Id Does Not Exist!");
    }

}
