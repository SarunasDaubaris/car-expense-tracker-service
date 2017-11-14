package com.personalgarage.service.main.transactions.application.tasks;

import com.personalgarage.service.base.application.ServiceTask;
import com.personalgarage.service.main.transactions.application.components.TransactionServiceModelMapper;
import com.personalgarage.service.main.transactions.interfaces.dtos.TransactionDTO;
import com.personalgarage.service.main.transactions.interfaces.messages.GetAllTransactionsByCarIdRequest;
import com.personalgarage.service.main.transactions.interfaces.messages.GetAllTransactionsByCarIdResponse;
import com.personalgarage.service.main.transactions.persistence.entities.Transaction;
import com.personalgarage.service.main.transactions.persistence.repositories.TransactionRepository;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllTransactionsByCarIdTask extends ServiceTask<GetAllTransactionsByCarIdRequest, GetAllTransactionsByCarIdResponse> {

    private final TransactionServiceModelMapper transactionServiceModelMapper;
    private final TransactionRepository transactionRepository;

    @Autowired
    public GetAllTransactionsByCarIdTask(TransactionServiceModelMapper transactionServiceModelMapper, TransactionRepository transactionRepository) {
        this.transactionServiceModelMapper = transactionServiceModelMapper;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public GetAllTransactionsByCarIdResponse processDirectly(GetAllTransactionsByCarIdRequest request) {
        GetAllTransactionsByCarIdResponse response = new GetAllTransactionsByCarIdResponse();

        Validate.notNull(request, "getAllTransactionByCarIdRequest is null");

        Validate.notNull(request.carId, "carId is null");
        Validate.isTrue(request.carId > 0, "carId is invalid");

        List<Transaction> transactions = transactionRepository.findByCarId(request.carId);

        response.transactionDTOs = transactionServiceModelMapper.mapToListByClass(transactions, TransactionDTO.class);
        return response;
    }
}