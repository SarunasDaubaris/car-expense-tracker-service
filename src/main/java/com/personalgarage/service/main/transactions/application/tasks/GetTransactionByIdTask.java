package com.personalgarage.service.main.transactions.application.tasks;

import com.personalgarage.service.base.application.ServiceTask;
import com.personalgarage.service.main.transactions.application.components.TransactionServiceModelMapper;
import com.personalgarage.service.main.transactions.interfaces.dtos.TransactionDTO;
import com.personalgarage.service.main.transactions.interfaces.messages.GetTransactionByIdRequest;
import com.personalgarage.service.main.transactions.interfaces.messages.GetTransactionByIdResponse;
import com.personalgarage.service.main.transactions.persistence.entities.Transaction;
import com.personalgarage.service.main.transactions.persistence.repositories.TransactionRepository;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetTransactionByIdTask extends ServiceTask<GetTransactionByIdRequest, GetTransactionByIdResponse> {

    private final TransactionServiceModelMapper transactionServiceModelMapper;
    private final TransactionRepository transactionRepository;

    @Autowired
    public GetTransactionByIdTask(TransactionServiceModelMapper transactionServiceModelMapper, TransactionRepository transactionRepository) {
        this.transactionServiceModelMapper = transactionServiceModelMapper;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public GetTransactionByIdResponse processDirectly(GetTransactionByIdRequest request) {
        GetTransactionByIdResponse response = new GetTransactionByIdResponse();

        Validate.notNull(request, "getTransactionByIdRequest is null");

        Validate.notNull(request.transactionId, "transactionId is null");
        Validate.isTrue(request.transactionId > 0, "transactionId is invalid");

        Transaction transaction = Validate.notNull(
                transactionRepository.findById(request.transactionId).orElse(null),
                "failed to find transaction #%s",
                request.transactionId);

        response.transactionDTO = transactionServiceModelMapper.mapByClass(transaction, TransactionDTO.class);
        return response;
    }
}