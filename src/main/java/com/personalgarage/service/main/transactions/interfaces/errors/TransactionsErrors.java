package com.personalgarage.service.main.transactions.interfaces.errors;

import com.personalgarage.service.common.exceptions.ErrorCodeBases;
import com.personalgarage.service.common.exceptions.ErrorData;

public final class TransactionsErrors {

    public static final ErrorData USER_ID_INVALID = new ErrorData(ErrorCodeBases.TRANSACTIONS, 1, "userId is invalid");
    public static final ErrorData CAR_ID_INVALID = new ErrorData(ErrorCodeBases.TRANSACTIONS, 2, "carId is invalid");
    public static final ErrorData TRANSACTION_TYPE_NULL = new ErrorData(ErrorCodeBases.TRANSACTIONS, 3, "transactionType is null");
    public static final ErrorData AMOUNT_INVALID = new ErrorData(ErrorCodeBases.TRANSACTIONS, 4, "amount is invalid");

    private TransactionsErrors() {
    }
}