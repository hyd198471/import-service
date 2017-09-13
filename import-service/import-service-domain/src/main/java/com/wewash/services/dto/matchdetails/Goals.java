
package com.wewash.services.dto.matchdetails;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Goals",
    "IsCollected",
    "IsReliable"
})
public class Goals {

    @JsonProperty("Goals")
    //SuppressWarnings for field containing classname (not our API)
    @SuppressWarnings("squid:S1700")
    private List<Goal> goals;
    @JsonProperty("IsCollected")
    private boolean isCollected;
    @JsonProperty("IsReliable")
    private boolean isReliable;

    @JsonProperty("Goals")
    public List<Goal> getGoals() {
        return Collections.unmodifiableList(goals);
    }

    @JsonProperty("Goals")
    public void setGoals(List<Goal> goals) {
        this.goals = new ArrayList<>(goals);
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
