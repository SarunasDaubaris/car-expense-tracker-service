package com.personalgarage.service.api.domain.transactions.application.services;

import com.personalgarage.service.api.domain.transactions.application.services.interfaces.ITransactionService;
import com.personalgarage.service.api.domain.transactions.data.dtos.TransactionDTO;
import com.personalgarage.service.api.domain.transactions.persistence.entities.Transaction;
import com.personalgarage.service.api.domain.transactions.persistence.repositories.TransactionRepository;
import com.personalgarage.service.common.DomainDataMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionService implements ITransactionService {

    private final DomainDataMapper<TransactionDTO, Transaction> domainDataMapper = new DomainDataMapper<>();

    private TransactionRepository transactionRepository;

    public TransactionService() {
    }

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public TransactionDTO get(Long id) {
        return domainDataMapper.convertToDto(transactionRepository.findOne(id));
    }

    @Override
    public TransactionDTO insert(TransactionDTO transactionDTO) {
        return domainDataMapper.convertToDto(transactionRepository.save(domainDataMapper.convertToEntity(transactionDTO)));
    }

    @Override
    public TransactionDTO update(TransactionDTO transactionDTO) {
        return domainDataMapper.convertToDto(transactionRepository.save(domainDataMapper.convertToEntity(transactionDTO)));
    }

    @Override
    public void delete(Long id) {
        transactionRepository.delete(id);
    }
}
