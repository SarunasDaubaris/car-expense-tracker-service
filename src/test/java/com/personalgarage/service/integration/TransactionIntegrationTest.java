package com.personalgarage.service.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personalgarage.service.base.BaseTest;
import com.personalgarage.service.data.TestTransactions;
import com.personalgarage.service.main.transactions.application.TransactionController;
import com.personalgarage.service.main.transactions.interfaces.dtos.TransactionDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionIntegrationTest extends BaseTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionController transactionsController;

    @Test
    @WithMockUser
    public void givenValidTransactionIdReturnsTransactionDTO() throws Exception {
        TransactionDTO transaction = new TransactionDTO();
        transaction.setId(TestTransactions.FUEL_PURCHASE_1.getId());
        when(transactionsController.getTransactionById(TestTransactions.FUEL_PURCHASE_1.getId())).thenReturn(transaction);

        mockMvc.perform(get("/transactions/{id}", TestTransactions.FUEL_PURCHASE_1.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(TestTransactions.FUEL_PURCHASE_1.getId().intValue())));

        verify(transactionsController, times(1)).getTransactionById(TestTransactions.FUEL_PURCHASE_1.getId());
        verifyNoMoreInteractions(transactionsController);
    }

    @Test
    @WithMockUser
    public void givenValidTransactionDTOReturnsInsertedTransactionDTO() throws Exception {
        TransactionDTO insertTransaction = new TransactionDTO();
        insertTransaction.setId(null);
        insertTransaction.setUserId(TestTransactions.FUEL_PURCHASE_1.getUserId());
        insertTransaction.setCarId(TestTransactions.FUEL_PURCHASE_1.getCarId());
        insertTransaction.setTransactionType(TestTransactions.FUEL_PURCHASE_1.getTransactionsTypes());
        insertTransaction.setAmount(TestTransactions.FUEL_PURCHASE_1.getAmount());
        insertTransaction.setDescription(TestTransactions.FUEL_PURCHASE_1.getDescription());

        TransactionDTO resultTransaction = new TransactionDTO();
        resultTransaction.setId(TestTransactions.FUEL_PURCHASE_1.getId());
        resultTransaction.setUserId(TestTransactions.FUEL_PURCHASE_1.getUserId());
        resultTransaction.setCarId(TestTransactions.FUEL_PURCHASE_1.getCarId());
        resultTransaction.setTransactionType(TestTransactions.FUEL_PURCHASE_1.getTransactionsTypes());
        resultTransaction.setAmount(TestTransactions.FUEL_PURCHASE_1.getAmount());
        resultTransaction.setDescription(TestTransactions.FUEL_PURCHASE_1.getDescription());

        when(transactionsController.createTransaction(insertTransaction)).thenReturn(resultTransaction);

        mockMvc.perform(post("/transactions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writer().writeValueAsBytes(insertTransaction)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(TestTransactions.FUEL_PURCHASE_1.getId().intValue())))
                .andExpect(jsonPath("$.userId", is(TestTransactions.FUEL_PURCHASE_1.getUserId().intValue())))
                .andExpect(jsonPath("$.carId", is(TestTransactions.FUEL_PURCHASE_1.getCarId().intValue())));

        verify(transactionsController, times(1)).createTransaction(insertTransaction);
        verifyNoMoreInteractions(transactionsController);
    }
}