package com.wewash.services.dto.coverage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.wewash.services.dto.BaseMessage;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Header",
    "Coverage"
})
public class CoverageMessage extends BaseMessage {

    @JsonProperty(value = "Coverage", required = true)
    private Coverage coverage;

    public Coverage getCoverage() {
        return coverage;
    }

    public void setCoverage(Coverage coverage) {
        this.coverage = coverage;
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Coverage {
        @JsonProperty(value = "FixtureId", required = true)
        private long fixtureId;
        @JsonProperty(value = "IsBooked", required = true)
        private boolean isBooked;

        public long getFixtureId() {
            return fixtureId;
        }

        public void setFixtureId(long fixtureId) {
            this.fixtureId = fixtureId;
        }

        public boolean isBooked() {
            return isBooked;
        }

        public void setBooked(boolean booked) {
            isBooked = booked;
        }
    }
}
