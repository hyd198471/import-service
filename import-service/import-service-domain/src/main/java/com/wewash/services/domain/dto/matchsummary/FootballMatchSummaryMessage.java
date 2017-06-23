package com.wewash.services.domain.dto.matchsummary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.wewash.services.domain.dto.BaseMessage;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Header",
    "Coverage"
})
public class FootballMatchSummaryMessage extends BaseMessage {

    @JsonProperty(value = "FootballMatchSummary", required = true)
    private FootballMatchSummary footballMatchSummary;

    public FootballMatchSummary getFootballMatchSummary() {
        return footballMatchSummary;
    }

    public void setFootballMatchSummary(FootballMatchSummary footballMatchSummary) {
        this.footballMatchSummary = footballMatchSummary;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FootballMatchSummary {
        @JsonProperty(value = "FixtureId", required = true)
        private String fixtureId;

        public String getFixtureId() {
            return fixtureId;
        }

        public void setFixtureId(String fixtureId) {
            this.fixtureId = fixtureId;
        }
    }
}
