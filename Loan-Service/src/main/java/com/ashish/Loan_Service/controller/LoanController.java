package com.ashish.Loan_Service.controller;

import com.ashish.Loan_Service.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoanController {
    private final LoanService loanService;
}
