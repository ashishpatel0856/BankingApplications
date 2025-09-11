package com.ashish.Cards_Service.service;

import com.ashish.Cards_Service.dto.CardRequestDto;
import com.ashish.Cards_Service.dto.CardResponseDto;
import com.ashish.Cards_Service.entity.AuditInfo;
import com.ashish.Cards_Service.entity.CardEntity;
import com.ashish.Cards_Service.entity.CardStatus;
import com.ashish.Cards_Service.exceptions.ResourceNotFoundException;
import com.ashish.Cards_Service.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardService implements CardServiceImpl {

     private final CardRepository cardRepository;

    @Override
    public CardResponseDto createdCard(CardRequestDto cardRequestDto) {
        log.info("applying card by user in our bank:{}",cardRequestDto.getUserId());
        CardEntity cardEntity = CardEntity.builder()
                .userId(cardRequestDto.getUserId())
                .cardToken(UUID.randomUUID().toString())
//                .cardNumber(UUID.randomUUID().toString())
                .cardNumber(generateRandomNumber())
                .status(CardStatus.PENDING)
                .creditLimit(cardRequestDto.getCreditLimit())
                .availableLimit(cardRequestDto.getCreditLimit())
                .auditInfo(
                        AuditInfo.builder()
                                .createdAt(LocalDateTime.now())
                                .createdBy("BANKING SYSTEM")
                                .build()

                )
                .build();
        CardEntity savedCard = cardRepository.save(cardEntity);
        return toCardResponseModel(savedCard);
    }

    @Override
    public List<CardResponseDto> getUserCardByUserId(Long userId) {
        log.info("getting card by userId:{}",userId);
        return cardRepository.findByUserId(userId)
                .stream()
                .map(this::toCardResponseModel)
                .collect(Collectors.toList());
    }

    @Override
    public CardResponseDto getCardById(Long id) {
        log.info("getting card by id:{}",id);
        CardEntity cardEntity = cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found with card is"+id ));
        return toCardResponseModel(cardEntity);
    }

    @Override
    public CardResponseDto updateCardByUserId(Long id,CardRequestDto cardRequestDto) {
        log.info("updating card by id: {}",id);
        CardEntity existingCard = cardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Card not found with card is"+id ));

        if(cardRequestDto.getCreditLimit() != null) {
            existingCard.setCreditLimit(cardRequestDto.getCreditLimit());
            existingCard.setAvailableLimit(cardRequestDto.getCreditLimit());
        }
        if(cardRequestDto.getCardType() != null) {
            existingCard.setCardToken(cardRequestDto.getCardType());
        }

        if(cardRequestDto.getStatus() != null){
            existingCard.setStatus(cardRequestDto.getStatus());
        }

        AuditInfo auditInfo = existingCard.getAuditInfo();
        auditInfo.setCreatedAt(LocalDateTime.now());
        auditInfo.setCreatedBy("BANKING SYSTEM");
        existingCard.setAuditInfo(auditInfo);

        CardEntity savedCard = cardRepository.save(existingCard);
        return toCardResponseModel(savedCard);
    }

    private CardResponseDto toCardResponseModel(CardEntity cardEntity) {
        return CardResponseDto.builder()
                .id(cardEntity.getId())
                .userId(cardEntity.getUserId())
                .cardToken(cardEntity.getCardToken())
                .cardNumber(cardEntity.getCardNumber())
                .cardType(cardEntity.getCardType())
                .status(cardEntity.getStatus())
                .creditLimit(cardEntity.getCreditLimit())
                .availableLimit(cardEntity.getAvailableLimit())
                .build();
    }

    private String generateRandomNumber() {
        return "4242 **** **** " + (1000+ (int)(Math.random()*9000));
    }
}
