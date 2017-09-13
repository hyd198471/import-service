package com.wewash.services.view;

import com.wewash.services.ebet.dto.common.ProviderDTO;
import com.wewash.services.ebet.dto.heartbeat.HeartBeatDTO;
import com.wewash.services.infra.send.EventDataPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(HeartbeatController.HEARTBEAT_ENDPOINT)
public class HeartbeatController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HeartbeatController.class);

    static final String HEARTBEAT_ENDPOINT = "/v1/import-service/heartbeat";

    private final EventDataPublisher eventDataPublisher;

    private final int providerId;

    private final String providerName;

    private final boolean forwardMessageEnabled;

    @Autowired
    public HeartbeatController(EventDataPublisher eventDataPublisher,
                               @Value("${service.import-service.providerId}") int providerId,
                               @Value("${service.import-service.providerName}") String providerName,
                               @Value("${service.import-service.heartbeatForwardEnabled}")
                                           boolean forwardMessageEnabled) {
        this.eventDataPublisher = eventDataPublisher;
        this.providerId = providerId;
        this.providerName = providerName;
        this.forwardMessageEnabled = forwardMessageEnabled;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity forwardHeartbeat() {
        LOGGER.debug("POST to {} received", HEARTBEAT_ENDPOINT);

        if(forwardMessageEnabled) {
            eventDataPublisher.pushHeartBeatForProvider(createHeartBeat(new Date()));
        }
        return ResponseEntity.ok().build();
    }

    private HeartBeatDTO createHeartBeat(Date when) {
        HeartBeatDTO heartBeatDTO = new HeartBeatDTO();

        heartBeatDTO.setMessageTime(when);
        ProviderDTO provider = new ProviderDTO();
        provider.setId(providerId);
        provider.setName(providerName);
        heartBeatDTO.setProvider(provider);

        return heartBeatDTO;
    }

}
