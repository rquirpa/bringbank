package com.bringglobal.bank.testdatabuilder;


import com.bringglobal.bank.models.external.Details;
import com.bringglobal.bank.models.external.Value;

public class DetailsTestDataBuilder {

    private String type;
    private String description;
    private Value value;

    public DetailsTestDataBuilder() {
        type = "SEPA";
        description = "This is a SEPA Transaction Request";
        value = new ValueTestDataBuilder().build();
    }

    public DetailsTestDataBuilder withType(String type) {
        this.type = type;
        return this;
    }

    public DetailsTestDataBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public DetailsTestDataBuilder withValue(Value value) {
        this.value = value;
        return this;
    }

    public Details build () {
        return new Details(
                this.type,
                this.description,
                this.value
        );
    }
}
