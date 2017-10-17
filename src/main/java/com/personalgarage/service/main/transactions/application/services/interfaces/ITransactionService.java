package com.personalgarage.service.main.transactions.application.services.interfaces;

import com.personalgarage.service.interfaces.main.transactions.dtos.TransactionDTO;

public interface ITransactionService {
    TransactionDTO get(Long id);

    TransactionDTO insert(TransactionDTO transactionDTO);

    TransactionDTO update(TransactionDTO transactionDTO);
}
