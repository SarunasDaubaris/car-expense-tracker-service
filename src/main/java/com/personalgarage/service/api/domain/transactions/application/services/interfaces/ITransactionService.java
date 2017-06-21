package com.personalgarage.service.api.domain.transactions.application.services.interfaces;

import com.personalgarage.service.api.domain.transactions.data.dtos.TransactionDTO;
import org.springframework.stereotype.Service;

@Service
public interface ITransactionService {

    TransactionDTO get(Long id);

    TransactionDTO insert(TransactionDTO transactionsDTO);

    TransactionDTO update(TransactionDTO transactionDTO);

    void delete(Long id);
}