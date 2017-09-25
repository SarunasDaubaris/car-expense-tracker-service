package com.personalgarage.service.api.domain.transactions.application.services.interfaces;

import com.personalgarage.service.api.domain.transactions.data.dtos.TransactionDTO;

public interface ITransactionService {
    TransactionDTO get(Long id);

    TransactionDTO insert(TransactionDTO transactionDTO);

    TransactionDTO update(TransactionDTO transactionDTO);
}
