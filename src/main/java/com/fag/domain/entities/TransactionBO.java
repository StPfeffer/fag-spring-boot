package com.fag.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionBO(Long id, BigDecimal amount, UserBO sender, UserBO receiver, LocalDateTime timestamp, boolean success) {
}
