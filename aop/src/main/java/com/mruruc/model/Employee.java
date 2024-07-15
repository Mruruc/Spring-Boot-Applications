package com.mruruc.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "employees", schema = "public",
        uniqueConstraints = {
                @UniqueConstraint(name = "email_unique_constraint", columnNames = {"email"})
        }
)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_generator")
    @SequenceGenerator(name = "employee_id_generator", allocationSize = 1)
    @Column(name = "employee_id")
    private Long employeeId;
    @Column(columnDefinition = "VARCHAR", length = 50, name = "first_name", nullable = false, updatable = false)
    private String firstName;
    @Column(columnDefinition = "VARCHAR", length = 50, name = "last_name", nullable = false, updatable = false)
    private String lastName;
    @Column(columnDefinition = "VARCHAR", length = 75, name = "email", unique = true,nullable = false)
    private String email;
    @Column(nullable = false)
    private Double salary;
    @Column(columnDefinition = "DATE",name = "hire_date", nullable = false)
    private LocalDate hireDate;

    public Employee() {}

    public Employee(String firstName, String lastName, String email, Double salary, LocalDate hireDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public Employee(String firstName, String lastName,String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email =email;
    }
    public Employee(String firstName, Double salary) {
        this.firstName = firstName;
        this.salary = salary;
    }
}

