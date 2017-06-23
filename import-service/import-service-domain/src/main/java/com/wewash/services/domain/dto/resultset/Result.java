
package com.wewash.services.domain.dto.resultset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "MarketId",
        "MarketSequence",
        "Results"
})
public class Result {

    @JsonProperty(value = "MarketId", required = true)
    private int marketId;
    @JsonProperty(value = "MarketSequence")
    private int marketSequence;
    @JsonProperty(value = "Results", required = true)
    private List<SelectionResult> results;

    @JsonProperty(value = "MarketId", required = true)
    public int getMarketId() {
        return marketId;
    }

    @JsonProperty(value = "MarketId", required = true)
    public void setMarketId(int marketId) {
        this.marketId = marketId;
    }

    @JsonProperty(value = "MarketSequence")
    public int getMarketSequence() {
        return marketSequence;
    }

    @JsonProperty(value = "MarketSequence")
    public void setMarketSequence(int marketSequence) {
        this.marketSequence = marketSequence;
    }

    @JsonProperty(value = "Results", required = true)
    public List<SelectionResult> getResults() {
        return Collections.unmodifiableList(results);
    }

    @JsonProperty(value = "Results", required = true)
    public void setResults(List<SelectionResult> results) {
        this.results = new ArrayList<>(results);
    }
}
