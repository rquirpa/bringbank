package com.bringglobal.bank.testdatabuilder;

import com.bringglobal.bank.models.external.Value;

import java.math.BigDecimal;

public class ValueTestDataBuilder {

    private String currency;
    private BigDecimal amount;

    public ValueTestDataBuilder() {
        currency = "USD";
        amount = new BigDecimal(10000);
    }

    public ValueTestDataBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public ValueTestDataBuilder withAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public Value build() {
        return new Value(this.currency, this.amount);
    }

}
