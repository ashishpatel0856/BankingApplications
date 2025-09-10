package com.ashish.Cards_Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.smartcardio.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
}
