package com.ashish.User_Service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponseDto {
    private String accessToken;
    private UserDto user;
}
