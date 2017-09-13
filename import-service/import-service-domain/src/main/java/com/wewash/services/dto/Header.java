package com.wewash.services.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "MessageGuid",
        "TimeStampUtc",
        "Retry",
        "CustomerId",
        "MessageFixtureOrder"
})
public class Header {

    @JsonProperty(value = "MessageGuid", required = true)
    private UUID messageGuid;
    @JsonProperty(value = "TimeStampUtc", required = true)
    private OffsetDateTime timeStampUtc;
    @JsonProperty(value = "Retry", required = true)
    private int retry;
    @JsonProperty(value = "CustomerId")
    private int customerId;
    @JsonProperty(value = "MessageFixtureOrder")
    private int messageFixtureOrder;

    @JsonProperty(value = "MessageGuid", required = true)
    public UUID getMessageGuid() {
        return messageGuid;
    }

    @JsonProperty(value = "MessageGuid", required = true)
    public void setMessageGuid(UUID messageGuid) {
        this.messageGuid = messageGuid;
    }

    @JsonProperty(value = "TimeStampUtc", required = true)
    public OffsetDateTime getTimeStampUtc() {
        return timeStampUtc;
    }

    @JsonProperty(value = "TimeStampUtc", required = true)
    public void setTimeStampUtc(OffsetDateTime timeStampUtc) {
        this.timeStampUtc = timeStampUtc;
    }

    @JsonProperty(value = "Retry", required = true)
    public int getRetry() {
        return retry;
    }

    @JsonProperty(value = "Retry", required = true)
    public void setRetry(int retry) {
        this.retry = retry;
    }

    @JsonProperty(value = "CustomerId")
    public int getCustomerId() {
        return customerId;
    }

    @JsonProperty(value = "CustomerId")
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @JsonProperty(value = "MessageFixtureOrder")
    public int getMessageFixtureOrder() {
        return messageFixtureOrder;
    }

    @JsonProperty(value = "MessageFixtureOrder")
    public void setMessageFixtureOrder(int messageFixtureOrder) {
        this.messageFixtureOrder = messageFixtureOrder;
    }
}
