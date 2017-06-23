
package com.wewash.services.domain.dto.matchdetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Goals",
    "YellowCards",
    "SecondYellowCards",
    "StraightRedCards",
    "Substitutions",
    "ShotsOnTarget",
    "ShotsOffTarget",
    "ShotsOffWoodwork",
    "BlockedShots",
    "Corners",
    "PenaltiesAwarded",
    "Fouls",
    "Offsides",
    "GoalKicks",
    "MissedPenalties",
    "ThrowIns",
    "StoppageTimeAnnouncements",
    "PhaseChanges",
    "DangerStateChanges",
    "ClockActions",
    "BookingStateChanges",
    "SystemMessages"
})

/*
Suppress Warnings due to not our API
    - squid:S1448 for too many methods in a class
    - pmd:TooManyFields not our API DTO Class
 */
@SuppressWarnings({"squid:S1448", "pmd:TooManyFields"})
public class MatchActions {

    @JsonProperty("Goals")
    private Goals goals;
    @JsonProperty("YellowCards")
    private YellowCards yellowCards;
    @JsonProperty("SecondYellowCards")
    private SecondYellowCards secondYellowCards;
    @JsonProperty("StraightRedCards")
    private StraightRedCards straightRedCards;
    @JsonProperty("Substitutions")
    private Substitutions substitutions;
    @JsonProperty("ShotsOnTarget")
    private ShotsOnTarget shotsOnTarget;
    @JsonProperty("ShotsOffTarget")
    private ShotsOffTarget shotsOffTarget;
    @JsonProperty("ShotsOffWoodwork")
    private ShotsOffWoodwork shotsOffWoodwork;
    @JsonProperty("BlockedShots")
    private BlockedShots blockedShots;
    @JsonProperty("Corners")
    private Corners corners;
    @JsonProperty("PenaltiesAwarded")
    private PenaltiesAwarded penaltiesAwarded;
    @JsonProperty("Fouls")
    private Fouls fouls;
    @JsonProperty("Offsides")
    private Offsides offsides;
    @JsonProperty("GoalKicks")
    private GoalKicks goalKicks;
    @JsonProperty("MissedPenalties")
    private MissedPenalties missedPenalties;
    @JsonProperty("ThrowIns")
    private ThrowIns throwIns;
    @JsonProperty("StoppageTimeAnnouncements")
    private StoppageTimeAnnouncements stoppageTimeAnnouncements;
    @JsonProperty("PhaseChanges")
    private PhaseChanges phaseChanges;
    @JsonProperty("DangerStateChanges")
    private DangerStateChanges dangerStateChanges;
    @JsonProperty("ClockActions")
    private ClockActions clockActions;
    @JsonProperty("BookingStateChanges")
    private BookingStateChanges bookingStateChanges;
    @JsonProperty("SystemMessages")
    private SystemMessages systemMessages;

    @JsonProperty("Goals")
    public Goals getGoals() {
        return goals;
    }

    @JsonProperty("Goals")
    public void setGoals(Goals goals) {
        this.goals = goals;
    }

    @JsonProperty("YellowCards")
    public YellowCards getYellowCards() {
        return yellowCards;
    }

    @JsonProperty("YellowCards")
    public void setYellowCards(YellowCards yellowCards) {
        this.yellowCards = yellowCards;
    }

    @JsonProperty("SecondYellowCards")
    public SecondYellowCards getSecondYellowCards() {
        return secondYellowCards;
    }

    @JsonProperty("SecondYellowCards")
    public void setSecondYellowCards(SecondYellowCards secondYellowCards) {
        this.secondYellowCards = secondYellowCards;
    }

    @JsonProperty("StraightRedCards")
    public StraightRedCards getStraightRedCards() {
        return straightRedCards;
    }

    @JsonProperty("StraightRedCards")
    public void setStraightRedCards(StraightRedCards straightRedCards) {
        this.straightRedCards = straightRedCards;
    }

    @JsonProperty("Substitutions")
    public Substitutions getSubstitutions() {
        return substitutions;
    }

    @JsonProperty("Substitutions")
    public void setSubstitutions(Substitutions substitutions) {
        this.substitutions = substitutions;
    }

    @JsonProperty("ShotsOnTarget")
    public ShotsOnTarget getShotsOnTarget() {
        return shotsOnTarget;
    }

    @JsonProperty("ShotsOnTarget")
    public void setShotsOnTarget(ShotsOnTarget shotsOnTarget) {
        this.shotsOnTarget = shotsOnTarget;
    }

    @JsonProperty("ShotsOffTarget")
    public ShotsOffTarget getShotsOffTarget() {
        return shotsOffTarget;
    }

