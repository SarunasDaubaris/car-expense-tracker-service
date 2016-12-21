package com.personalgarage.service.data;

import com.personalgarage.service.api.domain.transactions.data.constants.TransactionsTypesConst;

import java.math.BigDecimal;
import java.util.Date;

public enum TestTransactions {

    FUEL_PURCHASE_1("1", "1", "1", TransactionsTypesConst.FUEL, new Date().getTime(), new Date().getTime(), BigDecimal.ONE, "Premium Diesel");

    private final String id;
    private final String userId;
    private final String carId;
    private final TransactionsTypesConst transactionsTypes;
    private final Long createdTime;
    private final Long lastUpdatedTime;
    private final BigDecimal amount;
    private final String description;

    TestTransactions(String id, String userId, String carId, TransactionsTypesConst transactionsTypes, Long createdTime, Long lastUpdatedTime, BigDecimal amount, String description) {
        this.id = id;
        this.userId = userId;
        this.carId = carId;
        this.transactionsTypes = transactionsTypes;
        this.createdTime = createdTime;
        this.lastUpdatedTime = lastUpdatedTime;
        this.amount = amount;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getCarId() {
        return carId;
    }

    public TransactionsTypesConst getTransactionsTypes() {
        return transactionsTypes;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public Long getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}