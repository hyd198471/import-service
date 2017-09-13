package com.wewash.services.processors;

import com.wewash.services.ebet.dto.event.EventDTO;
import org.springframework.stereotype.Component;

@Component
public class SnapshotValidator {
    public boolean isValid(EventDTO eventDTO) {
        return eventDTO.getId() > 0
                && eventDTO.getMessageHeader() !=null
                && eventDTO.getSport() !=null
                && eventDTO.getStartsAt() != null
                && eventDTO.getParticipants() != null
                && !eventDTO.getParticipants().isEmpty()
                && eventDTO.getParticipants().size() == 2;
    }
}
