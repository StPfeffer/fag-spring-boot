package com.fag.domain.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class TransactionDTO {
    private final Long id;
    private final BigDecimal amount;
    private final UserDTO sender;
    private final UserDTO receiver;
    private final LocalDateTime timestamp;

    public TransactionDTO(Long id, BigDecimal amount, UserDTO sender, UserDTO receiver, LocalDateTime timestamp) {
        this.id = id;
        this.amount = amount;
        this.sender = sender;
        this.receiver = receiver;
        this.timestamp = timestamp;
    }

    public Long id() {
        return id;
    }

    public BigDecimal amount() {
        return amount;
    }

    public UserDTO sender() {
        return sender;
    }

    public UserDTO receiver() {
        return receiver;
    }

    public LocalDateTime timestamp() {
        return timestamp;
    }

}

