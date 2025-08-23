package com.ashish.Account_Service.repository;

import com.ashish.Account_Service.dto.AccountDto;
import com.ashish.Account_Service.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long>{


}
