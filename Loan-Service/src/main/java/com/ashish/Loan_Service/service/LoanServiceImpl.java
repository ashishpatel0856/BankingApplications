package com.ashish.Loan_Service.service;


import com.ashish.Loan_Service.dto.LoanRequestDto;
import com.ashish.Loan_Service.dto.LoanResponseDto;
import com.ashish.Loan_Service.entity.LoanEntity;
import com.ashish.Loan_Service.repository.LoanRepository;
import exceptions.LoanNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoanServiceImpl implements LoanService {
    private final LoanRepository loanRepository;

    @Override
    public LoanResponseDto applyLoan(LoanRequestDto loanRequestDto) {
        log.info("applying loan:{}", loanRequestDto.getUserId());
        LoanEntity loanEntity = new LoanEntity();
        loanEntity.setUserId(loanRequestDto.getUserId());
        loanEntity.setAmount(loanRequestDto.getAmount());
        loanEntity.setInterestRate(loanRequestDto.getInterestRate());
        loanEntity.setLoanDuration(loanRequestDto.getLoanDuration());
        loanEntity.setStartDate(LocalDate.now());
        loanEntity.setStatus("PENDING");
        loanEntity.setLoanType(loanRequestDto.getLoanType());
        LoanEntity loan = loanRepository.save(loanEntity);
        return toResponse(loan);


    }

    @Override
    public LoanResponseDto checkLoan(Long id) {
        log.info("checking loan by id:{}", id);
        LoanEntity loanEntity = loanRepository.findById(id)
                .orElseThrow(() -> new LoanNotFoundException("Loan is not found with id" +id));
        return toResponse(loanEntity);

    }

    @Override
    public List<LoanResponseDto> getAllLoan() {
        return loanRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());


    }

    @Override
    public List<LoanResponseDto> getLoanByUserId(Long userId) {
        return loanRepository.findByUserId(userId)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public LoanResponseDto updateLoan(Long id, LoanRequestDto loanRequestDto) {
        LoanEntity loan = loanRepository.findById(id)
                .orElseThrow(() -> new LoanNotFoundException("Loan is not found with id" +id));
        loan.setAmount(loanRequestDto.getAmount());
        loan.setInterestRate(loanRequestDto.getInterestRate());
        loan.setLoanDuration(loanRequestDto.getLoanDuration());
        loan.setLoanType(loanRequestDto.getLoanType());
        loan.setStatus("UPDATED");

        LoanEntity updateLoanEntity = loanRepository.save(loan);
        return toResponse(updateLoanEntity);
    }

    @Override
    public void deletionOfLoan(Long id) {
        if (!loanRepository.existsById(id)) {
            throw new RuntimeException("Loan not found with id" + id);
        }
        loanRepository.deleteById(id);
    }

    private LoanResponseDto toResponse(LoanEntity loanEntity) {
        return LoanResponseDto.builder()
                .id(loanEntity.getId())
                .userId(loanEntity.getUserId())
                .amount(loanEntity.getAmount())
                .interestRate(loanEntity.getInterestRate())
                .status(loanEntity.getStatus())
                .startDate(loanEntity.getStartDate())
                .loanDuration(loanEntity.getLoanDuration())
                .loanType(loanEntity.getLoanType())
                .build();
    }
}
