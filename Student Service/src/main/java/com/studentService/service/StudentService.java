package com.studentService.service;

import com.studentService.model.Student;
import com.studentService.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository repo;

    public List<Student> findAll() {
        return repo.findAll();
    }
    public Optional<Student> findByEmail(String email){
        return repo.findByEmail(email);
    }

    public Student addStudent(Student student){
        return repo.insert(student);
    }

    public Optional<Student> findById(String id) {
        return repo.findById(id);
    }


    public void update(Student updatedStudent) {
        Optional<Student> existingStudent = repo.findById(updatedStudent.getId());

            Student studentToUpdate = existingStudent.get();
            updatedStudent.setFirstName(updatedStudent.getFirstName());
            studentToUpdate.setLastName(updatedStudent.getLastName());
            studentToUpdate.setGender(updatedStudent.getGender());
            studentToUpdate.setAddress(updatedStudent.getAddress());
            studentToUpdate.setEmail(updatedStudent.getEmail());
            studentToUpdate.setFavoriteSubject(updatedStudent.getFavoriteSubject());
            studentToUpdate.setTotalSpentInBook(updatedStudent.getTotalSpentInBook());
            studentToUpdate.setCreated(updatedStudent.getCreated());
            repo.save(studentToUpdate);

    }


    public void deleteById(String id) {
        repo.deleteById(id);
    }
}
