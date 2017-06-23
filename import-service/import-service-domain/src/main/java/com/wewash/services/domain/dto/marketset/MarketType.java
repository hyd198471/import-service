
package com.wewash.services.domain.dto.marketset;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Name",
        "IsHandicap"
})
public class MarketType {

    @JsonProperty(value = "Id", required = true)
    private int id;
    @JsonProperty(value = "Name", required = true)
    private String name;
    @JsonProperty(value = "IsHandicap", required = true)
    private boolean isHandicap;

    @JsonProperty(value = "Id", required = true)
    public int getId() {
        return id;
    }

    @JsonProperty(value = "Id", required = true)
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty(value = "Name", required = true)
    public String getName() {
        return name;
    }

    @JsonProperty(value = "Name", required = true)
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty(value = "IsHandicap", required = true)
    public boolean isIsHandicap() {
        return isHandicap;
    }

    @JsonProperty(value = "IsHandicap", required = true)
    public void setIsHandicap(boolean isHandicap) {
        this.isHandicap = isHandicap;
    }
}
