package com.personalgarage.service.main.transactions.application.services.interfaces;

import com.personalgarage.service.main.transactions.interfaces.dtos.TransactionDTO;

import java.util.List;

public interface ITransactionService {
    TransactionDTO createTransaction(TransactionDTO transactionDTO);

    TransactionDTO getTransactionById(Long id);

    List<TransactionDTO> getAllTransactionsByCarId(Long id);
}
