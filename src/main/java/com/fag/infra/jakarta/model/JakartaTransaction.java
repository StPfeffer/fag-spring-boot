package com.fag.infra.jakarta.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class JakartaTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal amount;

    @ManyToOne
    private JakartaUser sender;

    @ManyToOne
    private JakartaUser receiver;

    private LocalDateTime timestamp;

    @Column(nullable = false)
    private boolean success;

    public JakartaTransaction() {
    }

    public JakartaTransaction(BigDecimal amount, JakartaUser sender, JakartaUser receiver, LocalDateTime timestamp, boolean success) {
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

    public JakartaUser getSender() {
        return sender;
    }

    public void setSender(JakartaUser sender) {
        this.sender = sender;
    }

    public JakartaUser getReceiver() {
        return receiver;
    }

    public void setReceiver(JakartaUser receiver) {
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
