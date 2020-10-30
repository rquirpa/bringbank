package com.bringglobal.bank.testdatabuilder;


import com.bringglobal.bank.models.external.AccountMetadata;

public class AccountMetadataTestDataBuilder {

    private String imageURL;

    public AccountMetadataTestDataBuilder() {
        imageURL = "/images/001.jpg";
    }

    public AccountMetadataTestDataBuilder setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public AccountMetadata build() {
        return new AccountMetadata(this.imageURL);
    }
}
