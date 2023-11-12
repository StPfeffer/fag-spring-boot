package com.fag.domain.dtos;

import java.math.BigDecimal;

public record TransactionRequestDTO(BigDecimal value, Long senderId, Long receiverId) {
}
