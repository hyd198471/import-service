package com.wewash.services.messageloggers;

import com.wewash.services.dto.matchdetails.FootballMatchDetailsMessage;
import com.wewash.services.model.MessageType;
import org.springframework.stereotype.Service;


@Service
public class MatchDetailsMessageLogger extends MessageLogger<FootballMatchDetailsMessage> {

    @Override
    protected long getFixtureId(FootballMatchDetailsMessage message) {
        return Long.valueOf(message.getFootballMatchDetails().getFixtureId());
    }

    @Override
    Class<FootballMatchDetailsMessage> getMessageClass() {
        return FootballMatchDetailsMessage.class;
    }

    @Override
    MessageType getMessageType() {
        return MessageType.FOOTBALLMATCHDETAILS;
    }

}
