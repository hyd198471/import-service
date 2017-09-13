package com.wewash.services.domain.mapper.fixture;


import com.wewash.services.domain.ebet.dto.enums.Sport;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.wewash.services.domain.ebet.dto.enums.Sport.FOOTBALL;


@Component
public class SportMapper {

    public static final int BG_FOOTBALL = 10;

    private static final Map<Integer, Sport> BG_ID_TO_PROVIDER_API_ID = new HashMap<>();


    static {
        BG_ID_TO_PROVIDER_API_ID.put(BG_FOOTBALL, FOOTBALL);
    }


     Sport getSport(int sportId) {
        return BG_ID_TO_PROVIDER_API_ID.get(sportId);
    }

}
