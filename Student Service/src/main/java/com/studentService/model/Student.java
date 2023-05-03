package com.studentService.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document()
@Collation(value = "Student")
public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Address address;
    @Indexed(unique = true)
    private String email;
    private List<String> favoriteSubject;
    private BigDecimal totalSpentInBook;
    private LocalDateTime created;

    public Student(String firstName, String lastName,
                   Gender gender, Address address,
                   String email, List<String> favoriteSubject,
                   BigDecimal totalSpentInBook, LocalDateTime created) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.favoriteSubject = favoriteSubject;
        this.totalSpentInBook = totalSpentInBook;
        this.created = created;
    }
}
