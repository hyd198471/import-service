
package com.wewash.services.dto.resultset;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.wewash.services.dto.BaseMessage;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Header",
        "ResultSet"
})
public class ResultSetMessage extends BaseMessage {
    @JsonProperty(value = "ResultSet", required = true)
    private ResultSet resultSet;

    @JsonProperty(value = "ResultSet", required = true)
    public ResultSet getResultSet() {
        return resultSet;
    }

    @JsonProperty(value = "ResultSet", required = true)
    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
}
