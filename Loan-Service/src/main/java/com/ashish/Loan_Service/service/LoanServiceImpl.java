package com.ashish.Loan_Service.service;


import com.ashish.Loan_Service.dto.LoanRequestDto;
import com.ashish.Loan_Service.dto.LoanResponseDto;
import com.ashish.Loan_Service.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {
    private final LoanRepository loanRepository;

    @Override
    public LoanResponseDto applyLoan(LoanRequestDto loanRequestDto) {
        return null;
    }

    @Override
    public LoanResponseDto checkLoan(Long id) {
        return null;
    }

    @Override
    public List<LoanResponseDto> getAllLoan() {
        return List.of();
    }

    @Override
    public List<LoanResponseDto> getLoanByUserId(Long userId) {
        return List.of();
    }

    @Override
    public LoanResponseDto updateLoan(Long id, LoanRequestDto loanRequestDto) {
        return null;
    }
}
