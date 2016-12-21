package com.personalgarage.service.api.domain.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personalgarage.service.base.BaseTest;
import com.personalgarage.service.data.TestTransactions;
import com.personalgarage.service.api.domain.transactions.application.TransactionsController;
import com.personalgarage.service.api.domain.transactions.data.dtos.TransactionsDTO;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.LinkedHashMap;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionsIntegrationTest extends BaseTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionsController transactionsController;

    @Test
    @WithMockUser
    public void givenValidTransactionIdReturnsTransactionDTO() throws Exception {
        TransactionsDTO transaction = new TransactionsDTO();
        transaction.setId(TestTransactions.FUEL_PURCHASE_1.getId());
        when(transactionsController.get(TestTransactions.FUEL_PURCHASE_1.getId())).thenReturn(transaction);

        mockMvc.perform(get("/transactions/{id}", TestTransactions.FUEL_PURCHASE_1.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", equalTo((ArgumentMatcher<String>) argument ->
                        TestTransactions.FUEL_PURCHASE_1.getId().equals(argument))));

        verify(transactionsController, times(1)).get(TestTransactions.FUEL_PURCHASE_1.getId());
        verifyNoMoreInteractions(transactionsController);
    }

    @Test
    @WithMockUser
    public void givenValidTransactionsDTOReturnsInsertedTransactionsDTO() throws Exception {
        TransactionsDTO insertTransaction = new TransactionsDTO();
        insertTransaction.setId(null);
        insertTransaction.setUserId(TestTransactions.FUEL_PURCHASE_1.getUserId());
        insertTransaction.setCarId(TestTransactions.FUEL_PURCHASE_1.getCarId());
        insertTransaction.setTransactionsTypes(TestTransactions.FUEL_PURCHASE_1.getTransactionsTypes());
        insertTransaction.setCreatedTime(TestTransactions.FUEL_PURCHASE_1.getCreatedTime());
        insertTransaction.setLastUpdatedTime(TestTransactions.FUEL_PURCHASE_1.getLastUpdatedTime());
        insertTransaction.setAmount(TestTransactions.FUEL_PURCHASE_1.getAmount());
        insertTransaction.setDescription(TestTransactions.FUEL_PURCHASE_1.getDescription());

        TransactionsDTO resultTransaction = new TransactionsDTO();
        resultTransaction.setId(TestTransactions.FUEL_PURCHASE_1.getId());
        resultTransaction.setUserId(TestTransactions.FUEL_PURCHASE_1.getUserId());
        resultTransaction.setCarId(TestTransactions.FUEL_PURCHASE_1.getCarId());
        resultTransaction.setTransactionsTypes(TestTransactions.FUEL_PURCHASE_1.getTransactionsTypes());
        resultTransaction.setCreatedTime(TestTransactions.FUEL_PURCHASE_1.getCreatedTime());
        resultTransaction.setLastUpdatedTime(TestTransactions.FUEL_PURCHASE_1.getLastUpdatedTime());
        resultTransaction.setAmount(TestTransactions.FUEL_PURCHASE_1.getAmount());
        resultTransaction.setDescription(TestTransactions.FUEL_PURCHASE_1.getDescription());

        when(transactionsController.insert(insertTransaction)).thenReturn(resultTransaction);

        mockMvc.perform(post("/transactions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writer().writeValueAsBytes(insertTransaction)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$", Matchers.equalTo((ArgumentMatcher<LinkedHashMap<String, String>>) argument ->
                        TestTransactions.FUEL_PURCHASE_1.getId().equals(argument.get("id"))
                                && TestTransactions.FUEL_PURCHASE_1.getUserId().equals(argument.get("userId")))));

        verify(transactionsController, times(1)).insert(insertTransaction);
        verifyNoMoreInteractions(transactionsController);
    }

    @Test
    @WithMockUser
    public void givenValidTransactionsDTOReturnsUpdatedTransactionsDTO() throws Exception {
        TransactionsDTO updateTransaction = new TransactionsDTO();
        updateTransaction.setId(TestTransactions.FUEL_PURCHASE_1.getId());
        updateTransaction.setUserId(TestTransactions.FUEL_PURCHASE_1.getUserId());
        updateTransaction.setCarId(TestTransactions.FUEL_PURCHASE_1.getCarId());
        updateTransaction.setTransactionsTypes(TestTransactions.FUEL_PURCHASE_1.getTransactionsTypes());
        updateTransaction.setCreatedTime(TestTransactions.FUEL_PURCHASE_1.getCreatedTime());
        updateTransaction.setLastUpdatedTime(TestTransactions.FUEL_PURCHASE_1.getLastUpdatedTime());
        updateTransaction.setAmount(TestTransactions.FUEL_PURCHASE_1.getAmount());
        updateTransaction.setDescription(TestTransactions.FUEL_PURCHASE_1.getDescription());

        TransactionsDTO resultTransaction = new TransactionsDTO();
        resultTransaction.setId(TestTransactions.FUEL_PURCHASE_1.getId());
        resultTransaction.setUserId(TestTransactions.FUEL_PURCHASE_1.getUserId());
        resultTransaction.setCarId(TestTransactions.FUEL_PURCHASE_1.getCarId());
        resultTransaction.setTransactionsTypes(TestTransactions.FUEL_PURCHASE_1.getTransactionsTypes());
        resultTransaction.setCreatedTime(TestTransactions.FUEL_PURCHASE_1.getCreatedTime());
        resultTransaction.setLastUpdatedTime(TestTransactions.FUEL_PURCHASE_1.getLastUpdatedTime());
        resultTransaction.setAmount(TestTransactions.FUEL_PURCHASE_1.getAmount());
        resultTransaction.setDescription(TestTransactions.FUEL_PURCHASE_1.getDescription());

        when(transactionsController.update(updateTransaction)).thenReturn(resultTransaction);

        mockMvc.perform(put("/transactions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writer().writeValueAsBytes(updateTransaction)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", equalTo((ArgumentMatcher<LinkedHashMap<String, String>>) argument ->
                        TestTransactions.FUEL_PURCHASE_1.getId().equals(argument.get("id"))
                                && TestTransactions.FUEL_PURCHASE_1.getUserId().equals(argument.get("userId")))));

        verify(transactionsController, times(1)).update(updateTransaction);
        verifyNoMoreInteractions(transactionsController);
    }

    @Test
    @WithMockUser
    public void givenValidDeleteTransactionIdReturnsNoContent() throws Exception {
        mockMvc.perform(delete("/transactions/{id}", TestTransactions.FUEL_PURCHASE_1.getId()))
                .andExpect(status().isNoContent());

        verify(transactionsController, times(1)).delete(TestTransactions.FUEL_PURCHASE_1.getId());
        verifyNoMoreInteractions(transactionsController);
    }
}