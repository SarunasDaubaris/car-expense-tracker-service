package com.personalgarage.service.dto;

import com.personalgarage.service.base.dto.BaseDTO;

import java.math.BigDecimal;

public class TransactionsDTO extends BaseDTO {

    private String transactionsTypes;
    private String carId;
    private String userId;
    private Long timestamp;
    private BigDecimal amount;
    private String description;

    public TransactionsDTO() {}

    public String getTransactionsTypes() {
        return transactionsTypes;
    }

    public void setTransactionsTypes(String transactionsTypes) {
        this.transactionsTypes = transactionsTypes;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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