
package com.wewash.services.dto.matchdetails;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Phase",
    "TimeElapsedInPhase",
    "ActivityType",
    "IsClockRunning",
    "IsConfirmed",
    "TimestampUtc"
})
public class ClockAction {

    @JsonProperty("Phase")
    private String phase;
    @JsonProperty("TimeElapsedInPhase")
    private String timeElapsedInPhase;
    @JsonProperty("ActivityType")
    private String activityType;
    @JsonProperty("IsClockRunning")
    private boolean isClockRunning;
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

    @JsonProperty("ActivityType")
    public String getActivityType() {
        return activityType;
    }

    @JsonProperty("ActivityType")
    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    @JsonProperty("IsClockRunning")
    public boolean isIsClockRunning() {
        return isClockRunning;
    }

    @JsonProperty("IsClockRunning")
    public void setIsClockRunning(boolean isClockRunning) {
        this.isClockRunning = isClockRunning;
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
