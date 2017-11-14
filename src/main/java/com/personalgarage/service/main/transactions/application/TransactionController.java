package com.personalgarage.service.main.transactions.application;

import com.personalgarage.service.main.transactions.application.services.interfaces.ITransactionService;
import com.personalgarage.service.main.transactions.interfaces.dtos.TransactionDTO;
import com.personalgarage.service.main.transactions.interfaces.messages.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private ITransactionService transactionService;

    public TransactionController() {
    }

    @Autowired
    public TransactionController(@Qualifier("transactionService") ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Long createTransaction(@RequestBody @Validated @NotNull TransactionDTO transactionDTO) {
        CreateTransactionRequest request = new CreateTransactionRequest();
        request.transactionDTO = transactionDTO;
        CreateTransactionResponse response = transactionService.createTransaction(request);
        return response.transactionId;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public TransactionDTO getTransactionById(@PathVariable("id") @Validated @NotNull Long id) {
        GetTransactionByIdRequest request = new GetTransactionByIdRequest();
        request.transactionId = id;
        GetTransactionByIdResponse response = transactionService.getTransactionById(request);
        return response.transactionDTO;
    }

    @GetMapping(value = "/cars/{carId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionDTO> getAllTransactionsByCarId(@PathVariable("carId") @Validated @NotNull Long id) {
        GetAllTransactionsByCarIdRequest request = new GetAllTransactionsByCarIdRequest();
        request.carId = id;
        GetAllTransactionsByCarIdResponse response = transactionService.getAllTransactionsByCarId(request);
        return response.transactionDTOs;
    }
}