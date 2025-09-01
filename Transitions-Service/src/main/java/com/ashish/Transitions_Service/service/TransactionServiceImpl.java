package com.ashish.Transitions_Service.service;

import com.ashish.Transitions_Service.Enitity.TransactionEntity;
import com.ashish.Transitions_Service.config.AccountClient;
import com.ashish.Transitions_Service.dto.TransactionRequestDto;
import com.ashish.Transitions_Service.dto.TransactionResponseDto;
import com.ashish.Transitions_Service.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountClient accountClient;

    public TransactionServiceImpl(TransactionRepository transactionRepository, AccountClient accountClient) {
        this.transactionRepository = transactionRepository;
        this.accountClient = accountClient;
    }

    @Override
    public TransactionResponseDto depositAmount(TransactionRequestDto transactionRequestDto) {
        accountClient.increaseBalance(transactionRequestDto.getFromAccountId(), transactionRequestDto.getAmount());
        TransactionEntity transactionEntity = saveTransactionAmount("DEPOSIT",transactionRequestDto,"SUCCESS");
        return mapToResponseDto(transactionEntity);
    }

    @Override
    public TransactionResponseDto withdrawAmount(TransactionRequestDto transactionRequestDto) {
        accountClient.decreaseBalance(transactionRequestDto.getFromAccountId(), transactionRequestDto.getAmount());
        TransactionEntity transactionEntity = saveTransactionAmount("WITHDRAW",transactionRequestDto,"SUCCESS");

        return mapToResponseDto(transactionEntity);
    }

    @Override
    public TransactionResponseDto transferAmount(TransactionRequestDto transactionRequestDto) {
            accountClient.increaseBalance(transactionRequestDto.getFromAccountId(), transactionRequestDto.getAmount());
            accountClient.decreaseBalance(transactionRequestDto.getToAccountId(), transactionRequestDto.getAmount());
            TransactionEntity transactionEntity = saveTransactionAmount("TRANSFER",transactionRequestDto,"SUCCESS");
            return mapToResponseDto(transactionEntity);

    }

    @Override
    public List<TransactionResponseDto> getAllTransactions(String accountId) {
        return transactionRepository
                .findByFromAccountIdOrToAccountId(accountId,accountId)
                .stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

   private TransactionEntity saveTransactionAmount(String type,TransactionRequestDto transactionRequestDto , String status) {
        TransactionEntity transactions = TransactionEntity.builder()
                .transactionType(type)
                .amount(transactionRequestDto.getAmount())
                .fromAccountId(String.valueOf(transactionRequestDto.getFromAccountId()))
                .toAccountId(String.valueOf(transactionRequestDto.getToAccountId()))
                .status(status)
                .description(transactionRequestDto.getDescription())
                .createdAt(LocalDateTime.now())
                .build();
        return transactionRepository.save(transaction);
   }

   private TransactionResponseDto mapToResponseDto(TransactionEntity tr) {
       return TransactionResponseDto.builder()
               .transactionId(String.valueOf(tr.getId()))
               .transactionType(tr.getTransactionType())
               .amount(tr.getAmount())
               .status(tr.getStatus())
               .createdAt(tr.getCreatedAt())
               .description(tr.getDescription())
               .build();
   }
}
