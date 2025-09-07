package com.ashish.Loan_Service.repository;

import com.ashish.Loan_Service.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Long , LoanEntity> {
}
