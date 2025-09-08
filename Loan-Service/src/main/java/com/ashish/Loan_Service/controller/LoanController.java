package com.ashish.Loan_Service.controller;

import com.ashish.Loan_Service.dto.LoanRequestDto;
import com.ashish.Loan_Service.dto.LoanResponseDto;
import com.ashish.Loan_Service.service.LoanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoanController {
    private final LoanService loanService;

    @PostMapping("/apply")
    public ResponseEntity<LoanResponseDto> applyLoan( @Valid @RequestBody LoanRequestDto loanRequestDto) {
        LoanResponseDto laonDto = loanService.applyLoan(loanRequestDto);
        return new ResponseEntity<>(laonDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanResponseDto> checkLoan(@PathVariable Long id) {
        LoanResponseDto loanResponseDto = loanService.checkLoan(id);
        return new ResponseEntity<>(loanResponseDto, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<LoanResponseDto>> getAllLoan() {
        List<LoanResponseDto> loanResponseDtoList = loanService.getAllLoan();
        return new ResponseEntity<>(loanResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/userId/{userId}")
    public ResponseEntity<List<LoanResponseDto>> getLoansByUserId(@PathVariable Long userId) {
        List<LoanResponseDto> loans = loanService.getLoanByUserId(userId);
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<LoanResponseDto> updateLoan(@PathVariable Long id, @Valid @RequestBody LoanRequestDto loanRequestDto) {
        LoanResponseDto loanResponseDto = loanService.updateLoan(id, loanRequestDto);
        return new ResponseEntity<>(loanResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletionOfLoan(@PathVariable Long id) {
        loanService.deletionOfLoan(id);
        return ResponseEntity.ok("Loan deleted successfully");
    }
}
