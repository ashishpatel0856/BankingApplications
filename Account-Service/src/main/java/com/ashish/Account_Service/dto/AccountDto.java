package com.ashish.Account_Service.dto;

import com.ashish.Account_Service.entity.AccountType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AccountDto {

    private Long id;
    private Long userId;
    private String accountNumber;
    private AccountType accountType;
    private Double balance;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String bankName;
}
