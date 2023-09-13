package com.mruruc.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PayStub {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date payPeriodStart;
    @Column(name = "end_date")
    private Date getPayPeriodEnd;
    private Double salary;
    @ManyToOne     //an employee can have one or many pays-tub
  /*This annotation indicates that a single instance of the entity in which this annotation
  is used can be associated with multiple instances of the other entity(Employee)*/
    @JoinColumn(name = "employee_id")   //its allows us to customize the foreign key name.
    private Employee employee;

    @Override
    public String toString() {
        return "PayStub{" +
                "id=" + id +
                ", payPeriodStart=" + payPeriodStart +
                ", getPayPeriodEnd=" + getPayPeriodEnd +
                ", salary=" + salary +
                ", employee=" + (employee != null ? employee.getFname() : "null") +
                '}';
    }
}
