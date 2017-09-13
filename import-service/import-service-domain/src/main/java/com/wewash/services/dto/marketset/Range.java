package com.wewash.services.dto.marketset;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "High",
        "Low"
})
public class Range {
    @JsonProperty(value = "High")
    private BigDecimal high;

    @JsonProperty(value = "Low")
    private BigDecimal low;

    @JsonProperty(value = "High")
    public BigDecimal getHigh() {
        return high;
    }

    @JsonProperty(value = "High")
    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    @JsonProperty(value = "Low")
    public BigDecimal getLow() {
        return low;
    }

    @JsonProperty(value = "Low")
    public void setLow(BigDecimal low) {
        this.low = low;
    }
}
