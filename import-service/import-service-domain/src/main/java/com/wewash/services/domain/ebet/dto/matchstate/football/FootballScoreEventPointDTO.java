package com.wewash.services.domain.ebet.dto.matchstate.football;

import com.wewash.services.domain.ebet.dto.matchstate.EventPointDTO;
import org.apache.commons.lang.builder.EqualsBuilder;

public class FootballScoreEventPointDTO extends EventPointDTO {
    public static final String TYPE_IDENTIFIER = "football-score";

    private long playerId;
    private boolean isPenalty;

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public boolean getIsPenalty() {
        return isPenalty;
    }

    public void setIsPenalty(boolean penalty) {
        isPenalty = penalty;
    }

    @Override
    public String getSchemaType() {
        return TYPE_IDENTIFIER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FootballScoreEventPointDTO that = (FootballScoreEventPointDTO) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(that))
                .append(playerId, that.playerId)
                .append(isPenalty, that.isPenalty)
                .isEquals();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (playerId ^ (playerId >>> 32));
        result = 31 * result + (isPenalty ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FootballScoreEventPointDTO{" +
                "playerId=" + playerId +
                ", isPenalty='" + isPenalty +
                '}';
    }
}
