
package com.wewash.services.domain.dto.matchdetails;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "PreviousPhase",
    "CurrentPhase",
    "CurrentPhaseStartTime",
    "IsConfirmed",
    "MessageId",
    "Message",
    "TimestampUtc"
})
public class PhaseChange {

    @JsonProperty("PreviousPhase")
    private String previousPhase;
    @JsonProperty("CurrentPhase")
    private String currentPhase;
    @JsonProperty("CurrentPhaseStartTime")
    private OffsetDateTime currentPhaseStartTime;
    @JsonProperty("IsConfirmed")
    private boolean isConfirmed;
    @JsonProperty("MessageId")
    private int messageId;
    @JsonProperty("Message")
    private String message;
    @JsonProperty(value = "TimestampUtc")
    private OffsetDateTime timeStampUtc;

    @JsonProperty("PreviousPhase")
    public String getPreviousPhase() {
        return previousPhase;
    }

    @JsonProperty("PreviousPhase")
    public void setPreviousPhase(String previousPhase) {
        this.previousPhase = previousPhase;
    }

    @JsonProperty("CurrentPhase")
    public String getCurrentPhase() {
        return currentPhase;
    }

    @JsonProperty("CurrentPhase")
    public void setCurrentPhase(String currentPhase) {
        this.currentPhase = currentPhase;
    }

    @JsonProperty("CurrentPhaseStartTime")
    public OffsetDateTime getCurrentPhaseStartTime() {
        return currentPhaseStartTime;
    }

    @JsonProperty("CurrentPhaseStartTime")
    public void setCurrentPhaseStartTime(OffsetDateTime currentPhaseStartTime) {
        this.currentPhaseStartTime = currentPhaseStartTime;
    }

    @JsonProperty("IsConfirmed")
    public boolean isIsConfirmed() {
        return isConfirmed;
    }

    @JsonProperty("IsConfirmed")
    public void setIsConfirmed(boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    @JsonProperty("MessageId")
    public int getMessageId() {
        return messageId;
    }

    @JsonProperty("MessageId")
    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @JsonProperty("Message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("Message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty(value = "TimestampUtc")
    public OffsetDateTime getTimeStampUtc() {
        return timeStampUtc;
    }

    @JsonProperty(value = "TimestampUtc")
    public void setTimeStampUtc(OffsetDateTime timeStampUtc) {
        this.timeStampUtc = timeStampUtc;
    }

}
