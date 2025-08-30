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
        Account account = modelMapper.map(accountDto, Account.class );
        Account savedAccount = accountRepository.save(account);
        return modelMapper.map(savedAccount, AccountDto.class);

    }
    public AccountDto updateAccountById(Long userId,AccountDto accountDto) {
        log.info("Updating account with userId:{}", userId);
        Account account = accountRepository
                .findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with userId"));
        modelMapper.map(accountDto,account);
        account = accountRepository.save(account);
        return modelMapper.map(account, AccountDto.class);
    }

    public List<AccountDto> getAllAccounts() {
        log.info("Getting all accounts");
      return accountRepository.findAll()
              .stream()
              .map(account -> modelMapper.map(account,AccountDto.class))
              .collect(Collectors.toList());

    }


}
