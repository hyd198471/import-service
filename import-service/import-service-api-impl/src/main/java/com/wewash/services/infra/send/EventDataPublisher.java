package com.wewash.services.infra.send;

import com.wewash.services.domain.ebet.dto.HeartBeatDTO;
import feign.Headers;
import feign.RequestLine;
import feign.Response;

public interface EventDataPublisher {
    @RequestLine("POST /event-import/v1/heart-beat")
    @Headers("Content-Type: application/json")
    void pushHeartBeatForProvider(HeartBeatDTO heartBeat);

    @RequestLine("POST /event-import/v1/snapshots")
    @Headers("Content-Type: application/vnd.tipico.events-v1+json")
    Response pushSnapshotToEbet(String snapshotJson);
}
