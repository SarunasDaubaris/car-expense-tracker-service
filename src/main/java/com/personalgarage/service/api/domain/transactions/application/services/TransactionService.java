package com.personalgarage.service.api.domain.transactions.application.services;

import com.personalgarage.service.api.domain.transactions.application.components.TransactionServiceModelMapper;
import com.personalgarage.service.api.domain.transactions.data.dtos.TransactionDTO;
import com.personalgarage.service.api.domain.transactions.persistence.entities.Transaction;
import com.personalgarage.service.api.domain.transactions.persistence.repositories.TransactionRepository;
import com.personalgarage.service.base.application.services.BaseRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService extends BaseRestService {

    private TransactionServiceModelMapper transactionServiceModelMapper;
    private TransactionRepository transactionRepository;

    public TransactionService() {
    }

    @Autowired
    public TransactionService(TransactionServiceModelMapper transactionServiceModelMapper, TransactionRepository transactionRepository) {
        this.transactionServiceModelMapper = transactionServiceModelMapper;
        this.transactionRepository = transactionRepository;
    }

    public TransactionDTO get(Long id) {
        return transactionServiceModelMapper.mapByClass(transactionRepository.findOne(id), TransactionDTO.class);
    }

    public TransactionDTO insert(TransactionDTO transactionDTO) {
        Transaction transaction = transactionServiceModelMapper.mapByClass(transactionDTO, Transaction.class);
        return transactionServiceModelMapper.mapByClass(transactionRepository.save(transaction), TransactionDTO.class);
    }

    public TransactionDTO update(TransactionDTO transactionDTO) {
        Transaction transaction = transactionServiceModelMapper.mapByClass(transactionDTO, Transaction.class);
        return transactionServiceModelMapper.mapByClass(transactionRepository.save(transaction), TransactionDTO.class);
    }

    public void delete(Long id) {
        transactionRepository.delete(id);
    }
}
