package com.ashish.Cards_Service.repository;

import com.ashish.Cards_Service.dto.CardRequestDto;
import com.ashish.Cards_Service.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<CardEntity, Long> {

    List<CardEntity> findByUserId(Long userId);
    Optional<CardEntity> findById(Long id);
}
