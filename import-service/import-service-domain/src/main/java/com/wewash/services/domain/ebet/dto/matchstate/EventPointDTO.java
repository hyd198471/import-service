package com.wewash.services.domain.ebet.dto.matchstate;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.wewash.services.domain.ebet.dto.matchstate.football.FootballEventPointDTO;
import com.wewash.services.domain.ebet.dto.matchstate.football.FootballScoreEventPointDTO;
import org.apache.commons.lang.builder.EqualsBuilder;

import java.util.Date;

/*
* If you think this looks ugly, you're right.
*
* The Zindane micro-services are using the (far newer) fasterxml version of Jackson - produced
* by fasterxml (a github project).
* It's the fork of the codehaus code that was created when codehaus closed and jackson needed to be housed somewhere
* else.
*
* However, E-Bet is using the (far older) codehaus version. When the repos changed/etc, it was decided to
* change the package names, which meant people could use one or the other. Now, we're in the place where we're
* migrating, between them, but our code needs to work in the meantime - so... we're forced into annotating
* with both sets of annotations...
* */
@org.codehaus.jackson.annotate.JsonTypeInfo(
    property = "schemaType",
    use = org.codehaus.jackson.annotate.JsonTypeInfo.Id.NAME,
    include = org.codehaus.jackson.annotate.JsonTypeInfo.As.PROPERTY
)
@org.codehaus.jackson.annotate.JsonSubTypes({
    @org.codehaus.jackson.annotate.JsonSubTypes.Type(
        value = FootballEventPointDTO.class, name = FootballEventPointDTO.TYPE_IDENTIFIER),
    @org.codehaus.jackson.annotate.JsonSubTypes.Type(
        value = FootballScoreEventPointDTO.class, name = FootballScoreEventPointDTO.TYPE_IDENTIFIER)
})
@JsonTypeInfo(property = "schemaType", use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY)
@JsonSubTypes({
    @JsonSubTypes.Type(
        value = FootballEventPointDTO.class, name = FootballEventPointDTO.TYPE_IDENTIFIER),
    @JsonSubTypes.Type(
        value = FootballScoreEventPointDTO.class, name = FootballScoreEventPointDTO.TYPE_IDENTIFIER)
})
public abstract class EventPointDTO {
    private Date occurredAt;
    private long gameClockElapsedInSection;
    private long participantId;
    //Looks not used - but needed for codehaus object mapper to work correctly (WHHHHHYYYY????)
    @SuppressWarnings("squid:S1068")
    private String schemaType;

    @SuppressWarnings("squid:S2384")
    public Date getOccurredAt() {
        return occurredAt;
    }

    @SuppressWarnings("squid:S2384")
    public void setOccurredAt(Date occurredAt) {
        this.occurredAt = occurredAt;
    }

    public long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(long participantId) {
        this.participantId = participantId;
    }

    public long getGameClockElapsedInSection() {
        return gameClockElapsedInSection;
    }

    public void setGameClockElapsedInSection(long gameClockElapsedInSection) {
        this.gameClockElapsedInSection = gameClockElapsedInSection;
    }

    public abstract String getSchemaType();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EventPointDTO that = (EventPointDTO) o;
        return new EqualsBuilder()
                .append(gameClockElapsedInSection, that.gameClockElapsedInSection)
                .append(participantId, that.participantId)
                .append(occurredAt, that.occurredAt)
                .isEquals();
    }

    @Override
    public int hashCode() {
        int result = occurredAt != null ? occurredAt.hashCode() : 0;
        result = 31 * result + (int) (gameClockElapsedInSection ^ (gameClockElapsedInSection >>> 32));
        result = 31 * result + (int) (participantId ^ (participantId >>> 32));
        return result;
    }
}
