package com.zuehlke.microservices.uebung1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RatingServiceResponse {

    private final String source;
    private final String value;

    @JsonCreator
    public RatingServiceResponse(@JsonProperty("source") String source,
            @JsonProperty("value") String value) {
        this.source = source;
        this.value = value;
    }

    public String getSource() {
        return source;
    }

    public String getValue() {
        return value;
    }
}
