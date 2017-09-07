package com.wewash.services.domain.ebet.dto.betmarket;

import com.wewash.services.domain.ebet.dto.enums.BetMarketStatus;
import org.apache.commons.lang.builder.EqualsBuilder;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class BetMarketDTO {

    private long id;

    private BetMarketTypeDTO betMarketType;

    private List<String> parameters = Collections.emptyList();

    private List<OutcomeDTO> outcomes = Collections.emptyList();

    private BetMarketStatus betMarketStatus;

    private Date expiresAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BetMarketTypeDTO getBetMarketType() {
        return betMarketType;
    }

    public void setBetMarketType(BetMarketTypeDTO betMarketType) {
        this.betMarketType = betMarketType;
    }

    @SuppressWarnings("squid:S2384")
    public List<String> getParameters() {
        return parameters;
    }

    @SuppressWarnings("squid:S2384")
    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    @SuppressWarnings("squid:S2384")
    public List<OutcomeDTO> getOutcomes() {
        return outcomes;
    }

    @SuppressWarnings("squid:S2384")
    public void setOutcomes(List<OutcomeDTO> outcomes) {
        this.outcomes = outcomes;
    }

    public BetMarketStatus getBetMarketStatus() {
        return betMarketStatus;
    }

    public void setBetMarketStatus(BetMarketStatus betMarketStatus) {
        this.betMarketStatus = betMarketStatus;
    }

    @SuppressWarnings("squid:S2384")
    public Date getExpiresAt() {
        return expiresAt;
    }

    @SuppressWarnings("squid:S2384")
    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BetMarketDTO other = (BetMarketDTO) o;

        return new EqualsBuilder()
                .append(id, other.id)
                .append(betMarketType, other.betMarketType)
                .append(outcomes, other.outcomes)
                .append(betMarketStatus, other.betMarketStatus)
                .append(expiresAt, other.expiresAt)
                .isEquals();

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "BetMarketDTO{" +
                "id=" + id +
                ", betMarketType=" + betMarketType +
                ", parameters=" + parameters +
                ", outcomes=" + outcomes +
                ", betMarketStatus=" + betMarketStatus +
                ", expiresAt=" + expiresAt +
                '}';
    }
}