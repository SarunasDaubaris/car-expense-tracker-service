package com.personalgarage.service.main.transactions.interfaces.messages;

import com.personalgarage.service.base.messages.TaskResponse;
import com.personalgarage.service.main.transactions.interfaces.dtos.TransactionDTO;

import java.util.List;

public class GetAllTransactionsByCarIdResponse extends TaskResponse {

    public List<TransactionDTO> transactionDTOs;
}