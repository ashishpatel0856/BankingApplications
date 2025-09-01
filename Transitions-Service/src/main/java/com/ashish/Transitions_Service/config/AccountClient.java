package com.ashish.Transitions_Service.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="ACCOUNT-SERVICE")
public interface AccountClient {

    @PostMapping("/api/v1/accounts/{id}/increaseBalance")
    void increaseBalance(@PathVariable Long id, @RequestParam Double amount);

    @PostMapping("/api/v1/accounts/{id}/decreaseBalance")
    void decreaseBalance(@PathVariable Long id, @RequestParam Double amount);
}
