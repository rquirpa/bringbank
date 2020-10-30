package com.bringglobal.bank.services;

import com.bringglobal.bank.helpers.FindTransaccion;
import com.bringglobal.bank.models.Transaction;
import com.bringglobal.bank.models.external.Transactions;
import com.bringglobal.bank.testdatabuilder.TransactionsTestDataBuilder;
import org.junit.jupiter.api.Test;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ListTransactionsTest {

    @Test
    public void listAllTransaction() {
        // arrange
        RestTemplate restTemplate = mock(RestTemplate.class);
        ListTransactions service = new ListTransactions(restTemplate);

        Transactions data = new TransactionsTestDataBuilder().build();

        ResponseEntity<Transactions> responseEntity = new ResponseEntity<>(
                data, HttpStatus.OK
        );

        when(restTemplate.exchange(
                service.buildUrl("savings-kids-john"),
                HttpMethod.GET,
                service.buildHttpEntity(),
                Transactions.class))
        .thenReturn(responseEntity);

        // act
        List<Transaction> actualResult = service.execute("savings-kids-john","id");

        // asserts
        assertEquals(3, actualResult.size());

        data.getTransactions().forEach(transaction -> {
            Optional<Transaction> optTx = FindTransaccion.byId(actualResult, transaction.getId());
            assertTrue(optTx.isPresent());

            Transaction tx = optTx.get();
            assertEquals(transaction.getId(), tx.getId());

            assertEquals(transaction.getDetails().getType(), tx.getTransactionType());
            assertEquals(transaction.getDetails().getValue().getCurrency(), tx.getTransactionCurrency());
            assertEquals(transaction.getDetails().getValue().getAmount(), tx.getTransactionAmount());
            assertEquals(transaction.getOtherAccount().getHolder().getName(), tx.getCounterpartyName());
        });
    }

    @Test
    public void listAllFilterByName() {
        // arrange
        RestTemplate restTemplate = mock(RestTemplate.class);
        ListTransactions service = new ListTransactions(restTemplate);

        Transactions data = new TransactionsTestDataBuilder().build();

        ResponseEntity<Transactions> responseEntity = new ResponseEntity<>(
                data, HttpStatus.OK
        );

        when(restTemplate.exchange(
                service.buildUrl("savings-kids-john"),
                HttpMethod.GET,
                service.buildHttpEntity(),
                Transactions.class))
                .thenReturn(responseEntity);

        // act
        List<Transaction> actualResult = service.execute("savings-kids-john", "id");

        // asserts
        assertEquals(3, actualResult.size());
    }

    @Test
    public void sortByStringFieldAsc() {
        // arrange
        RestTemplate restTemplate = mock(RestTemplate.class);
        ListTransactions service = new ListTransactions(restTemplate);

        Transactions data = new TransactionsTestDataBuilder().build();

        ResponseEntity<Transactions> responseEntity = new ResponseEntity<>(
                data, HttpStatus.OK
        );

        when(restTemplate.exchange(
                service.buildUrl("savings-kids-john"),
                HttpMethod.GET,
                service.buildHttpEntity(),
                Transactions.class))
                .thenReturn(responseEntity);

        // act
        List<Transaction> actualResult = service.execute("savings-kids-john", "counterpartyName");

        // asserts
        assertEquals(3, actualResult.size());
        assertEquals("Maria", actualResult.get(0).getCounterpartyName());
        assertEquals("Pedro", actualResult.get(1).getCounterpartyName());
        assertEquals("Roberto", actualResult.get(2).getCounterpartyName());

    }

    @Test
    public void sortByNumericFieldDesc() {
        // arrange
        RestTemplate restTemplate = mock(RestTemplate.class);
        ListTransactions service = new ListTransactions(restTemplate);

        Transactions data = new TransactionsTestDataBuilder().build();

        ResponseEntity<Transactions> responseEntity = new ResponseEntity<>(
                data, HttpStatus.OK
        );

        when(restTemplate.exchange(
                service.buildUrl("savings-kids-john"),
                HttpMethod.GET,
                service.buildHttpEntity(),
                Transactions.class))
                .thenReturn(responseEntity);

        // act
        List<Transaction> actualResult = service.execute("savings-kids-john", "-transactionAmount");

        // asserts
        assertEquals(3, actualResult.size());
        assertEquals(new BigDecimal(2000), actualResult.get(0).getTransactionAmount());
        assertEquals(new BigDecimal(1000), actualResult.get(1).getTransactionAmount());
        assertEquals(new BigDecimal(500), actualResult.get(2).getTransactionAmount());
    }
}