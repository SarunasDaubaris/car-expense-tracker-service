package com.personalgarage.service.main.transactions.application.services.interfaces;

import com.personalgarage.service.main.transactions.interfaces.messages.*;

public interface ITransactionService {

    CreateTransactionResponse createTransaction(CreateTransactionRequest request);

    GetTransactionByIdResponse getTransactionById(GetTransactionByIdRequest request);

    GetAllTransactionsByCarIdResponse getAllTransactionsByCarId(GetAllTransactionsByCarIdRequest request);
}