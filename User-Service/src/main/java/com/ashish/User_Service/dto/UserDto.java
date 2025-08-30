package com.ashish.User_Service.dto;

import com.ashish.User_Service.entity.KycStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String adharcardNumber;
    private String address;
    private LocalDate dob;
    private KycStatus kycStatus;
}
