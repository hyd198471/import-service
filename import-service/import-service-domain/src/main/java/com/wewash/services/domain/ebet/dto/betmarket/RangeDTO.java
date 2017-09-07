package com.wewash.services.domain.ebet.dto.betmarket;

import org.apache.commons.lang.builder.EqualsBuilder;

import java.math.BigDecimal;

public class RangeDTO {
    private BigDecimal lowValue;
    private BigDecimal highValue;

    public BigDecimal getLowValue() {
        return lowValue;
    }

    public void setLowValue(BigDecimal lowValue) {
        this.lowValue = lowValue;
    }

    public BigDecimal getHighValue() {
        return highValue;
    }

    public void setHighValue(BigDecimal highValue) {
        this.highValue = highValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()){
            return false;
        }


        RangeDTO other = (RangeDTO) o;

        return new EqualsBuilder()
                .append(lowValue, other.lowValue)
                .append(highValue, other.highValue)
                .isEquals();
    }


    @Override
    public int hashCode() {
        int result = lowValue != null ? lowValue.hashCode() : 0;
        result = 31 * result + (highValue != null ? highValue.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RangeDTO{" +
                "lowValue=" + lowValue +
                ", highValue=" + highValue +
                '}';
    }
}
