package com.bringglobal.bank.models.external;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "this_account",
        "other_account",
        "details",
        "metadata"
})
@NoArgsConstructor
public class Transaction {

    @JsonProperty("id")
    private String id;
    @JsonProperty("this_account")
    private Account thisAccount;
    @JsonProperty("other_account")
    private Account otherAccount;
    @JsonProperty("details")
    private Details details;
    @JsonProperty("metadata")
    private AccountMetadata metadata;

    public Transaction(String id, Account thisAccount, Account otherAccount,
                       Details details, AccountMetadata metadata) {
        setId(id);
        setThisAccount(thisAccount);;
        setOtherAccount(otherAccount);
        setDetails(details);
        setMetadata(metadata);
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("this_account")
    public Account getThisAccount() {
        return thisAccount;
    }

    @JsonProperty("this_account")
    public void setThisAccount(Account thisAccount) {
        this.thisAccount = thisAccount;
    }

    @JsonProperty("other_account")
    public Account getOtherAccount() {
        return otherAccount;
    }

    @JsonProperty("other_account")
    public void setOtherAccount(Account otherAccount) {
        this.otherAccount = otherAccount;
    }

    @JsonProperty("details")
    public Details getDetails() {
        return details;
    }

    @JsonProperty("details")
    public void setDetails(Details details) {
        this.details = details;
    }

    @JsonProperty("metadata")
    public AccountMetadata getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(AccountMetadata metadata) {
        this.metadata = metadata;
    }

}
