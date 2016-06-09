package com.personalgarage.service.dto;

import java.math.BigDecimal;

public final class TransactionsDTO {

    private String id;
    private String transactionsTypes;
    private Long timestamp;
    private BigDecimal amount;
    private String description;

    public TransactionsDTO() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransactionsTypes() {
        return transactionsTypes;
    }

    public void setTransactionsTypes(String transactionsTypes) {
        this.transactionsTypes = transactionsTypes;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}