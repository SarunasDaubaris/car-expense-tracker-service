package com.personalgarage.service.domain.transactions.application.services.interfaces;

import com.personalgarage.service.base.application.services.interfaces.IRestService;
import com.personalgarage.service.domain.transactions.data.dtos.TransactionsDTO;

public interface ITransactionsService extends IRestService {

    TransactionsDTO get(String id);

    TransactionsDTO insert(TransactionsDTO transactionsDTO);

    TransactionsDTO update(TransactionsDTO transactionsDTO);

    void delete(String id);
}