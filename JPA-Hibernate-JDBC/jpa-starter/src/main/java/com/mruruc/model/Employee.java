package com.mruruc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "EMPLOYEE_DATA")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)               //its auto generation of primary key.
    private Integer id;
    @Column(name ="first_name",nullable = false,length = 20)
    private String fname;
    @Column(name = "last_name",length =30)
    private String last_name;
    @Temporal(TemporalType.DATE)
    private Date birth_date;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "email",unique = true,nullable = false,length = 30)
    private String email;
    @OneToOne                             //OneToOne fetched by default is EAGER
    private AccessCard card;
    //an employee can have one or many PayStub so we have to keep this/these pays-tub in a List.
    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)  //CascadeType.REMOVE= it means when I delete Employee I want to the pays-tub that belong to that employee be removed.
    private List<PayStub> listOfPayStub;
    @ManyToMany (fetch = FetchType.EAGER)        //an employee can be belonged to many group.
    @JoinTable(name = "Email_Group_Subscriptions")
    private List<EmailGroup> emailGroups;
    @Transient //basically,this field it will not be persis to column.
    private String dont_persist;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", last_name='" + last_name + '\'' +
                ", birth_date=" + birth_date +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", card=" + card +
                ", dont_persist='" + dont_persist + '\'' +
                '}';
    }

    public void addPayStub(PayStub payStub){
        this.listOfPayStub=new ArrayList<>();
        listOfPayStub.add(payStub);
    }


}
