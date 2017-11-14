package com.personalgarage.service.main.transactions.application.services;

import com.personalgarage.service.base.application.ServiceTaskCreator;
import com.personalgarage.service.main.transactions.application.components.TransactionServiceModelMapper;
import com.personalgarage.service.main.transactions.application.services.interfaces.ITransactionService;
import com.personalgarage.service.main.transactions.application.tasks.CreateTransactionTask;
import com.personalgarage.service.main.transactions.application.tasks.GetAllTransactionsByCarIdTask;
import com.personalgarage.service.main.transactions.application.tasks.GetTransactionByIdTask;
import com.personalgarage.service.main.transactions.interfaces.messages.*;
import com.personalgarage.service.main.transactions.persistence.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("transactionService")
public class TransactionService implements ITransactionService {

    private final ServiceTaskCreator serviceTaskCreator;

    private TransactionServiceModelMapper transactionServiceModelMapper;
    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(ServiceTaskCreator serviceTaskCreator, TransactionServiceModelMapper transactionServiceModelMapper, TransactionRepository transactionRepository) {
        this.serviceTaskCreator = serviceTaskCreator;
        this.transactionServiceModelMapper = transactionServiceModelMapper;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public CreateTransactionResponse createTransaction(CreateTransactionRequest request) {
        return serviceTaskCreator.createTask(CreateTransactionTask.class).processInTransaction(request);
    }

    @Override
    public GetTransactionByIdResponse getTransactionById(GetTransactionByIdRequest request) {
        return serviceTaskCreator.createTask(GetTransactionByIdTask.class).processInTransaction(request);
    }

    @Override
    public GetAllTransactionsByCarIdResponse getAllTransactionsByCarId(GetAllTransactionsByCarIdRequest request) {
        return serviceTaskCreator.createTask(GetAllTransactionsByCarIdTask.class).processInTransaction(request);
    }
}