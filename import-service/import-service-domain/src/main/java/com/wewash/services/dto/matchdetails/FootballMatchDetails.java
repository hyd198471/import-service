
package com.wewash.services.dto.matchdetails;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CustomerId",
    "FixtureId",
    "MatchActions",
    "AwayTeam",
    "HomeTeam",
    "IsSecondLeg",
    "FirstLegScore",
    "NormalTimeHalfDuration",
    "ExtraTimeHalfDuration",
    "CanGoToExtraTime",
    "CanGoStraightToPenaltiesAfterNormalTime",
    "CanGoToPenalties",
    "MessageTimestampUtc"
})
public class FootballMatchDetails {

    @JsonProperty("CustomerId")
    private int customerId;
    @JsonProperty("FixtureId")
    private String fixtureId;
    @JsonProperty("MatchActions")
    private MatchActions matchActions;
    @JsonProperty("AwayTeam")
    private AwayTeam awayTeam;
    @JsonProperty("HomeTeam")
    private HomeTeam homeTeam;
    @JsonProperty("IsSecondLeg")
    private boolean isSecondLeg;
    @JsonProperty("FirstLegScore")
    private Score firstLegScore;
    @JsonProperty("NormalTimeHalfDuration")
    private String normalTimeHalfDuration;
    @JsonProperty("ExtraTimeHalfDuration")
    private String extraTimeHalfDuration;
    @JsonProperty("CanGoToExtraTime")
    private boolean canGoToExtraTime;
    @JsonProperty("CanGoStraightToPenaltiesAfterNormalTime")
    private boolean canGoStraightToPenaltiesAfterNormalTime;
    @JsonProperty("CanGoToPenalties")
    private boolean canGoToPenalties;
    @JsonProperty("MessageTimestampUtc")
    private OffsetDateTime messageTimestampUtc;

    @JsonProperty("CustomerId")
    public int getCustomerId() {
        return customerId;
    }

    @JsonProperty("CustomerId")
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @JsonProperty("FixtureId")
    public String getFixtureId() {
        return fixtureId;
    }

    @JsonProperty("FixtureId")
    public void setFixtureId(String fixtureId) {
        this.fixtureId = fixtureId;
    }

    @JsonProperty("MatchActions")
    public MatchActions getMatchActions() {
        return matchActions;
    }

    @JsonProperty("MatchActions")
    public void setMatchActions(MatchActions matchActions) {
        this.matchActions = matchActions;
    }

    @JsonProperty("AwayTeam")
    public AwayTeam getAwayTeam() {
        return awayTeam;
    }

    @JsonProperty("AwayTeam")
    public void setAwayTeam(AwayTeam awayTeam) {
        this.awayTeam = awayTeam;
    }

    @JsonProperty("HomeTeam")
    public HomeTeam getHomeTeam() {
        return homeTeam;
    }

    @JsonProperty("HomeTeam")
    public void setHomeTeam(HomeTeam homeTeam) {
        this.homeTeam = homeTeam;
    }

    @JsonProperty("IsSecondLeg")
    public boolean isIsSecondLeg() {
        return isSecondLeg;
    }

    @JsonProperty("IsSecondLeg")
    public void setIsSecondLeg(boolean isSecondLeg) {
        this.isSecondLeg = isSecondLeg;
    }

    @JsonProperty("FirstLegScore")
    public Score getFirstLegScore() {
        return firstLegScore;
    }

    @JsonProperty("FirstLegScore")
    public void setFirstLegScore(Score firstLegScore) {
        this.firstLegScore = firstLegScore;
    }

    @JsonProperty("NormalTimeHalfDuration")
    public String getNormalTimeHalfDuration() {
        return normalTimeHalfDuration;
    }

    @JsonProperty("NormalTimeHalfDuration")
    public void setNormalTimeHalfDuration(String normalTimeHalfDuration) {
        this.normalTimeHalfDuration = normalTimeHalfDuration;
    }

    @JsonProperty("ExtraTimeHalfDuration")
    public String getExtraTimeHalfDuration() {
        return extraTimeHalfDuration;
    }

    @JsonProperty("ExtraTimeHalfDuration")
    public void setExtraTimeHalfDuration(String extraTimeHalfDuration) {
        this.extraTimeHalfDuration = extraTimeHalfDuration;
    }

    @JsonProperty("CanGoToExtraTime")
    public boolean isCanGoToExtraTime() {
        return canGoToExtraTime;
    }

    @JsonProperty("CanGoToExtraTime")
    public void setCanGoToExtraTime(boolean canGoToExtraTime) {
        this.canGoToExtraTime = canGoToExtraTime;
    }

    @JsonProperty("CanGoStraightToPenaltiesAfterNormalTime")
    public boolean isCanGoStraightToPenaltiesAfterNormalTime() {
        return canGoStraightToPenaltiesAfterNormalTime;
    }

    @JsonProperty("CanGoStraightToPenaltiesAfterNormalTime")
    public void setCanGoStraightToPenaltiesAfterNormalTime(boolean canGoStraightToPenaltiesAfterNormalTime) {
        this.canGoStraightToPenaltiesAfterNormalTime = canGoStraightToPenaltiesAfterNormalTime;
    }

    @JsonProperty("CanGoToPenalties")
    public boolean isCanGoToPenalties() {
        return canGoToPenalties;
    }

    @JsonProperty("CanGoToPenalties")
    public void setCanGoToPenalties(boolean canGoToPenalties) {
        this.canGoToPenalties = canGoToPenalties;
    }

    @JsonProperty("MessageTimestampUtc")
    public OffsetDateTime getMessageTimestampUtc() {
        return messageTimestampUtc;
    }

    @JsonProperty("MessageTimestampUtc")
    public void setMessageTimestampUtc(OffsetDateTime messageTimestampUtc) {
        this.messageTimestampUtc = messageTimestampUtc;
    }

}
