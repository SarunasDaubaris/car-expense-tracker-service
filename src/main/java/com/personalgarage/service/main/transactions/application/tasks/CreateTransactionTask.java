package com.personalgarage.service.main.transactions.application.tasks;

import com.personalgarage.service.base.application.ServiceTask;
import com.personalgarage.service.common.exceptions.ApplicationServiceException;
import com.personalgarage.service.main.transactions.application.components.TransactionServiceModelMapper;
import com.personalgarage.service.main.transactions.interfaces.dtos.TransactionDTO;
import com.personalgarage.service.main.transactions.interfaces.errors.TransactionsErrors;
import com.personalgarage.service.main.transactions.interfaces.messages.CreateTransactionRequest;
import com.personalgarage.service.main.transactions.interfaces.messages.CreateTransactionResponse;
import com.personalgarage.service.main.transactions.persistence.entities.Transaction;
import com.personalgarage.service.main.transactions.persistence.repositories.TransactionRepository;
import org.apache.commons.lang3.Validate;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CreateTransactionTask extends ServiceTask<CreateTransactionRequest, CreateTransactionResponse> {

    private final TransactionServiceModelMapper transactionServiceModelMapper;
    private final TransactionRepository transactionRepository;

    @Autowired
    public CreateTransactionTask(TransactionServiceModelMapper transactionServiceModelMapper, TransactionRepository transactionRepository) {
        this.transactionServiceModelMapper = transactionServiceModelMapper;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public CreateTransactionResponse processDirectly(CreateTransactionRequest request) {
        CreateTransactionResponse response = new CreateTransactionResponse();

        Validate.notNull(request, "createTransactionRequest is null");

        TransactionDTO transactionDTO = Validate.notNull(request.transactionDTO, "transactionDTO is null");

        Validate.notNull(transactionDTO.getCarId(), "carId is null");
        Validate.isTrue(transactionDTO.getCarId() > 0, "carId is invalid");

        Validate.notNull(transactionDTO.getUserId(), "userId is null");
        Validate.isTrue(transactionDTO.getUserId() > 0, "userId is invalid");

        Validate.notNull(transactionDTO.getTransactionType(), "transactionType is null");

        if (transactionDTO.getAmount() == null || BigDecimal.ZERO.compareTo(transactionDTO.getAmount()) >= 0) {
            throw new ApplicationServiceException(TransactionsErrors.AMOUNT_INVALID);
        }

        Transaction transaction = transactionServiceModelMapper.mapByClass(transactionDTO, Transaction.class);
        transaction.setCreatedDate(DateTime.now(DateTimeZone.UTC));

        transactionRepository.save(transaction);

        response.transactionId = transaction.getId();
        return response;
    }
}