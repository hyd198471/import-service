package com.wewash.services.domain.messageloggers;

import com.wewash.services.domain.dto.matchsummary.FootballMatchSummaryMessage;
import com.wewash.services.model.MessageType;
import org.springframework.stereotype.Service;

@Service
public class FootballMatchSummaryMessageLogger extends MessageLogger<FootballMatchSummaryMessage>{
    @Override
    protected long getFixtureId(FootballMatchSummaryMessage message) {
        return Long.parseLong(message.getFootballMatchSummary().getFixtureId());
    }

    @Override
    Class<FootballMatchSummaryMessage> getMessageClass() {
        return FootballMatchSummaryMessage.class;
    }

    @Override
    MessageType getMessageType() {
        return MessageType.FOOTBALLMATCHSUMMARY;
    }
}
