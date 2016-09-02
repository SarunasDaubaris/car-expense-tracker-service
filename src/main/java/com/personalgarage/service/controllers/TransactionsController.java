package com.personalgarage.service.controllers;

import com.personalgarage.service.base.controllers.BaseRestController;
import com.personalgarage.service.base.validation.groups.ActionInsert;
import com.personalgarage.service.base.validation.groups.ActionUpdate;
import com.personalgarage.service.controllers.interfaces.ITransactionController;
import com.personalgarage.service.dto.TransactionsDTO;
import com.personalgarage.service.services.interfaces.ITransactionsService;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

public class TransactionsController extends BaseRestController implements ITransactionController {

    private ITransactionsService transactionsService;

    public TransactionsController() {}

    @Autowired
    public TransactionsController(ITransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @GetMapping(value = "/transactions/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public TransactionsDTO get(@PathVariable("id") @Validated @NotBlank String id) {
        return transactionsService.get(id);
    }

    @PostMapping(value = "/transactions", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionsDTO insert(@RequestBody @Validated({ActionInsert.class}) TransactionsDTO transactionsDTO) {
        return transactionsService.insert(transactionsDTO);
    }

    @PutMapping(value = "/transactions", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public TransactionsDTO update(@RequestBody @Validated({ActionUpdate.class}) TransactionsDTO transactionsDTO) {
        return transactionsService.update(transactionsDTO);
    }

    @DeleteMapping(value = "/transactions/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") @Validated @NotBlank String id) {
        transactionsService.delete(id);
    }
}