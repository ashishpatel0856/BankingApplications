package com.ashish.Account_Service.dto;

import lombok.Data;

@Data
public class AccountDto {

    private String accountNumber;
    private String accountType;
    private double balance;
    private Long userId;
    private String BankName;
}
