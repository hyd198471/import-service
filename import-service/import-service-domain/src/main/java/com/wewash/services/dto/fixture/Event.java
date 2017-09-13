
package com.wewash.services.dto.fixture;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.wewash.services.dto.BaseMessage;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Header",
        "Fixture"
})
public class Event extends BaseMessage {
    @JsonProperty(value = "Fixture", required = true)
    private Fixture fixture;

    @JsonProperty(value = "Fixture", required = true)
    public Fixture getFixture() {
        return fixture;
    }

    @JsonProperty(value = "Fixture", required = true)
    public void setFixture(Fixture fixture) {
        this.fixture = fixture;
    }

}
