package com.ashish.User_Service.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiError {
    private LocalDateTime timeStamp;
    private String error;
    private HttpStatus StatusCode;

    public ApiError () {
        this.timeStamp = LocalDateTime.now();
    }
    public ApiError(String error, HttpStatus statusCode) {
        this();
        this.error = error;
        StatusCode = statusCode;
    }
}
