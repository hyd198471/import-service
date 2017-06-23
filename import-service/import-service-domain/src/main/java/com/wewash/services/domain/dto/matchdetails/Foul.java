
package com.wewash.services.domain.dto.matchdetails;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Phase",
    "TimeElapsedInPhase",
    "FoulingTeam",
    "IsConfirmed",
    "TimestampUtc"
})
public class Foul {

    @JsonProperty("Phase")
    private String phase;
    @JsonProperty("TimeElapsedInPhase")
    private String timeElapsedInPhase;
    @JsonProperty("FoulingTeam")
    private String foulingTeam;
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

    @JsonProperty("FoulingTeam")
    public String getFoulingTeam() {
        return foulingTeam;
    }

    @JsonProperty("FoulingTeam")
    public void setFoulingTeam(String foulingTeam) {
        this.foulingTeam = foulingTeam;
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
