package com.personalgarage.service.domain.transactions.application;

import com.personalgarage.service.base.application.BaseRestController;
import com.personalgarage.service.core.validation.groups.ActionInsert;
import com.personalgarage.service.core.validation.groups.ActionUpdate;
import com.personalgarage.service.domain.transactions.application.interfaces.ITransactionController;
import com.personalgarage.service.domain.transactions.application.services.interfaces.ITransactionsService;
import com.personalgarage.service.domain.transactions.data.dtos.TransactionsDTO;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/transactions")
public class TransactionsController extends BaseRestController implements ITransactionController {

    private ITransactionsService transactionsService;

    public TransactionsController() {}

    @Autowired
    public TransactionsController(ITransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @Override
    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public TransactionsDTO get(@PathVariable("id") @Validated @NotBlank String id) {
        return transactionsService.get(id);
    }

    @Override
    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionsDTO insert(@RequestBody @Validated({ActionInsert.class}) TransactionsDTO transactionsDTO) {
        return transactionsService.insert(transactionsDTO);
    }

    @Override
    @PutMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public TransactionsDTO update(@RequestBody @Validated({ActionUpdate.class}) TransactionsDTO transactionsDTO) {
        return transactionsService.update(transactionsDTO);
    }

    @Override
    @DeleteMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") @Validated @NotBlank String id) {
        transactionsService.delete(id);
    }
}