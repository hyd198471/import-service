package com.wewash.services.domain.dto.fixture;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "CurrentHomeTeamFirstLegScore",
        "CurrentAwayTeamFirstLegScore"
})
public class AggregateEventInfo {
    @JsonProperty(value = "CurrentHomeTeamFirstLegScore", required = true)
    private int currentHomeTeamFirstLegScore;
    @JsonProperty(value = "CurrentAwayTeamFirstLegScore", required = true)
    private int currentAwayTeamFirstLegScore;

    @JsonProperty(value = "CurrentHomeTeamFirstLegScore", required = true)
    public int getCurrentHomeTeamFirstLegScore() {
        return currentHomeTeamFirstLegScore;
    }

    @JsonProperty(value = "CurrentHomeTeamFirstLegScore", required = true)
    public void setCurrentHomeTeamFirstLegScore(int currentHomeTeamFirstLegScore) {
        this.currentHomeTeamFirstLegScore = currentHomeTeamFirstLegScore;
    }

    @JsonProperty(value = "CurrentAwayTeamFirstLegScore", required = true)
    public int getCurrentAwayTeamFirstLegScore() {
        return currentAwayTeamFirstLegScore;
    }

    @JsonProperty(value = "CurrentAwayTeamFirstLegScore", required = true)
    public void setCurrentAwayTeamFirstLegScore(int currentAwayTeamFirstLegScore) {
        this.currentAwayTeamFirstLegScore = currentAwayTeamFirstLegScore;
    }
}
