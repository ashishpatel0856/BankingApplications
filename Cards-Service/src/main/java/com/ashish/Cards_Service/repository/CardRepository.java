package com.ashish.Cards_Service.repository;

import com.ashish.Cards_Service.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<CardEntity, Long> {

    List<CardEntity> findByUserId(Long userId);
}
