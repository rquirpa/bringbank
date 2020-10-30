package com.bringglobal.bank.testdatabuilder;

import com.bringglobal.bank.models.external.Holder;

public class HolderTestDataBuilder {

    private String name;

    public HolderTestDataBuilder() {
        name = "ALIAS_03C57D";
    }

    public HolderTestDataBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public Holder build() {
        return new Holder(this.name);
    }
}
