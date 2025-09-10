package com.ashish.Cards_Service.controller;

import com.ashish.Cards_Service.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;
}
