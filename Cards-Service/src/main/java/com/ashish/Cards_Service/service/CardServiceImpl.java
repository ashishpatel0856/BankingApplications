package com.ashish.Cards_Service.service;

import com.ashish.Cards_Service.dto.CardRequestDto;
import com.ashish.Cards_Service.dto.CardResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CardServiceImpl {

    CardResponseDto createdCard(CardRequestDto cardRequestDto);
    List<CardResponseDto> getUserCardByUserId(Long userId);
    CardRequestDto getCardById(Long id);
    CardResponseDto updateCardByUserId(CardRequestDto cardRequestDto);
}
