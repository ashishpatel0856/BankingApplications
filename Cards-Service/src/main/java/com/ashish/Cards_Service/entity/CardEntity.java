package com.ashish.Cards_Service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "cards")
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String cardToken;

    @Column(nullable = false)
    private String cardNumber;

    @Enumerated(EnumType.STRING)
    private CardType cardType; // debit credit virtual

    @Enumerated(EnumType.STRING)
    private CardStatus status; // PENDING, ACTIVE, BLOCKED, CLOSED

    private Double creditLimit; // for credit cards

    private Double availableLimit;

    @Embedded
    private AuditInfo auditInfo;

    @Version
    private Long version;
}
