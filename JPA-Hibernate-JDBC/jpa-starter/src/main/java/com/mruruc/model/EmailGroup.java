package com.mruruc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Email_Group")
public class EmailGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @ManyToMany(mappedBy = "emailGroups")         //a group can have many member.
    private List<Employee> groupMember;


    @Override
    public String toString() {
        return "EmailGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
