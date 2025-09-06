package com.ashish.Transitions_Service.controller;


import com.ashish.Transitions_Service.dto.TransactionRequestDto;
import com.ashish.Transitions_Service.dto.TransactionResponseDto;
import com.ashish.Transitions_Service.exceptions.InsufficientBalanceException;
import com.ashish.Transitions_Service.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @PostMapping("/deposit")
    public ResponseEntity<TransactionResponseDto> depositAmount(@RequestBody TransactionRequestDto transactionRequestDto) {
        TransactionResponseDto transactionResponseDto = transactionService.depositAmount(transactionRequestDto);
        return ResponseEntity.ok(transactionResponseDto);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<TransactionResponseDto> withdrawAmount(@RequestBody TransactionRequestDto transactionRequestDto) throws InsufficientBalanceException {
        return ResponseEntity.ok(transactionService.withdrawAmount(transactionRequestDto));
    }

    @PostMapping("/transfer")
    public ResponseEntity<TransactionResponseDto> transferAmount(@RequestBody TransactionRequestDto transactionRequestDto) {
        return ResponseEntity.ok(transactionService.transferAmount(transactionRequestDto));
    }

    @GetMapping("/history/{accountId}")
    public ResponseEntity<List<TransactionResponseDto>> getTransactionHistory(@PathVariable String accountId) {
        return ResponseEntity.ok(transactionService.getAllTransactions(accountId));
    }
}
