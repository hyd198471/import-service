
package com.wewash.services.domain.dto.matchdetails;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Phase",
    "TimeElapsedInPhase",
    "DangerState",
    "IsConfirmed",
    "TimestampUtc"
})
public class DangerStateChange {

    @JsonProperty("Phase")
    private String phase;
    @JsonProperty("TimeElapsedInPhase")
    private String timeElapsedInPhase;
    @JsonProperty("DangerState")
    private String dangerState;
    @JsonProperty("IsConfirmed")
    private boolean isConfirmed;
    @JsonProperty(value = "TimestampUtc")
    private OffsetDateTime timeStampUtc;

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

    @JsonProperty("DangerState")
    public String getDangerState() {
        return dangerState;
    }

    @JsonProperty("DangerState")
    public void setDangerState(String dangerState) {
        this.dangerState = dangerState;
    }

    @JsonProperty("IsConfirmed")
    public boolean isIsConfirmed() {
        return isConfirmed;
    }

    @JsonProperty("IsConfirmed")
    public void setIsConfirmed(boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
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
