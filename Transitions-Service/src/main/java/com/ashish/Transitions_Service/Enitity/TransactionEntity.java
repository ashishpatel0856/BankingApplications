package com.ashish.Transitions_Service.Enitity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="transitions")
@Builder
public class TransactionEntity {
    @Id
    private String transactionId;

    @Pattern(regexp = "DEPOSIT|WITHDRAWAL|TRANSFER",
                                       message = "transaction type must be deposit , withdrawal,transfer")
    private String transactionType;

    @Positive(message = "amount always must be greater than 0")
    private Double amount;

    private String fromAccountId;

    private String toAccountId;

    @Pattern(regexp = "SUCCESS|FAILED|PENDING",
                        message = "status must be compulsory")
    private String status;

    @Size(min = 1, max = 200)
    private String description;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (this.transactionId == null) {
            this.transactionId = UUID.randomUUID().toString();
        }
        this.createdAt = LocalDateTime.now();
    }

}
