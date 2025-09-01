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
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="transitions")
@Builder
public class TransactionEntity {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "transaction type can not bhi null")
    @Pattern(regexp = "DEPOSIT|WITHDRAWAL|TRANSFER",
                                       message = "transaction type must be deposit , withdrawal,transfer")
    private String transactionType;

    @NotBlank(message = "amount can not be null")
    @Positive(message = "amount always must be greater than 0")
    private Double amount;

    @NotBlank(message = "from account id is required")
    @Positive(message = "From account Id must be positive")
    private String fromAccountId;

    @Positive(message = "To Account ID must be positive")
    private String toAccountId;

    @NotBlank(message = "status can not be null")
    @Pattern(regexp = "SUCCESS|FAILED|PENDING",
                        message = "status must be compulsory")
    private String status;

    @Size(min = 1, max = 20)
    private String description;

    private LocalDateTime createdAt;


    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

}
