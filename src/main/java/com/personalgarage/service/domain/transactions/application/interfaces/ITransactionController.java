package com.personalgarage.service.domain.transactions.application.interfaces;

import com.personalgarage.service.base.application.interfaces.IRestController;
import com.personalgarage.service.domain.transactions.data.dtos.TransactionsDTO;

public interface ITransactionController extends IRestController {

    TransactionsDTO get(String id);

    TransactionsDTO insert(TransactionsDTO transactionsDTO);

    TransactionsDTO update(TransactionsDTO transactionsDTO);

    void delete(String id);
}