package com.personalgarage.service.main.transactions.application.services;

import com.personalgarage.service.base.application.ServiceTaskCreator;
import com.personalgarage.service.common.exceptions.ApplicationServiceException;
import com.personalgarage.service.main.transactions.application.services.interfaces.ITransactionService;
import com.personalgarage.service.main.transactions.application.tasks.CreateTransactionTask;
import com.personalgarage.service.main.transactions.application.tasks.GetAllTransactionsByCarIdTask;
import com.personalgarage.service.main.transactions.application.tasks.GetTransactionByIdTask;
import com.personalgarage.service.main.transactions.interfaces.messages.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("transactionService")
public class TransactionService implements ITransactionService {

    private final ServiceTaskCreator serviceTaskCreator;

    @Autowired
    public TransactionService(ServiceTaskCreator serviceTaskCreator) {
        this.serviceTaskCreator = serviceTaskCreator;
    }

    @Override
    public CreateTransactionResponse createTransaction(CreateTransactionRequest request) throws ApplicationServiceException {
        return serviceTaskCreator.createTask(CreateTransactionTask.class).processInTransaction(request);
    }

    @Override
    public GetTransactionByIdResponse getTransactionById(GetTransactionByIdRequest request) throws ApplicationServiceException {
        return serviceTaskCreator.createTask(GetTransactionByIdTask.class).processInTransaction(request);
    }

    @Override
    public GetAllTransactionsByCarIdResponse getAllTransactionsByCarId(GetAllTransactionsByCarIdRequest request) throws ApplicationServiceException {
        return serviceTaskCreator.createTask(GetAllTransactionsByCarIdTask.class).processInTransaction(request);
    }
}