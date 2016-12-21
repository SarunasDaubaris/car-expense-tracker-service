package com.personalgarage.service.api.domain.transactions.application.interfaces;

import com.personalgarage.service.api.domain.transactions.data.dtos.TransactionsDTO;
import com.personalgarage.service.base.application.interfaces.IRestController;

public interface ITransactionController extends IRestController {

    TransactionsDTO get(String id);

    TransactionsDTO insert(TransactionsDTO transactionsDTO);

    TransactionsDTO update(TransactionsDTO transactionsDTO);

    void delete(String id);
}