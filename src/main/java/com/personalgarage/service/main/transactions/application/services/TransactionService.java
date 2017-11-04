package com.personalgarage.service.main.transactions.application.services;

import com.personalgarage.service.common.exceptions.ApplicationServiceException;
import com.personalgarage.service.main.transactions.application.components.TransactionServiceModelMapper;
import com.personalgarage.service.main.transactions.application.services.interfaces.ITransactionService;
import com.personalgarage.service.main.transactions.interfaces.dtos.TransactionDTO;
import com.personalgarage.service.main.transactions.interfaces.errors.TransactionsErrors;
import com.personalgarage.service.main.transactions.persistence.entities.Transaction;
import com.personalgarage.service.main.transactions.persistence.repositories.TransactionRepository;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service("transactionService")
public class TransactionService implements ITransactionService {

    private TransactionServiceModelMapper transactionServiceModelMapper;
    private TransactionRepository transactionRepository;

    public TransactionService() {
    }

    @Autowired
    public TransactionService(TransactionServiceModelMapper transactionServiceModelMapper, TransactionRepository transactionRepository) {
        this.transactionServiceModelMapper = transactionServiceModelMapper;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
        if (transactionDTO.getCarId() == null) {
            throw new ApplicationServiceException(TransactionsErrors.CAR_ID_INVALID);
        }
        if (transactionDTO.getUserId() == null) {
            throw new ApplicationServiceException(TransactionsErrors.USER_ID_INVALID);
        }
        if (transactionDTO.getTransactionType() == null) {
            throw new ApplicationServiceException(TransactionsErrors.TRANSACTION_TYPE_NULL);
        }
        if (transactionDTO.getAmount() == null || BigDecimal.ZERO.compareTo(transactionDTO.getAmount()) >= 0) {
            throw new ApplicationServiceException(TransactionsErrors.AMOUNT_INVALID);
        }

        Transaction transaction = transactionServiceModelMapper.mapByClass(transactionDTO, Transaction.class);
        transaction.setCreatedDate(DateTime.now(DateTimeZone.UTC));
        return transactionServiceModelMapper.mapByClass(transactionRepository.save(transaction), TransactionDTO.class);
    }

    @Override
    public TransactionDTO getTransactionById(Long id) {
        return transactionServiceModelMapper.mapByClass(transactionRepository.findOne(id), TransactionDTO.class);
    }

    @Override
    public List<TransactionDTO> getAllTransactionsByCarId(Long id) {
        return transactionServiceModelMapper.mapToListByClass(transactionRepository.findByCarId(id), TransactionDTO.class);
    }
}