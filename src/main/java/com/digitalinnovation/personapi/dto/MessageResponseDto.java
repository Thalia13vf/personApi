package com.digitalinnovation.personapi.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MessageResponseDto {
    private String message;
}
