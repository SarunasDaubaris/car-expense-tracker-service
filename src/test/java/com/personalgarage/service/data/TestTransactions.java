package com.personalgarage.service.data;

import com.personalgarage.service.api.domain.transactions.data.constants.TransactionTypeConst;

import java.math.BigDecimal;

public enum TestTransactions {

    FUEL_PURCHASE_1(1L, 1L, 1L, TransactionTypeConst.FUEL, BigDecimal.ONE, "Premium Diesel");

    private final Long id;
    private final Long userId;
    private final Long carId;
    private final TransactionTypeConst transactionsTypes;
    private final BigDecimal amount;
    private final String description;

    TestTransactions(Long id, Long userId, Long carId, TransactionTypeConst transactionsTypes, BigDecimal amount, String description) {
        this.id = id;
        this.userId = userId;
        this.carId = carId;
        this.transactionsTypes = transactionsTypes;
        this.amount = amount;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getCarId() {
        return carId;
    }

    public TransactionTypeConst getTransactionsTypes() {
        return transactionsTypes;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}