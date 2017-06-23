
package com.wewash.services.domain.dto.matchdetails;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Phase",
    "TimeElapsedInPhase",
    "Team",
    "ScoredByPlayerId",
    "IsOwnGoal",
    "WasScoredFromPenalty",
    "IsConfirmed",
    "TimestampUtc"
})
public class Goal {

    @JsonProperty("Phase")
    private String phase;
    @JsonProperty("TimeElapsedInPhase")
    private String timeElapsedInPhase;
    @JsonProperty("Team")
    private String team;
    @JsonProperty("ScoredByPlayerId")
    private int scoredByPlayerId;
    @JsonProperty("IsOwnGoal")
    private boolean isOwnGoal;
    @JsonProperty("WasScoredFromPenalty")
    private boolean wasScoredFromPenalty;
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

    @JsonProperty("Team")
    public String getTeam() {
        return team;
    }

    @JsonProperty("Team")
    public void setTeam(String team) {
        this.team = team;
    }

    @JsonProperty("ScoredByPlayerId")
    public int getScoredByPlayerId() {
        return scoredByPlayerId;
    }

    @JsonProperty("ScoredByPlayerId")
    public void setScoredByPlayerId(int scoredByPlayerId) {
        this.scoredByPlayerId = scoredByPlayerId;
    }

    @JsonProperty("IsOwnGoal")
    public boolean isIsOwnGoal() {
        return isOwnGoal;
    }

    @JsonProperty("IsOwnGoal")
    public void setIsOwnGoal(boolean isOwnGoal) {
        this.isOwnGoal = isOwnGoal;
    }

    @JsonProperty("WasScoredFromPenalty")
    public boolean isWasScoredFromPenalty() {
        return wasScoredFromPenalty;
    }

    @JsonProperty("WasScoredFromPenalty")
    public void setWasScoredFromPenalty(boolean wasScoredFromPenalty) {
        this.wasScoredFromPenalty = wasScoredFromPenalty;
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
