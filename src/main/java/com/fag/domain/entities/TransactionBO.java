package com.fag.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionBO {

    private final Long id;
    private final BigDecimal amount;
    private final UserBO sender;
    private final UserBO receiver;
    private final LocalDateTime timestamp;

    public TransactionBO(Long id, BigDecimal amount, UserBO sender, UserBO receiver, LocalDateTime timestamp) {
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

    public UserBO getSender() {
        return sender;
    }

    public UserBO getReceiver() {
        return receiver;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

}
