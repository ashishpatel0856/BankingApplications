package com.ashish.User_Service.controller;

import com.ashish.User_Service.dto.AuthResponseDto;
import com.ashish.User_Service.dto.LoginDto;
import com.ashish.User_Service.dto.SignUpDto;
import com.ashish.User_Service.dto.UserDto;
import com.ashish.User_Service.service.AuthService;

import com.ashish.User_Service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserController {
    private final AuthService authService;
    private final UserService userService;


    @PostMapping("/signUp")
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpDto signUpDto) throws BadRequestException {
        UserDto userDto = authService.signUp(signUpDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto) throws BadRequestException {
        return ResponseEntity.ok(authService.login(loginDto));

    }

    @GetMapping("/{id")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id) throws BadRequestException {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUserById(@PathVariable Long id, @RequestBody UserDto userDto) throws BadRequestException {
        return ResponseEntity.ok(userService.updateUserById(id, userDto));
    }

    @PutMapping("/{id}/kyc")
    public ResponseEntity<UserDto> verifyKyc(@PathVariable Long id) {
        return ResponseEntity.ok(userService.verifyKyc(id));
    }
}
