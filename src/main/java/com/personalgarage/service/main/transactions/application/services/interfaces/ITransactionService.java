package com.personalgarage.service.main.transactions.application.services.interfaces;

import com.personalgarage.service.main.transactions.interfaces.dtos.TransactionDTO;

public interface ITransactionService {
    TransactionDTO get(Long id);

    TransactionDTO insert(TransactionDTO transactionDTO);

    TransactionDTO update(TransactionDTO transactionDTO);
}
