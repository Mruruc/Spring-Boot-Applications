package com.mruruc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Student_Card")
public class StudentCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Boolean isActive;
    @Temporal(value = TemporalType.DATE)
    private LocalDate issueDate;
    private LocalDate expireDate;
    @OneToOne(mappedBy = "card")
    @JsonIgnore
    private Student student;

    public StudentCard() {
    }

    public StudentCard(Boolean isActive, LocalDate issueDate, LocalDate expireDate,Student student) {
        this.isActive = isActive;
        this.issueDate = issueDate;
        this.expireDate = expireDate;
        this.student=student;
    }
    public StudentCard(Boolean isActive, LocalDate issueDate, LocalDate expireDate) {
        this.isActive = isActive;
        this.issueDate = issueDate;
        this.expireDate = expireDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "StudentCard{" +
                "id=" + id +
                ", isActive=" + isActive +
                ", issueDate=" + issueDate +
                ", expireDate=" + expireDate +
                ", student=" + student +
                '}';
    }
}
