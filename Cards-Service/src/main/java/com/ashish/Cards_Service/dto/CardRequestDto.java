package com.ashish.Cards_Service.dto;

import com.ashish.Cards_Service.entity.CardStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardRequestDto {

    @NotNull
    private Long userId;

    @NotBlank
    private String cardType;

    @Min(value=5000,message = "minimum limit must be 5000>=amount")
    private Double creditLimit;
    private CardStatus status;

}
