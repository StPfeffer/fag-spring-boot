package com.fag.domain.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class TransactionDTO {
    private Long id;
    private BigDecimal amount;
    private UserDTO sender;
    private UserDTO receiver;
    private LocalDateTime timestamp;
    private boolean success;

    public TransactionDTO(Long id, BigDecimal amount, UserDTO sender, UserDTO receiver, LocalDateTime timestamp, boolean success) {
        this.id = id;
        this.amount = amount;
        this.sender = sender;
        this.receiver = receiver;
        this.timestamp = timestamp;
        this.success = success;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public UserDTO getSender() {
        return sender;
    }

    public void setSender(UserDTO sender) {
        this.sender = sender;
    }

    public UserDTO getReceiver() {
        return receiver;
    }

    public void setReceiver(UserDTO receiver) {
        this.receiver = receiver;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}

