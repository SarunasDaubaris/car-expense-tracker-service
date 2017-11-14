package com.personalgarage.service.main.transactions.application.services.interfaces;

import com.personalgarage.service.common.exceptions.ApplicationServiceException;
import com.personalgarage.service.main.transactions.interfaces.messages.*;

public interface ITransactionService {

    CreateTransactionResponse createTransaction(CreateTransactionRequest request) throws ApplicationServiceException;

    GetTransactionByIdResponse getTransactionById(GetTransactionByIdRequest request) throws ApplicationServiceException;

    GetAllTransactionsByCarIdResponse getAllTransactionsByCarId(GetAllTransactionsByCarIdRequest request) throws ApplicationServiceException;
}