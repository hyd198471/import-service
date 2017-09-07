package com.wewash.services.domain.ebet.dto.event;

import com.wewash.services.domain.ebet.dto.betmarket.BetMarketDTO;
import com.wewash.services.domain.ebet.dto.common.MessageHeaderDTO;
import com.wewash.services.domain.ebet.dto.enums.Sport;
import com.wewash.services.domain.ebet.dto.matchstate.SectionDTO;
import org.apache.commons.lang.builder.EqualsBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class EventDTO {
    private MessageHeaderDTO messageHeader;
    private long id;
    private Sport sport;
    private Date startsAt;
    private List<ParticipantDTO> participants = Collections.emptyList();
    private boolean live;
    private GroupDTO group;
    private List<ConfigDTO> configs = Collections.emptyList();
    private List<BetMarketDTO> betMarkets = Collections.emptyList();
    private List<SectionDTO> sections = Collections.emptyList();
    private int currentSection;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !this.getClass().equals(o.getClass())) {
            return false;
        }

        EventDTO that = (EventDTO) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(live, that.live)
                .append(messageHeader, that.messageHeader)
                .append(sport, that.sport)
                .append(startsAt, that.startsAt)
                .append(participants, that.participants)
                .append(group, that.group)
                .append(configs, that.configs)
                .append(betMarkets, that.betMarkets)
                .append(sections, that.sections)
                .append(currentSection, that.currentSection)
                .isEquals();
    }

    @Override
    public int hashCode() {
        int result = messageHeader.hashCode();
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + sport.hashCode();
        result = 31 * result + startsAt.hashCode();
        result = 31 * result + participants.hashCode();
        result = 31 * result + (live ? 1 : 0);
        result = 31 * result + group.hashCode();
        result = 31 * result + configs.hashCode();
        result = 31 * result + betMarkets.hashCode();
        result = 31 * result + sections.hashCode();
        result = 31 * result + currentSection;
        return result;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    @SuppressWarnings("squid:S2384")
    public Date getStartsAt() {
        return startsAt;
    }

    @SuppressWarnings("squid:S2384")
    public void setStartsAt(Date startsAt) {
        this.startsAt = startsAt;
    }

    @SuppressWarnings("squid:S2384")
    public List<ParticipantDTO> getParticipants() {
        return participants;
    }

    @SuppressWarnings("squid:S2384")
    public void setParticipants(List<ParticipantDTO> participants) {
        this.participants = participants;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public GroupDTO getGroup() {
        return group;
    }

    public void setGroup(GroupDTO group) {
        this.group = group;
    }

    @SuppressWarnings("squid:S2384")
    public List<ConfigDTO> getConfigs() {
        return configs;
    }

    @SuppressWarnings("squid:S2384")
    public void setConfigs(List<ConfigDTO> configs) {
        this.configs = configs;
    }


    public MessageHeaderDTO getMessageHeader() {
        return messageHeader;
    }

    public void setMessageHeader(MessageHeaderDTO messageHeader) {
        this.messageHeader = messageHeader;
    }

    public List<BetMarketDTO> getBetMarkets() {
        return new ArrayList<>(betMarkets);
    }

    public void setBetMarkets(List<BetMarketDTO> betMarkets) {
        this.betMarkets = new ArrayList<>(betMarkets);
    }

    public List<SectionDTO> getSections() {
        return new ArrayList<>(sections);
    }

    public void setSections(List<SectionDTO> sections) {
        this.sections = new ArrayList<>(sections);
    }

    public int getCurrentSection() {
        return currentSection;
    }

    public void setCurrentSection(int currentSection) {
        this.currentSection = currentSection;
    }

    @Override
    public String toString() {
        return "EventDTO{" +
                "messageHeader=" + messageHeader +
                ", id=" + id +
                ", sport=" + sport +
                ", startsAt=" + startsAt +
                ", participants=" + participants +
                ", live=" + live +
                ", group=" + group +
                ", configs=" + configs +
                ", betMarkets=" + betMarkets +
                ", sections=" + sections +
                ", currentSection=" + currentSection +
                '}';
    }
}
