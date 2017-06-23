package com.wewash.services.domain.dto.resultset;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "PercentageWin",
        "PercentagePush",
        "Place",
        "CountInPlace"
})
public class AdditionalResultData {
    @JsonProperty(value = "PercentageWin", required = true)
    private double percentageWin;
    @JsonProperty(value = "PercentagePush", required = true)
    private double percentagePush;
    @JsonProperty(value = "Place", required = true)
    private int place;
    @JsonProperty(value = "CountInPlace", required = true)
    private int countInPlace;

    @JsonProperty(value = "PercentageWin", required = true)
    public double getPercentageWin() {
        return percentageWin;
    }

    @JsonProperty(value = "PercentageWin", required = true)
    public void setPercentageWin(double percentageWin) {
        this.percentageWin = percentageWin;
    }

    @JsonProperty(value = "PercentagePush", required = true)
    public double getPercentagePush() {
        return percentagePush;
    }

    @JsonProperty(value = "PercentagePush", required = true)
    public void setPercentagePush(double percentagePush) {
        this.percentagePush = percentagePush;
    }

    @JsonProperty(value = "Place", required = true)
    public int getPlace() {
        return place;
    }

    @JsonProperty(value = "Place", required = true)
    public void setPlace(int place) {
        this.place = place;
    }

    @JsonProperty(value = "CountInPlace", required = true)
    public int getCountInPlace() {
        return countInPlace;
    }

    @JsonProperty(value = "CountInPlace", required = true)
    public void setCountInPlace(int countInPlace) {
        this.countInPlace = countInPlace;
    }
}
