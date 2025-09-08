package com.ashish.Loan_Service.service;

import com.ashish.Loan_Service.dto.LoanRequestDto;
import com.ashish.Loan_Service.dto.LoanResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoanService {
    LoanResponseDto applyLoan(LoanRequestDto loanRequestDto) ;
    LoanResponseDto checkLoan(Long id);
    List<LoanResponseDto> getAllLoan();
    List<LoanResponseDto> getLoanByUserId(Long userId);
    LoanResponseDto updateLoan(Long id,LoanRequestDto loanRequestDto);
     void deletionOfLoan(Long id);
 }
