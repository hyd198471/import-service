
package com.wewash.services.domain.dto.matchdetails;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ShotsOffWoodwork",
    "IsCollected",
    "IsReliable"
})
public class ShotsOffWoodwork {

    /*
    Suppress Warnings due to not our API
        - squid:S1700 A field should not duplicate the name of its containing class
     */
    @SuppressWarnings({"squid:S1700"})
    @JsonProperty("ShotsOffWoodwork")
    private List<MatchAction> shotsOffWoodwork;
    @JsonProperty("IsCollected")
    private boolean isCollected;
    @JsonProperty("IsReliable")
    private boolean isReliable;

    @JsonProperty("ShotsOffWoodwork")
    public List<MatchAction> getShotsOffWoodwork() {
        return Collections.unmodifiableList(shotsOffWoodwork);
    }

    @JsonProperty("ShotsOffWoodwork")
    public void setShotsOffWoodwork(List<MatchAction> shotsOffWoodwork) {
        this.shotsOffWoodwork = new ArrayList<>(shotsOffWoodwork);
    }

    @JsonProperty("IsCollected")
    public boolean isIsCollected() {
        return isCollected;
    }

    @JsonProperty("IsCollected")
    public void setIsCollected(boolean isCollected) {
        this.isCollected = isCollected;
    }

    @JsonProperty("IsReliable")
    public boolean isIsReliable() {
        return isReliable;
    }

    @JsonProperty("IsReliable")
    public void setIsReliable(boolean isReliable) {
        this.isReliable = isReliable;
    }

}
