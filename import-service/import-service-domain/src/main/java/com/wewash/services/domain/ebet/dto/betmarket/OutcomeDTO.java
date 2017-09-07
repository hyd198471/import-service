package com.wewash.services.domain.ebet.dto.betmarket;

import com.wewash.services.domain.ebet.dto.enums.OutcomeStatus;
import org.apache.commons.lang.builder.EqualsBuilder;

import java.math.BigDecimal;

public class OutcomeDTO {

    private long id;
    private BigDecimal odds;
    private OutcomeStatus status;
    private String name;
    private RangeDTO range;
    private boolean isTraded;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getOdds() {
        return odds;
    }

    public void setOdds(BigDecimal odds) {
        this.odds = odds;
    }

    public OutcomeStatus getStatus() {
        return status;
    }

    public void setStatus(OutcomeStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RangeDTO getRange() {
        return range;
    }

    public void setRange(RangeDTO range) {
        this.range = range;
    }

    public boolean isTraded() {
        return isTraded;
    }

    public void setTraded(boolean traded) {
        isTraded = traded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OutcomeDTO that = (OutcomeDTO) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(odds, that.odds)
                .append(status, that.status)
                .append(name, that.name)
                .append(range, that.range)
                .append(isTraded, that.isTraded)
                .isEquals();

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "OutcomeDTO{" +
                "id=" + id +
                ", odds=" + odds +
                ", status=" + status +
                ", name='" + name +
                ", range=" + range +
                '}';
    }
}