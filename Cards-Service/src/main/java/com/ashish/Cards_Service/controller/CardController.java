package com.ashish.Cards_Service.controller;

import com.ashish.Cards_Service.dto.CardRequestDto;
import com.ashish.Cards_Service.dto.CardResponseDto;
import com.ashish.Cards_Service.entity.CardEntity;
import com.ashish.Cards_Service.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @PostMapping("/create")
    public ResponseEntity<CardResponseDto> createdCard(@RequestBody CardRequestDto cardRequestDto) {
        CardResponseDto responseDto = cardService.createdCard(cardRequestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CardResponseDto>> getUserCardByUserId(@PathVariable Long userId) {

        return new ResponseEntity<>(cardService.getUserCardByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardResponseDto> getCardById(@PathVariable Long id) {
        return new ResponseEntity<>(cardService.getCardById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CardResponseDto> updatedCardByUserId(@PathVariable Long id, @RequestBody CardRequestDto cardRequestDto) {
        return new ResponseEntity<>(cardService.updateCardByUserId(id, cardRequestDto), HttpStatus.OK);
    }

}
