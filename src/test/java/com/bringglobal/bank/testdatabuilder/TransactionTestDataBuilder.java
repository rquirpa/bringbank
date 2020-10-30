package com.bringglobal.bank.testdatabuilder;

import com.bringglobal.bank.models.external.Account;
import com.bringglobal.bank.models.external.AccountMetadata;
import com.bringglobal.bank.models.external.Details;
import com.bringglobal.bank.models.external.Transaction;

public class TransactionTestDataBuilder {

    private String id;
    private Account thisAccount;
    private Account otherAccount;
    private Details details;
    private AccountMetadata metadata;

    public TransactionTestDataBuilder() {
        id = "abc-001";
        thisAccount = new AccountTestDataBuilder().withId("this-account").build();
        otherAccount = new AccountTestDataBuilder().withId("other-account").build();
        details = new DetailsTestDataBuilder().build();
        metadata = new AccountMetadataTestDataBuilder().build();
    }

    public TransactionTestDataBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public TransactionTestDataBuilder withThisAccount(Account thisAccount) {
        this.thisAccount = thisAccount;
        return this;
    }

    public TransactionTestDataBuilder withOtherAccount(Account otherAccount) {
        this.otherAccount = otherAccount;
        return this;
    }

    public TransactionTestDataBuilder withDetails(Details details) {
        this.details = details;
        return this;
    }

    public TransactionTestDataBuilder withMetadata(AccountMetadata metadata) {
        this.metadata = metadata;
        return this;
    }

    public Transaction build() {
        return new Transaction(
                this.id,
                this.thisAccount,
                this.otherAccount,
                this.details,
                this.metadata
        );
    }

}
