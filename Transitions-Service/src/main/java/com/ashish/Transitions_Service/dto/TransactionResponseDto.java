package com.ashish.Transitions_Service.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TransactionResponseDto {

    private String transactionId;
    private String transactionType;
    private Double amount;
    private String status;
    private LocalDateTime createdAt;
    private String description;


}
