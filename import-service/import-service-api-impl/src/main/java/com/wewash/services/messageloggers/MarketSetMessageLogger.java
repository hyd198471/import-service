package com.wewash.services.messageloggers;

import com.wewash.services.dto.marketset.MarketSetMessage;
import com.wewash.services.model.MessageType;
import org.springframework.stereotype.Service;


@Service
public class MarketSetMessageLogger extends MessageLogger<MarketSetMessage> {

    @Override
    protected long getFixtureId(MarketSetMessage marketSetMessage) {
        return (long) marketSetMessage.getMarketSet().getFixtureId();
    }

    @Override
    Class<MarketSetMessage> getMessageClass() {
        return MarketSetMessage.class;
    }

    @Override
    MessageType getMessageType() {
        return MessageType.MARKETSET;
    }
}
