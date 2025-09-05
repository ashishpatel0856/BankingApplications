package com.ashish.Transitions_Service.dto;

import lombok.Data;

@Data
public class TransactionRequestDto {

    private String transactionType;
    private Double amount;
    private String fromAccountId;
    private String toAccountId;
    private String description;
}
