
package com.wewash.services.dto.fixture;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Name"
})
public class Sport {

    @JsonProperty(value = "Id", required = true)
    private int id;
    @JsonProperty(value = "Name", required = true)
    private String name;

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
}
