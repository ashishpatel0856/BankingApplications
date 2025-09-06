package com.ashish.Transitions_Service.config;

import com.ashish.Account_Service.dto.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name="ACCOUNT-SERVICE")
public interface AccountClient {

    @PostMapping("/{id}/increaseBalance")
    void increaseBalance(@PathVariable String id, @RequestParam Double amount);

    @PostMapping("/{id}/decreaseBalance")
    void decreaseBalance(@PathVariable String id, @RequestParam Double amount);


    @GetMapping("/{id}")
    AccountDto getAccountById(@PathVariable("id") String id);
}
