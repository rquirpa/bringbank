package com.bringglobal.bank.models.external;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "holder",
        "number",
        "metadata"
})
@NoArgsConstructor
public class Account {

    @JsonProperty("id")
    private String id;
    @JsonProperty("holder")
    private Holder holder;
    @JsonProperty("number")
    private String number;
    @JsonProperty("metadata")
    private AccountMetadata metadata;

    public Account(String id, Holder holder, String number, AccountMetadata metadata) {
        setId(id);
        setHolder(holder);
        setNumber(number);
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

    @JsonProperty("holder")
    public Holder getHolder() {
        return holder;
    }

    @JsonProperty("holder")
    public void setHolder(Holder holder) {
        this.holder = holder;
    }

    @JsonProperty("number")
    public String getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(String number) {
        this.number = number;
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
