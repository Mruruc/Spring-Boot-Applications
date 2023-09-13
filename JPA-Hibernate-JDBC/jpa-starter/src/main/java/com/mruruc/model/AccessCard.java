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
@Table(name = "ACCESS_CARD")
public class AccessCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Temporal(value = TemporalType.DATE)
    private Date issuedDate;
    private Boolean isActive;
    private String firmWareVersion;
    @OneToOne(mappedBy = "card")
 //   @PrimaryKeyJoinColumn
    Employee employee;


    @Override
    public String toString() {
        return "AccessCard{" +
                "id=" + id +
                ", issuedDate=" + issuedDate +
                ", isActive=" + isActive +
                ", firmWareVersion='" + firmWareVersion + '\'' +
                ", employee=" + (employee != null ? employee.getId() : "null") +
                '}';
    }
}
