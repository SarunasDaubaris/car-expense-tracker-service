package com.personalgarage.service.main.transactions.interfaces.errors;

import com.personalgarage.service.common.exceptions.ErrorCodeBases;
import com.personalgarage.service.common.exceptions.ErrorData;

public final class TransactionsErrors {

    public static final ErrorData AMOUNT_INVALID = new ErrorData(ErrorCodeBases.TRANSACTIONS, 1, "amount is invalid");

    private TransactionsErrors() {
    }
}