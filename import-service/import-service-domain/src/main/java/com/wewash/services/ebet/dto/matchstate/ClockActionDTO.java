package com.wewash.services.ebet.dto.matchstate;

import com.wewash.services.ebet.dto.enums.ClockActionType;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.Date;

public class ClockActionDTO {

    private ClockActionType type;

    private Date occurredAt;

    public ClockActionType getType() {
        return type;
    }

    public void setType(ClockActionType type) {
        this.type = type;
    }

    public Date getOccurredAt() {
        return new Date(occurredAt.getTime());
    }

    public void setOccurredAt(Date occurredAt) {
        this.occurredAt = new Date(occurredAt.getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ClockActionDTO that = (ClockActionDTO) o;

        return new EqualsBuilder()
                .append(type, that.type)
                .append(occurredAt, that.occurredAt)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(type)
                .append(occurredAt)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "ClockActionDTO{" +
                "type=" + type +
                ", occurredAt=" + occurredAt +
                '}';
    }
}
