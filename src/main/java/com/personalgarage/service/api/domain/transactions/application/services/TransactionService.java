package com.personalgarage.service.api.domain.transactions.application.services;

import com.personalgarage.service.api.domain.transactions.data.dtos.TransactionDTO;
import com.personalgarage.service.api.domain.transactions.persistence.entities.Transaction;
import com.personalgarage.service.api.domain.transactions.persistence.repositories.TransactionRepository;
import com.personalgarage.service.base.application.services.BaseRestService;
import com.personalgarage.service.common.DomainDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService extends BaseRestService {

    private final DomainDataMapper<TransactionDTO, Transaction> domainDataMapper = new DomainDataMapper<>();

    private TransactionRepository transactionRepository;

    public TransactionService() {
    }

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public TransactionDTO get(Long id) {
        return domainDataMapper.convertToDto(transactionRepository.findOne(id));
    }

    public TransactionDTO insert(TransactionDTO transactionDTO) {
        return domainDataMapper.convertToDto(transactionRepository.save(domainDataMapper.convertToEntity(transactionDTO)));
    }

    public TransactionDTO update(TransactionDTO transactionDTO) {
        return domainDataMapper.convertToDto(transactionRepository.save(domainDataMapper.convertToEntity(transactionDTO)));
    }

    public void delete(Long id) {
        transactionRepository.delete(id);
    }
}
