package com.studentService.repository;

import com.studentService.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository
        extends MongoRepository<Student,String> {

    Optional<Student> findByEmail(String email);

  /*  @Query("{'firstName': ?0, 'lastName': ?1, 'gender': ?2," +
            " 'address': ?3, 'email': ?4, " +
            "'favoriteSubject': ?5, " +
            "'totalSpentInBook': ?6, 'created': ?7}")
    void addStudent(String firstName, String lastName, Gender gender,
                    Address address, String email, List<String> favoriteSubject,
                    BigDecimal totalSpentInBook, LocalDateTime created);*/


}
