package com.wewash.services.messageloggers;

import com.wewash.services.dto.resultset.ResultSetMessage;
import com.wewash.services.model.MessageType;
import org.springframework.stereotype.Service;


@Service
public class ResultSetMessageLogger extends MessageLogger<ResultSetMessage> {

    @Override
    protected long getFixtureId(ResultSetMessage message) {
        return message.getResultSet().getFixtureId();
    }

    @Override
    Class<ResultSetMessage> getMessageClass() {
        return ResultSetMessage.class;
    }

    @Override
    MessageType getMessageType() {
        return MessageType.RESULTSET;
    }

}
