package com.wewash.services.infra.send;

import com.wewash.services.domain.ebet.dto.HeartBeatDTO;
import feign.Headers;
import feign.RequestLine;

public interface EventDataPubilsher {
    @RequestLine("POST /event-import/v1/heart-beat")
    @Headers("Content-Type: application/json")
    void pushHeartBeatForProvider(HeartBeatDTO heartBeat);
}
