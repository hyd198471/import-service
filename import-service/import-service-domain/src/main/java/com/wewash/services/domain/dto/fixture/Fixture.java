package com.wewash.services.domain.dto.fixture;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "Id",
        "Name",
        "FixtureType",
        "Status",
        "StartTimeUtc",
        "Sport",
        "Competition",
        "Season",
        "TourSeason",
        "Round",
        "Competitors",
        "AggregateEventInfo",
        "ExternalId",
        "AssociationFixtureId",
        "IsOff"
})
public final class Fixture {
    @JsonProperty(value = "Id", required = true)
    private long id;
    @JsonProperty(value = "Name", required = true)
    private String name;
    @JsonProperty(value = "FixtureType", required = true)
    private FixtureType fixtureType;
    @JsonProperty(value = "Status", required = true)
    private FixtureStatus fixtureStatus;
    @JsonProperty(value = "StartTimeUtc", required = true)
    private OffsetDateTime startTimeUtc;
    @JsonProperty(value = "Sport", required = true)
    private Sport sport;
    @JsonProperty(value = "Competition", required = true)
    private Competition competition;
    @JsonProperty(value = "Season", required = true)
    private Season season;
    @JsonProperty(value = "TourSeason")
    private Season tourSeason;
    @JsonProperty(value = "Round")
    private Round round;
    @JsonProperty(value = "Competitors", required = true)
    private List<Competitor> competitors;
    @JsonProperty(value = "AggregateEventInfo")
    private AggregateEventInfo aggregateEventInfo;
    @JsonProperty(value = "ExternalId")
    private String externalId;
    @JsonProperty(value = "AssociationFixtureId")
    private String associationFixtureId;

    public Fixture() {
        //needed for Jackson
    }

    @SuppressWarnings("squid:S00107")
    public Fixture(long id,
                    String name,
                    FixtureType fixtureType,
                    FixtureStatus fixtureStatus,
                    OffsetDateTime startTimeUtc,
                    Sport sport,
                    Competition competition,
                    Season season,
                    Season tourSeason,
                    Round round,
                    List<Competitor> competitors,
                    AggregateEventInfo aggregateEventInfo,
                    String externalId,
                    String associationFixtureId) {
        this.id = id;
        this.name = name;
        this.fixtureType = fixtureType;
        this.fixtureStatus = fixtureStatus;
        this.startTimeUtc = startTimeUtc;
        this.sport = sport;
        this.competition = competition;
        this.season = season;
        this.tourSeason = tourSeason;
        this.round = round;
        this.competitors = Collections.unmodifiableList(competitors);
        this.aggregateEventInfo = aggregateEventInfo;
        this.externalId = externalId;
        this.associationFixtureId = associationFixtureId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public FixtureType getFixtureType() {
        return fixtureType;
    }

    public FixtureStatus getFixtureStatus() {
        return fixtureStatus;
    }

    public OffsetDateTime getStartTimeUtc() {
        return startTimeUtc;
    }

    public Sport getSport() {
        return sport;
    }

    public Competition getCompetition() {
        return competition;
    }

    public Season getSeason() {
        return season;
    }

    public Season getTourSeason() {
        return tourSeason;
    }

    public Round getRound() {
        return round;
    }

    public List<Competitor> getCompetitors() {
        return Collections.unmodifiableList(competitors);
    }

    public AggregateEventInfo getAggregateEventInfo() {
        return aggregateEventInfo;
    }

    public String getExternalId() {
        return externalId;
    }

    public String getAssociationFixtureId() {
        return associationFixtureId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFixtureType(FixtureType fixtureType) {
        this.fixtureType = fixtureType;
    }

    public void setFixtureStatus(FixtureStatus fixtureStatus) {
        this.fixtureStatus = fixtureStatus;
    }

    public void setStartTimeUtc(OffsetDateTime startTimeUtc) {
        this.startTimeUtc = startTimeUtc;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public void setTourSeason(Season tourSeason) {
        this.tourSeason = tourSeason;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public void setCompetitors(List<Competitor> competitors) {
        this.competitors = new ArrayList<>(competitors);
    }

    public void setAggregateEventInfo(AggregateEventInfo aggregateEventInfo) {
        this.aggregateEventInfo = aggregateEventInfo;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public void setAssociationFixtureId(String associationFixtureId) {
        this.associationFixtureId = associationFixtureId;
    }
}
