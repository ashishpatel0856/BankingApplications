package com.ashish.Transitions_Service.dto;

import lombok.Data;

@Data
public class TransactionRequestDto {

    private String transactionType;
    private Double amount;
    private Long fromAccountId;
    private Long toAccountId;
    private String description;
}
