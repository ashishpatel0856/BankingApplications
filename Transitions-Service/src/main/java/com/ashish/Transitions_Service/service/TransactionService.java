package com.ashish.Transitions_Service.service;

import com.ashish.Transitions_Service.dto.TransactionRequestDto;
import com.ashish.Transitions_Service.dto.TransactionResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {

    TransactionResponseDto depositAmount(TransactionRequestDto transactionRequestDto);
    TransactionResponseDto withdrawAmount(TransactionRequestDto transactionRequestDto);
    TransactionResponseDto transferAmount(TransactionRequestDto transactionRequestDto);
    List<TransactionResponseDto> getAllTransactions(Long accountId);
}
