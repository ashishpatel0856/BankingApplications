package com.ashish.Account_Service.service;

import com.ashish.Account_Service.dto.AccountDto;
import com.ashish.Account_Service.entity.Account;
import com.ashish.Account_Service.exception.ResourceNotFoundException;
import com.ashish.Account_Service.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService {

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public AccountDto createNewAccount(AccountDto accountDto) {
        log.info("Creating account with userId:{}", accountDto.getUserId());

        if (!checkUserExists(accountDto.getUserId())) {
            throw new ResourceNotFoundException("User not found with id: " + accountDto.getUserId());
        }
        Account account = modelMapper.map(accountDto, Account.class );
        // generate random account number
        account.setAccountNumber("ACC"+System.currentTimeMillis());
        account.setBalance(accountDto.getBalance() != null ? accountDto.getBalance() : 0.0);
        Account savedAccount = accountRepository.save(account);

        return modelMapper.map(savedAccount, AccountDto.class);

    }

    private boolean checkUserExists(Long userId) {
        return userId != null && userId >0;
    }

    public AccountDto updateAccountById(AccountDto accountDto) {
        log.info("Updating account with userId:{}", accountDto.getId());
        Account account = accountRepository
                .findById(accountDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with userId"));

        if(accountDto.getBalance() != null){
            account.setBalance(accountDto.getBalance());
        }
        if(accountDto.getAccountType() != null){
            account.setAccountType(accountDto.getAccountType());
        }
        Account  updateaccount = accountRepository.save(account);
        return modelMapper.map(updateaccount, AccountDto.class);
    }

    public List<AccountDto> getAllAccounts(Long userId) {
        log.info("Getting all accounts");
        List<Account> accounts = accountRepository.findByUserId(userId);

        return accounts
              .stream()
              .map(account -> modelMapper.map(account,AccountDto.class))
              .collect(Collectors.toList());
    }


    public void increaseBalance(String accountId, Double amount) {
        Account account = accountRepository.findByAccountNumber(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
    }

    public void decreaseBalance(String accountId, Double amount) {
        Account account = accountRepository.findByAccountNumber(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);
    }
}
