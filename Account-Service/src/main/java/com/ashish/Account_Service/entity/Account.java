package com.ashish.Account_Service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "bank_accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Account Number must be required")
    @Column(unique = true, nullable = false)
    private String accountNumber;

    @NotBlank(message = "account type must be required")
    private String accountType;

    @NotBlank(message = "bank name is required")
    private String bankName;

    @PositiveOrZero(message = "balance always be positively")
    private Double balance =0.0;

    @Column(unique = true, nullable = false)
    private Long userId;
}
