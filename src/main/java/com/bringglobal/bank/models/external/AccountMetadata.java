package com.bringglobal.bank.models.external;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class AccountMetadata {

    @JsonProperty("image_URL")
    private String imageURL;

    public AccountMetadata(String imageURL) {
        setImageURL(imageURL);
    }

    @JsonProperty("image_URL")
    public String getImageURL() {
        return imageURL;
    }

    @JsonProperty("image_URL")
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

}
