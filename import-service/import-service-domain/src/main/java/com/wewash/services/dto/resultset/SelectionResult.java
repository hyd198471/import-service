
package com.wewash.services.dto.resultset;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "SelectionId",
        "ResultStatus",
        "AdditionalResultData"
})
public class SelectionResult {

    @JsonProperty(value = "SelectionId", required = true)
    private int selectionId;
    @JsonProperty(value = "ResultStatus", required = true)
    private String resultStatus;
    @JsonProperty("AdditionalResultData")
    private AdditionalResultData additionalResultData;


    @JsonProperty(value = "SelectionId", required = true)
    public int getSelectionId() {
        return selectionId;
    }

    @JsonProperty(value = "SelectionId", required = true)
    public void setSelectionId(int selectionId) {
        this.selectionId = selectionId;
    }

    @JsonProperty(value = "ResultStatus", required = true)
    public String getResultStatus() {
        return resultStatus;
    }

    @JsonProperty(value = "ResultStatus", required = true)
    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    @JsonProperty("AdditionalResultData")
    public AdditionalResultData getAdditionalResultData() {
        return additionalResultData;
    }

    @JsonProperty("AdditionalResultData")
    public void setAdditionalResultData(AdditionalResultData additionalResultData) {
        this.additionalResultData = additionalResultData;
    }
}
