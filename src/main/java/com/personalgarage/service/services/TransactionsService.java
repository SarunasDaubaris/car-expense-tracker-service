package com.personalgarage.service.services;

import com.personalgarage.service.base.services.BaseRestService;
import com.personalgarage.service.base.RestMapper;
import com.personalgarage.service.dto.TransactionsDTO;
import com.personalgarage.service.entities.Transactions;
import com.personalgarage.service.repositories.TransactionsRepository;
import com.personalgarage.service.services.interfaces.ITransactionsService;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionsService extends BaseRestService implements ITransactionsService {

    private TransactionsRepository transactionsRepository;
    private RestMapper<TransactionsDTO, Transactions> restMapper = new RestMapper<>();

    public TransactionsService() {}

    @Autowired
    public TransactionsService(TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    @Override
    public TransactionsDTO get(String id) {
        return restMapper.convertToDto(transactionsRepository.findOne(id));
    }

    @Override
    public TransactionsDTO insert(TransactionsDTO transactionsDTO) {
        return restMapper.convertToDto(transactionsRepository.insert(restMapper.convertToEntity(transactionsDTO)));
    }

    @Override
    public TransactionsDTO update(TransactionsDTO transactionsDTO) {
        return restMapper.convertToDto(transactionsRepository.save(restMapper.convertToEntity(transactionsDTO)));
    }

    @Override
    public void delete(String id) {
        transactionsRepository.delete(id);
    }
}
