package com.personalgarage.service.api.domain.transactions.application.services;

import com.personalgarage.service.api.domain.transactions.application.services.interfaces.ITransactionsService;
import com.personalgarage.service.base.application.services.BaseRestService;
import com.personalgarage.service.common.DomainDataMapper;
import com.personalgarage.service.api.domain.transactions.data.dtos.TransactionsDTO;
import com.personalgarage.service.api.domain.transactions.persistence.entities.Transactions;
import com.personalgarage.service.api.domain.transactions.persistence.repositories.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionsService extends BaseRestService implements ITransactionsService {

    private TransactionsRepository transactionsRepository;
    private DomainDataMapper<TransactionsDTO, Transactions> domainDataMapper = new DomainDataMapper<>();

    public TransactionsService() {}

    @Autowired
    public TransactionsService(TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    @Override
    public TransactionsDTO get(String id) {
        return domainDataMapper.convertToDto(transactionsRepository.findOne(id));
    }

    @Override
    public TransactionsDTO insert(TransactionsDTO transactionsDTO) {
        return domainDataMapper.convertToDto(transactionsRepository.insert(domainDataMapper.convertToEntity(transactionsDTO)));
    }

    @Override
    public TransactionsDTO update(TransactionsDTO transactionsDTO) {
        return domainDataMapper.convertToDto(transactionsRepository.save(domainDataMapper.convertToEntity(transactionsDTO)));
    }

    @Override
    public void delete(String id) {
        transactionsRepository.delete(id);
    }
}
