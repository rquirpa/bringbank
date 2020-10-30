package com.bringglobal.bank.testdatabuilder;

import com.bringglobal.bank.models.external.Account;
import com.bringglobal.bank.models.external.AccountMetadata;
import com.bringglobal.bank.models.external.Holder;

public class AccountTestDataBuilder {

    private String id;
    private Holder holder;
    private String number;
    private AccountMetadata metadata;

    public AccountTestDataBuilder() {
        id = "savings-kids-john";
        holder = new HolderTestDataBuilder().build();
        number = "58aeed54-7042-456d-af86-f517bff5b7af";
        metadata = new AccountMetadataTestDataBuilder().build();
    }

    public AccountTestDataBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public AccountTestDataBuilder withHolder(Holder holder) {
        this.holder = holder;
        return this;
    }

    public AccountTestDataBuilder withNumber(String number) {
        this.number = number;
        return this;
    }

    public AccountTestDataBuilder withMetadata(AccountMetadata metadata) {
        this.metadata = metadata;
        return this;
    }

    public Account build() {
        return new Account(
                this.id,
                this.holder,
                this.number,
                this.metadata
        );
    }
}
