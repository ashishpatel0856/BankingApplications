package com.ashish.Transitions_Service.repository;

import com.ashish.Transitions_Service.Enitity.TransactionEntity;
import jakarta.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionEntity,Long> {
    List<TransactionEntity> findByFromAccountIdOrToAccountId(String fromAccountId, String toAccountId);
}
