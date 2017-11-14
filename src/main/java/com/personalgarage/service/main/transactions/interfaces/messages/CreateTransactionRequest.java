package com.personalgarage.service.main.transactions.interfaces.messages;

import com.personalgarage.service.base.messages.TaskRequest;
import com.personalgarage.service.main.transactions.interfaces.dtos.TransactionDTO;

public class CreateTransactionRequest extends TaskRequest {

    public TransactionDTO transactionDTO;
}