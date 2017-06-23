
package com.wewash.services.domain.dto.marketset;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.wewash.services.domain.dto.BaseMessage;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Header",
        "MarketSet"
})
public class MarketSetMessage extends BaseMessage {
    @JsonProperty(value = "MarketSet", required = true)
    private MarketSet marketSet;

    @JsonProperty(value = "MarketSet", required = true)
    public MarketSet getMarketSet() {
        return marketSet;
    }

    @JsonProperty(value = "MarketSet", required = true)
    public void setMarketSet(MarketSet marketSet) {
        this.marketSet = marketSet;
    }

}
