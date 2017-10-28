package com.personalgarage.service.main.transactions.application.services;

import com.personalgarage.service.main.transactions.application.components.TransactionServiceModelMapper;
import com.personalgarage.service.main.transactions.application.services.interfaces.ITransactionService;
import com.personalgarage.service.main.transactions.interfaces.dtos.TransactionDTO;
import com.personalgarage.service.main.transactions.persistence.entities.Transaction;
import com.personalgarage.service.main.transactions.persistence.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public TransactionDTO get(Long id) {
        return transactionServiceModelMapper.mapByClass(transactionRepository.findOne(id), TransactionDTO.class);
    }

    @Override
    public TransactionDTO insert(TransactionDTO transactionDTO) {
        Transaction transaction = transactionServiceModelMapper.mapByClass(transactionDTO, Transaction.class);
        return transactionServiceModelMapper.mapByClass(transactionRepository.save(transaction), TransactionDTO.class);
    }

    @Override
    public TransactionDTO update(TransactionDTO transactionDTO) {
        Transaction transaction = transactionServiceModelMapper.mapByClass(transactionDTO, Transaction.class);
        return transactionServiceModelMapper.mapByClass(transactionRepository.save(transaction), TransactionDTO.class);
    }
}
