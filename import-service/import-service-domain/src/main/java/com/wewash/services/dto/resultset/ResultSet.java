
package com.wewash.services.dto.resultset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "FixtureId",
        "Results"
})
public class ResultSet {

    @JsonProperty(value = "FixtureId", required = true)
    private int fixtureId;
    @JsonProperty(value = "Results", required = true)
    private List<Result> results;

    @JsonProperty(value = "FixtureId", required = true)
    public int getFixtureId() {
        return fixtureId;
    }

    @JsonProperty(value = "FixtureId", required = true)
    public void setFixtureId(int fixtureId) {
        this.fixtureId = fixtureId;
    }

    @JsonProperty(value = "Results", required = true)
    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }

    @JsonProperty(value = "Results", required = true)
    public void setResults(List<Result> results) {
        this.results = new ArrayList<>(results);
    }
}
