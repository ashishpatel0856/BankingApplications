package com.ashish.Loan_Service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanResponseDto {

    private Long id;
    private Long userId;
    private Double amount;
    private Double interestRate;
    private Double timeDuration;
    private String status;
}
