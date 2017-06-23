
package com.wewash.services.domain.dto.marketset;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Sequence",
        "TradingStatus",
        "Name",
        "ExpiryUtc",
        "Handicap",
        "MarketType",
        "InPlay",
        "Selections",
        "ExternalId",
        "CashOutStatus"
})
public class Market {

    @JsonProperty(value = "Id", required = true)
    private int id;
    @JsonProperty("Sequence")
    private int sequence;
    @JsonProperty(value = "TradingStatus", required = true)
    private String tradingStatus;
    @JsonProperty(value = "Name", required = true)
    private String name;
    @JsonProperty(value = "ExpiryUtc", required = true)
    private OffsetDateTime expiryUtc;
    @JsonProperty("Handicap")
    private double handicap;
    @JsonProperty(value = "MarketType", required = true)
    private MarketType marketType;
    @JsonProperty(value = "InPlay", required = true)
    private boolean inPlay;
    @JsonProperty(value = "Selections", required = true)
    private List<Selection> selections;

    @JsonProperty(value = "ExternalId")
    private String externalId;

    @JsonProperty(value = "CashOutStatus")
    private CashOutStatus cashOutStatus;

    enum CashOutStatus {
        Open,
        Suspended,
        Closed
    }

    @JsonProperty(value = "Id", required = true)
    public int getId() {
        return id;
    }

    @JsonProperty(value = "Id", required = true)
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("Sequence")
    public int getSequence() {
        return sequence;
    }

    @JsonProperty("Sequence")
    public void setSequence(int sequence) {
        this.sequence = sequence;
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

    @JsonProperty(value = "ExpiryUtc", required = true)
    public OffsetDateTime getExpiryUtc() {
        return expiryUtc;
    }

    @JsonProperty(value = "ExpiryUtc", required = true)
    public void setExpiryUtc(OffsetDateTime expiryUtc) {
        this.expiryUtc = expiryUtc;
    }

    @JsonProperty("Handicap")
    public double getHandicap() {
        return handicap;
    }

    @JsonProperty("Handicap")
    public void setHandicap(double handicap) {
        this.handicap = handicap;
    }

    @JsonProperty(value = "MarketType", required = true)
    public MarketType getMarketType() {
        return marketType;
    }

    @JsonProperty(value = "MarketType", required = true)
    public void setMarketType(MarketType marketType) {
        this.marketType = marketType;
    }

    @JsonProperty(value = "InPlay", required = true)
    public boolean isInPlay() {
        return inPlay;
    }

    @JsonProperty(value = "InPlay", required = true)
    public void setInPlay(boolean inPlay) {
        this.inPlay = inPlay;
    }

    @JsonProperty(value = "Selections", required = true)
    public List<Selection> getSelections() {
        return Collections.unmodifiableList(selections);
    }

    @JsonProperty(value = "Selections", required = true)
    public void setSelections(List<Selection> selections) {
        this.selections = new ArrayList<>(selections);
    }

    @JsonProperty(value = "ExternalId")
    public String getExternalId() {
        return externalId;
    }

    @JsonProperty(value = "ExternalId")
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    @JsonProperty(value = "CashOutStatus")
    public CashOutStatus getCashOutStatus() {
        return cashOutStatus;
    }

    @JsonProperty(value = "CashOutStatus")
    public void setCashOutStatus(CashOutStatus cashOutStatus) {
        this.cashOutStatus = cashOutStatus;
    }
}