    @JsonProperty("ShotsOffTarget")
    public void setShotsOffTarget(ShotsOffTarget shotsOffTarget) {
        this.shotsOffTarget = shotsOffTarget;
    }

    @JsonProperty("ShotsOffWoodwork")
    public ShotsOffWoodwork getShotsOffWoodwork() {
        return shotsOffWoodwork;
    }

    @JsonProperty("ShotsOffWoodwork")
    public void setShotsOffWoodwork(ShotsOffWoodwork shotsOffWoodwork) {
        this.shotsOffWoodwork = shotsOffWoodwork;
    }

    @JsonProperty("BlockedShots")
    public BlockedShots getBlockedShots() {
        return blockedShots;
    }

    @JsonProperty("BlockedShots")
    public void setBlockedShots(BlockedShots blockedShots) {
        this.blockedShots = blockedShots;
    }

    @JsonProperty("Corners")
    public Corners getCorners() {
        return corners;
    }

    @JsonProperty("Corners")
    public void setCorners(Corners corners) {
        this.corners = corners;
    }

    @JsonProperty("PenaltiesAwarded")
    public PenaltiesAwarded getPenaltiesAwarded() {
        return penaltiesAwarded;
    }

    @JsonProperty("PenaltiesAwarded")
    public void setPenaltiesAwarded(PenaltiesAwarded penaltiesAwarded) {
        this.penaltiesAwarded = penaltiesAwarded;
    }

    @JsonProperty("Fouls")
    public Fouls getFouls() {
        return fouls;
    }

    @JsonProperty("Fouls")
    public void setFouls(Fouls fouls) {
        this.fouls = fouls;
    }

    @JsonProperty("Offsides")
    public Offsides getOffsides() {
        return offsides;
    }

    @JsonProperty("Offsides")
    public void setOffsides(Offsides offsides) {
        this.offsides = offsides;
    }

    @JsonProperty("GoalKicks")
    public GoalKicks getGoalKicks() {
        return goalKicks;
    }

    @JsonProperty("GoalKicks")
    public void setGoalKicks(GoalKicks goalKicks) {
        this.goalKicks = goalKicks;
    }

    @JsonProperty("MissedPenalties")
    public MissedPenalties getMissedPenalties() {
        return missedPenalties;
    }

    @JsonProperty("MissedPenalties")
    public void setMissedPenalties(MissedPenalties missedPenalties) {
        this.missedPenalties = missedPenalties;
    }

    @JsonProperty("ThrowIns")
    public ThrowIns getThrowIns() {
        return throwIns;
    }

    @JsonProperty("ThrowIns")
    public void setThrowIns(ThrowIns throwIns) {
        this.throwIns = throwIns;
    }

    @JsonProperty("StoppageTimeAnnouncements")
    public StoppageTimeAnnouncements getStoppageTimeAnnouncements() {
        return stoppageTimeAnnouncements;
    }

    @JsonProperty("StoppageTimeAnnouncements")
    public void setStoppageTimeAnnouncements(StoppageTimeAnnouncements stoppageTimeAnnouncements) {
        this.stoppageTimeAnnouncements = stoppageTimeAnnouncements;
    }

    @JsonProperty("PhaseChanges")
    public PhaseChanges getPhaseChanges() {
        return phaseChanges;
    }

    @JsonProperty("PhaseChanges")
    public void setPhaseChanges(PhaseChanges phaseChanges) {
        this.phaseChanges = phaseChanges;
    }

    @JsonProperty("DangerStateChanges")
    public DangerStateChanges getDangerStateChanges() {
        return dangerStateChanges;
    }

    @JsonProperty("DangerStateChanges")
    public void setDangerStateChanges(DangerStateChanges dangerStateChanges) {
        this.dangerStateChanges = dangerStateChanges;
    }

    @JsonProperty("ClockActions")
    public ClockActions getClockActions() {
        return clockActions;
    }

    @JsonProperty("ClockActions")
    public void setClockActions(ClockActions clockActions) {
        this.clockActions = clockActions;
    }

    @JsonProperty("BookingStateChanges")
    public BookingStateChanges getBookingStateChanges() {
        return bookingStateChanges;
    }

    @JsonProperty("BookingStateChanges")
    public void setBookingStateChanges(BookingStateChanges bookingStateChanges) {
        this.bookingStateChanges = bookingStateChanges;
    }

    @JsonProperty("SystemMessages")
    public SystemMessages getSystemMessages() {
        return systemMessages;
    }

    @JsonProperty("SystemMessages")
    public void setSystemMessages(SystemMessages systemMessages) {
        this.systemMessages = systemMessages;
    }

}
