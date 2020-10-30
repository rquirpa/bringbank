package com.bringglobal.bank.testdatabuilder;

import com.bringglobal.bank.models.external.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TransactionsTestDataBuilder {

    private Value TWO_THOUSAND = new ValueTestDataBuilder().withAmount(new BigDecimal(2000)).build();
    private Value ONE_THOUSAND = new ValueTestDataBuilder().withAmount(new BigDecimal(1000)).build();
    private Value FIVE_HUNDRED = new ValueTestDataBuilder().withAmount(new BigDecimal(500)).build();

    private Account MARIA_ACOUNT = new AccountTestDataBuilder()
            .withId("maria-account")
            .withHolder(new Holder("Maria"))
            .build();

    private Account PEDRO_ACOUNT = new AccountTestDataBuilder()
            .withId("pedro-account")
            .withHolder(new Holder("Pedro"))
            .build();

    private Account ROBERTO_ACOUNT = new AccountTestDataBuilder()
            .withId("roberto-account")
            .withHolder(new Holder("Roberto"))
            .build();


    private List<Transaction> transactions = null;

    public TransactionsTestDataBuilder() {
        transactions = new ArrayList<>();

        TransactionTestDataBuilder transactionTestDataBuilder = new TransactionTestDataBuilder();
        DetailsTestDataBuilder detailsTestDataBuilder = new DetailsTestDataBuilder();

        transactions.add(
                transactionTestDataBuilder
                        .withId("tx-002")
                        .withOtherAccount(PEDRO_ACOUNT)
                        .withDetails(
                                detailsTestDataBuilder
                                        .withValue(ONE_THOUSAND)
                                        .withType("XYZ")
                                        .build()
                        ).build()
        );

        transactions.add(
                transactionTestDataBuilder
                        .withId("tx-001")
                        .withOtherAccount(MARIA_ACOUNT)
                        .withDetails(
                                detailsTestDataBuilder
                                        .withValue(TWO_THOUSAND)
                                        .withType("ABC")
                                        .build()
                        ).build()
        );

        transactions.add(
                transactionTestDataBuilder
                        .withId("tx-003")
                        .withOtherAccount(ROBERTO_ACOUNT)
                        .withDetails(
                                detailsTestDataBuilder
                                        .withValue(FIVE_HUNDRED)
                                        .withType("XYZ")
                                        .build()
                        ).build()
        );

    }

    public TransactionsTestDataBuilder setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
        return this;
    }

    public Transactions build() {
        return new Transactions(this.transactions);
    }

}
