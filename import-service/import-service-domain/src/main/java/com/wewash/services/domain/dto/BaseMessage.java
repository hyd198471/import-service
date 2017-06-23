package com.wewash.services.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseMessage {

    @JsonProperty(value = "Header", required = true)
    private Header header;

    @JsonProperty(value = "Header", required = true)
    public Header getHeader() {
        return header;
    }

    @JsonProperty(value = "Header", required = true)
    public void setHeader(Header header) {
        this.header = header;
    }
}
