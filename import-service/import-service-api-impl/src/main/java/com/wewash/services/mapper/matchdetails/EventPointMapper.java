package com.wewash.services.mapper.matchdetails;

import com.wewash.services.dto.matchdetails.MatchAction;
import com.wewash.services.ebet.dto.event.ParticipantDTO;
import com.wewash.services.ebet.dto.matchstate.EventPointDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventPointMapper {

    private final Map<String, Integer> eventPointTypeDelayMap = new HashMap<>();

    List<EventPointDTO> convertImportMatchActionToEbetEventPoints(MatchAction matchActions,
                                                                  String currentPhase,
                                                                  Date currentPhaseStartTime,
                                                                  List<ParticipantDTO> participants) {
        List<EventPointDTO> eventPoints = new ArrayList<>();

        return eventPoints;
    }


}
