package com.mruruc.student;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="student",
      uniqueConstraints = {@UniqueConstraint(name ="student_email_unique",
              columnNames ="email" )}
)
public class Student {
    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName="student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy =SEQUENCE,
            generator="student_sequence"
    )
    @Column(name="id",
            updatable = false
    )
    private Long id;
    @Column(name="first_name",nullable = false,columnDefinition ="TEXT",length = 20)
    private String firstName;
    @Column(name="last_name",nullable = false,columnDefinition ="varchar",length = 20)
    private String lastName;
    @Column(name="age",nullable = false)
    private Integer age;
    @Column(name="email",nullable = false,columnDefinition ="TEXT",
            length =50)
    private String email;

    public Student(String firstName, String lastName,
                   Integer age,String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email=email;
    }

    public Student() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
