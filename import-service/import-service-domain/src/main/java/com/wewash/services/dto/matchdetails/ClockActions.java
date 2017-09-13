
package com.wewash.services.dto.matchdetails;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ClockActions",
    "IsCollected",
    "IsReliable"
})
public class ClockActions {

    /*
    Suppress Warnings due to not our API
        - squid:S1700 A field should not duplicate the name of its containing class
     */
    @SuppressWarnings({"squid:S1700"})
    @JsonProperty("ClockActions")
    private List<ClockAction> clockActions;
    @JsonProperty("IsCollected")
    private boolean isCollected;
    @JsonProperty("IsReliable")
    private boolean isReliable;

    @JsonProperty("ClockActions")
    public List<ClockAction> getClockActions() {
        return Collections.unmodifiableList(clockActions);
    }

    @JsonProperty("ClockActions")
    public void setClockActions(List<ClockAction> clockActions) {
        this.clockActions = new ArrayList<>(clockActions);
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
