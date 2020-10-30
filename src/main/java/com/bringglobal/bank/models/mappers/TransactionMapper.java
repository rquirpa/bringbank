package com.bringglobal.bank.models.mappers;

import com.bringglobal.bank.models.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionMapper {

    private TransactionMapper() {}

    public static Transaction map(com.bringglobal.bank.models.external.Transaction externalTransaction) {
        return new Transaction(
                externalTransaction.getId(),
                externalTransaction.getThisAccount().getId(),
                externalTransaction.getOtherAccount().getNumber(),
                externalTransaction.getOtherAccount().getHolder().getName(),
                externalTransaction.getOtherAccount().getMetadata().getImageURL(),
                externalTransaction.getDetails().getValue().getAmount(),
                externalTransaction.getDetails().getValue().getCurrency(),
                externalTransaction.getDetails().getValue().getAmount(),
                externalTransaction.getDetails().getValue().getCurrency(),
                externalTransaction.getDetails().getType(),
                externalTransaction.getDetails().getDescription()
        );
    }

    public static List<Transaction> map(List<com.bringglobal.bank.models.external.Transaction> externalTransactions) {
        List<Transaction> transactions = new ArrayList<>();
        if (externalTransactions != null) {
            externalTransactions.forEach(transaction -> transactions.add(map(transaction)));
        }
        return transactions;
    }

}
