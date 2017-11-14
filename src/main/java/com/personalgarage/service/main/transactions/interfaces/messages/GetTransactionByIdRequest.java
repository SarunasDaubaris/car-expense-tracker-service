package com.personalgarage.service.main.transactions.interfaces.messages;

import com.personalgarage.service.base.messages.TaskRequest;

public class GetTransactionByIdRequest extends TaskRequest {

    public Long transactionId;
}