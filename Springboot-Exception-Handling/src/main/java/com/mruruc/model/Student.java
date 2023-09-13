package com.mruruc.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Student_Info")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    private String facultyName;
    @OneToOne
    private StudentCard card;

    public Student() {
    }

    public Student(String firstName, String lastName, Gender gender, String facultyName,StudentCard card) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.facultyName = facultyName;
        this.card=card;
    }
    public Student(String firstName, String lastName, Gender gender, String facultyName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.facultyName = facultyName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public StudentCard getCard() {
        return card;
    }

    public void setCard(StudentCard card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", facultyName='" + facultyName + '\'' +
                ", card=" + card +
                '}';
    }
}
