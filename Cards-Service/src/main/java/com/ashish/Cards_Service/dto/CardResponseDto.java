package com.ashish.Cards_Service.dto;

import com.ashish.Cards_Service.entity.CardStatus;
import com.ashish.Cards_Service.entity.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CardResponseDto {
    private Long id;
    private Long userId;
    private String cardNumber;
    private CardType cardType;
    private String cardToken;
    private CardStatus status;
    private Double creditLimit;
    private Double availableLimit;

}
