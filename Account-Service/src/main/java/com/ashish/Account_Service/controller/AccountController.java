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

    @PutMapping("/update")
    public ResponseEntity<AccountDto> updateAccountById( @RequestBody AccountDto accountDto) {
        AccountDto updatedAccountDto = accountService.updateAccountById(accountDto);
        return new ResponseEntity<>(updatedAccountDto, HttpStatus.OK);

    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<List<AccountDto>> getAllAccounts(@PathVariable Long userId) {
        List<AccountDto> accounts = accountService.getAllAccounts(userId);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
    @PostMapping("/{id}/increaseBalance")
    public ResponseEntity<Void> increaseBalance(@PathVariable String id, @RequestParam Double amount) {
        accountService.increaseBalance(id, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{id}/decreaseBalance")
    public ResponseEntity<Void> decreaseBalance(@PathVariable String id, @RequestParam Double amount) {
        accountService.decreaseBalance(id, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    }
