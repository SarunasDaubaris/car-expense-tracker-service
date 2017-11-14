package com.personalgarage.service.main.transactions.interfaces.messages;

import com.personalgarage.service.base.messages.TaskResponse;
import com.personalgarage.service.main.transactions.interfaces.dtos.TransactionDTO;

public class GetTransactionByIdResponse extends TaskResponse {

    public TransactionDTO transactionDTO;
}