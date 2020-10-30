package com.bringglobal.bank.services;

import com.bringglobal.bank.models.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class ListTransactionsByTransactionType {

    private ListTransactions listTransactionsService;

    public ListTransactionsByTransactionType(ListTransactions listTransactionsService) {
        this.listTransactionsService = listTransactionsService;
    }

    public List<Transaction> execute(String accountId, String transactionType) {
        List<Transaction> allTransaction = listTransactionsService.execute(accountId,null);
        return filterByTransactionType(allTransaction, transactionType);
    }

    private List<Transaction> filterByTransactionType(List<Transaction> transactions, String transactionType) {
        return transactions.stream()
                .filter(transaction -> transaction.getTransactionType().equals(transactionType))
                .collect(Collectors.toList());
    }

}
