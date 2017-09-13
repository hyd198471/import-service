
package com.wewash.services.dto.marketset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "FixtureId",
        "Markets"
})
public class MarketSet {

    @JsonProperty(value = "FixtureId", required = true)
    private int fixtureId;

    @JsonProperty(value = "Markets", required = true)
    private List<Market> markets;

    @JsonProperty(value = "FixtureId", required = true)
    public int getFixtureId() {
        return fixtureId;
    }

    @JsonProperty(value = "FixtureId", required = true)
    public void setFixtureId(int fixtureId) {
        this.fixtureId = fixtureId;
    }

    @JsonProperty(value = "Markets", required = true)
    public List<Market> getMarkets() {
        return Collections.unmodifiableList(markets);
    }

    @JsonProperty(value = "Markets", required = true)
    public void setMarkets(List<Market> markets) {
        this.markets = new ArrayList<>(markets);
    }
}
