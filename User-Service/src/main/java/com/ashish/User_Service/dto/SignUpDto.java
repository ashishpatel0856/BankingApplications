package com.ashish.User_Service.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SignUpDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private String adharcardNumber;
    private String address;
    private LocalDate dob;
}
