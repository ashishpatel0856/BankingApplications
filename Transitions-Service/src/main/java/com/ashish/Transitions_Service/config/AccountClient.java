package com.ashish.Transitions_Service.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name="ACCOUNT-SERVICE")
public interface AccountClient {

    @PostMapping("/{id}/increaseBalance")
    void increaseBalance(@PathVariable String id, @RequestParam Double amount);

    @PostMapping("/{id}/decreaseBalance")
    void decreaseBalance(@PathVariable String id, @RequestParam Double amount);
}
