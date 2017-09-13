
package com.wewash.services.dto.marketset;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "TradingStatus",
        "Name",
        "CompetitorId",
        "Outcome",
        "Range",
        "Numerator",
        "Denominator",
        "Decimal",
        "Probability",
        "ExternalId"
})
public class Selection {

    @JsonProperty(value = "Id", required = true)
    private int id;
    @JsonProperty(value = "TradingStatus", required = true)
    private String tradingStatus;
    @JsonProperty(value = "Name", required = true)
    private String name;
    @JsonProperty("CompetitorId")
    private int competitorId;
    @JsonProperty("Outcome")
    private Outcome outcome;
    @JsonProperty("Range")
    private Range range;
    @JsonProperty(value = "Numerator", required = true)
    private int numerator;
    @JsonProperty(value = "Denominator", required = true)
    private int denominator;
    @JsonProperty(value = "Decimal", required = true)
    private double decimal;
    @JsonProperty("Probability")
    private double probability;
    @JsonProperty("ExternalId")
    private String externalId;

    @JsonProperty(value = "Id", required = true)
    public int getId() {
        return id;
    }

    @JsonProperty(value = "Id", required = true)
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty(value = "TradingStatus", required = true)
    public String getTradingStatus() {
        return tradingStatus;
    }

    @JsonProperty(value = "TradingStatus", required = true)
    public void setTradingStatus(String tradingStatus) {
        this.tradingStatus = tradingStatus;
    }

    @JsonProperty(value = "Name", required = true)
    public String getName() {
        return name;
    }

    @JsonProperty(value = "Name", required = true)
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Outcome")
    public Outcome getOutcome() {
        return outcome;
    }

    @JsonProperty("Outcome")
    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    @JsonProperty(value = "Numerator", required = true)
    public int getNumerator() {
        return numerator;
    }

    @JsonProperty(value = "Numerator", required = true)
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    @JsonProperty(value = "Denominator", required = true)
    public int getDenominator() {
        return denominator;
    }

    @JsonProperty(value = "Denominator", required = true)
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    @JsonProperty(value = "Decimal", required = true)
    public double getDecimal() {
        return decimal;
    }

    @JsonProperty(value = "Decimal", required = true)
    public void setDecimal(double decimal) {
        this.decimal = decimal;
    }

    @JsonProperty("CompetitorId")
    public int getCompetitorId() {
        return competitorId;
    }

    @JsonProperty("CompetitorId")
    public void setCompetitorId(int competitorId) {
        this.competitorId = competitorId;
    }

    @JsonProperty("Range")
    public Range getRange() {
        return range;
    }

    @JsonProperty("Range")
    public void setRange(Range range) {
        this.range = range;
    }

    @JsonProperty("Probability")
    public double getProbability() {
        return probability;
    }

    @JsonProperty("Probability")
    public void setProbability(double probability) {
        this.probability = probability;
    }

    @JsonProperty("ExternalId")
    public String getExternalId() {
        return externalId;
    }

    @JsonProperty("ExternalId")
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }
}
