package com.ashish.Transitions_Service.service;

import com.ashish.Transitions_Service.dto.TransactionRequestDto;
import com.ashish.Transitions_Service.dto.TransactionResponseDto;
import com.ashish.Transitions_Service.exceptions.InsufficientBalanceException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {

    TransactionResponseDto depositAmount(TransactionRequestDto transactionRequestDto);
    TransactionResponseDto withdrawAmount(TransactionRequestDto transactionRequestDto) throws InsufficientBalanceException;
    TransactionResponseDto transferAmount(TransactionRequestDto transactionRequestDto);
    List<TransactionResponseDto> getAllTransactions(String accountId);

}
