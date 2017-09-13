
package com.wewash.services.dto.matchdetails;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "SequenceId",
    "Phase",
    "TimeElapsedInPhase",
    "Message",
    "Timestamp"
})
public class SystemMessage {

    @JsonProperty("SequenceId")
    private int sequenceId;
    @JsonProperty("Phase")
    private String phase;
    @JsonProperty("TimeElapsedInPhase")
    private String timeElapsedInPhase;
    @JsonProperty("Message")
    private String message;
    @JsonProperty("Timestamp")
    private String timestamp;

    @JsonProperty("SequenceId")
    public int getSequenceId() {
        return sequenceId;
    }

    @JsonProperty("SequenceId")
    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
    }

    @JsonProperty("Phase")
    public String getPhase() {
        return phase;
    }

    @JsonProperty("Phase")
    public void setPhase(String phase) {
        this.phase = phase;
    }

    @JsonProperty("TimeElapsedInPhase")
    public String getTimeElapsedInPhase() {
        return timeElapsedInPhase;
    }

    @JsonProperty("TimeElapsedInPhase")
    public void setTimeElapsedInPhase(String timeElapsedInPhase) {
        this.timeElapsedInPhase = timeElapsedInPhase;
    }

    @JsonProperty("Message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("Message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("Timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty("Timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
