package com.ashish.Cards_Service.service;

import com.ashish.Cards_Service.dto.CardRequestDto;
import com.ashish.Cards_Service.dto.CardResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardService implements CardServiceImpl {
    @Override
    public CardResponseDto createdCard(CardRequestDto cardRequestDto) {
        return null;
    }

    @Override
    public List<CardResponseDto> getUserCardByUserId(Long userId) {
        return List.of();
    }

    @Override
    public CardRequestDto getCardById(Long id) {
        return null;
    }

    @Override
    public CardResponseDto updateCardByUserId(CardRequestDto cardRequestDto) {
        return null;
    }
}
