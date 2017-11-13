package com.personalgarage.service.main.transactions.interfaces.errors;

import com.personalgarage.service.base.errors.ErrorCodeBases;
import com.personalgarage.service.common.exceptions.ExceptionData;

public final class TransactionsErrors {

    public static final ExceptionData AMOUNT_INVALID = new ExceptionData(ErrorCodeBases.TRANSACTIONS, 1, "amount is invalid");

    private TransactionsErrors() {
    }
}