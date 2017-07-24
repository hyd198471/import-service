package com.wewash.services.domain.messageloggers;

import com.wewash.services.domain.dto.coverage.CoverageMessage;
import com.wewash.services.model.MessageType;
import org.springframework.stereotype.Service;

@Service
public class CoverageMessageLogger extends MessageLogger<CoverageMessage> {
    @Override
    protected long getFixtureId(CoverageMessage message) {
        return message.getCoverage().getFixtureId();
    }

    @Override
    Class<CoverageMessage> getMessageClass() {
        return CoverageMessage.class;
    }

    @Override
    MessageType getMessageType() {
        return MessageType.COVERAGE;
    }
}
