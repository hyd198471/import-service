package com.wewash.services.ebet.dto.matchstate;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class SectionDTO {
    private int sectionNumber;
    private boolean isPlayable;
    private Date startTime;
    private Date endTime;
    private List<EventPointDTO> eventPoints = Collections.emptyList();
    private List<ClockActionDTO> clockActions = Collections.emptyList();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !this.getClass().equals(o.getClass())) {
            return false;
        }

        SectionDTO that = (SectionDTO) o;

        return new EqualsBuilder()
                .append(sectionNumber, that.sectionNumber)
                .append(isPlayable, that.isPlayable)
                .append(startTime, that.startTime)
                .append(endTime, that.endTime)
                .append(eventPoints, that.eventPoints)
                .append(clockActions, that.clockActions)
                .isEquals();

    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31)
                .append(sectionNumber)
                .append(isPlayable)
                .append(startTime)
                .append(endTime)
                .append(eventPoints)
                .append(clockActions)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "SectionDTO{" +
                "sectionNumber=" + sectionNumber +
                ", isPlayable='" + isPlayable + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    @SuppressWarnings("squid:S2384")
    public Date getStartTime() {
        return startTime;
    }

    @SuppressWarnings("squid:S2384")
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @SuppressWarnings("squid:S2384")
    public Date getEndTime() {
        return endTime;
    }

    @SuppressWarnings("squid:S2384")
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @SuppressWarnings("squid:S2384")
    public List<EventPointDTO> getEventPoints() {
        return Collections.unmodifiableList(eventPoints);
    }

    @SuppressWarnings("squid:S2384")
    public void setEventPoints(List<EventPointDTO> eventPoints) {
        this.eventPoints = eventPoints;
    }

    public boolean isPlayable() {
        return isPlayable;
    }

    public void setPlayable(boolean playable) {
        isPlayable = playable;
    }

    public List<ClockActionDTO> getClockActions() {
        return new ArrayList<>(clockActions);
    }

    public void setClockActions(List<ClockActionDTO> clockActions) {
        this.clockActions = new ArrayList<>(clockActions);
    }
}
