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

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public UserDTO getSender() {
        return sender;
    }

    public UserDTO getReceiver() {
        return receiver;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

}

