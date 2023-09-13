package com.mruruc.model;

import jakarta.persistence.*;

@Entity
@Table(name= "cash_card")
public class CashCard{
    @Id
    @SequenceGenerator(
            name="cash_card_id_sequence",
            sequenceName = "cash_card_id_sequence"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE
                    ,generator = "cash_card_id_sequence")

    private Long id;
    @Column(name="amount",nullable = true)
    private Double amount;

    public CashCard(){}

     public CashCard(Double amount){
        this.amount=amount;
     }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CashCard{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
