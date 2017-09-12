package com.wewash.services.processors;


import com.wewash.services.model.IncomingMessage;
import com.wewash.services.model.MessageType;

import java.io.Serializable;
import java.util.Comparator;

import static com.wewash.services.model.MessageType.FIXTURE;


public class FixtureFirstMessageLogComparator implements Comparator<IncomingMessage>, Serializable {

    private static final long serialVersionUID = 1;

    private static final int NON_FIXTURE = 1;

    @Override
    public int compare(IncomingMessage message1, IncomingMessage message2) {
        MessageType message1Type = message1.getMessageType();
        MessageType message2Type = message2.getMessageType();

        if (FIXTURE == message1Type ^ FIXTURE == message2Type) {
            return (message1Type != null ? message1Type.ordinal() : NON_FIXTURE)
                 - (message2Type != null ? message2Type.ordinal() : NON_FIXTURE);
        }
        return message1.getIncomingMessageReceived().compareTo(message2.getIncomingMessageReceived());
    }
}
