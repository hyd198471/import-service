
package com.wewash.services.domain.dto.matchdetails;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.wewash.services.domain.dto.BaseMessage;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Header",
    "FootballMatchDetails"
})
public class FootballMatchDetailsMessage extends BaseMessage {

    @JsonProperty(value = "FootballMatchDetails", required = true)
    private FootballMatchDetails footballMatchDetails;

    @JsonProperty(value = "FootballMatchDetails", required = true)
    public FootballMatchDetails getFootballMatchDetails() {
        return footballMatchDetails;
    }

    @JsonProperty(value = "FootballMatchDetails", required = true)
    public void setFootballMatchDetails(FootballMatchDetails footballMatchDetails) {
        this.footballMatchDetails = footballMatchDetails;
    }

}
