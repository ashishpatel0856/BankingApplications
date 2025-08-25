package com.ashish.Account_Service.controller;

import com.ashish.Account_Service.dto.AccountDto;
import com.ashish.Account_Service.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<AccountDto> createNewAccount(@RequestBody AccountDto accountDto) {

        AccountDto newAccountDto = accountService.createNewAccount(accountDto);
        newAccountDto.setUserId(accountDto.getUserId());
        return new ResponseEntity<>(newAccountDto, HttpStatus.CREATED);

    }

    @PutMapping("/{userId}")
    public ResponseEntity<AccountDto> updateAccountById(@PathVariable Long userId, @RequestBody AccountDto accountDto) {
        AccountDto updatedAccountDto = accountService.updateAccountById(userId, accountDto);
        return new ResponseEntity<>(updatedAccountDto, HttpStatus.OK);

    }

    @GetMapping("/all")
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accountDtos = accountService.getAllAccounts();
        return new ResponseEntity<>(accountDtos, HttpStatus.OK);
    }


}
