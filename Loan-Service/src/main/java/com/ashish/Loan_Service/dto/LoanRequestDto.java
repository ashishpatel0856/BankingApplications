package com.ashish.Loan_Service.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanRequestDto {

    @NotNull(message = "userId is required")
    private Long userId;


    @NotNull(message = "Loan amount is required")
    @Min(value =10000,message = "minimum amount is 10000")
    private Double amount;


    @NotNull(message = "loan durations is required")
    @Min(value = 1,message = "durations atleast 1 months")
    private Integer loanDuration;

    @NotNull
    @DecimalMin(value="5.0",message = "interest rate must be >=5.0")
    @DecimalMax(value="25.0",message = "interest rate must be <=5.0")
    private Double interestRate;


    @NotBlank(message = "Loan type is required")
    private String loanType;
}
