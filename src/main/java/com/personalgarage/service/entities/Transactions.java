package com.personalgarage.service.entities;

import com.personalgarage.service.base.entities.BaseEntity;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "transactions")
public class Transactions extends BaseEntity {

    private TransactionsTypes transactionsTypes;
    private String carId;
    private String userId;
    private Long timestamp;
    private BigDecimal amount;
    private String description;

    public Transactions() {}

    public TransactionsTypes getTransactionsTypes() {
        return transactionsTypes;
    }

    public void setTransactionsTypes(TransactionsTypes transactionsTypes) {
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