package com.ashish.Account_Service.repository;

import com.ashish.Account_Service.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<BankAccount, Long>{


}
