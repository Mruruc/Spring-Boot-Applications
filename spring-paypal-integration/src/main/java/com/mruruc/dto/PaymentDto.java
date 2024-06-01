package com.mruruc.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentDto {
    private Long Id;
    private String method;
    private Double amount;
    private String currency;
    private String description;

    public PaymentDto() {}
}
