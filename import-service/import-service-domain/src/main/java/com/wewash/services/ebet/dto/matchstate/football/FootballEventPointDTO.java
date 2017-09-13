package com.wewash.services.ebet.dto.matchstate.football;

import com.wewash.services.ebet.dto.matchstate.EventPointDTO;
import org.apache.commons.lang.builder.EqualsBuilder;

public class FootballEventPointDTO extends EventPointDTO {
    public static final String TYPE_IDENTIFIER = "football-generic";

    public enum EventPointType {
        CORNER,
        YELLOW_CARD,
        RED_CARD
    }

    private EventPointType type;
    private long playerId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !this.getClass().equals(o.getClass())) {
            return false;
        }

        FootballEventPointDTO that = (FootballEventPointDTO) o;

        return new EqualsBuilder()
                .append(type, that.type)
                .append(playerId, that.playerId)
                .isEquals();

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (playerId ^ (playerId >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "FootballEventPointDTO{" +
                "type=" + type +
                ", playerId='" + playerId + '\'' +
                '}';
    }

    public EventPointType getType() {
        return type;
    }

    public void setType(EventPointType type) {
        this.type = type;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    @Override
    public String getSchemaType() {
        return TYPE_IDENTIFIER;
    }
}
