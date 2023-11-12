package com.fag.domain.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionDTO(Long id, BigDecimal amount, UserDTO sender, UserDTO receiver, LocalDateTime timestamp) {
}

