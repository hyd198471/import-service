package com.wewash.services.domain.dto.matchdetails;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Home",
        "Away"
})
public class Score {

    @JsonProperty("Home")
    private int home;

    @JsonProperty("Away")
    private int away;

    @JsonProperty("Home")
    public int getHome() {
        return home;
    }

    @JsonProperty("Home")
    public void setHome(int home) {
        this.home = home;
    }

    @JsonProperty("Away")
    public int getAway() {
        return away;
    }

    @JsonProperty("Away")
    public void setAway(int away) {
        this.away = away;
    }
}
