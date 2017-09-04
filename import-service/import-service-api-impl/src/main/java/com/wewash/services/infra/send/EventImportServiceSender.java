package com.wewash.services.infra.send;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class EventImportServiceSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventImportServiceSender.class);
    private static final String MEDIA_TYPE_JSON_V1 = "application/vnd.tipico.events-v1+json";

    @Autowired
    private CounterService counterService;

    @Autowired
    private EventDataPublisher eventDataPubilsher;

    @Autowired
    private Environment environment;

    @Value("${debug-options.publishing-enabled}")
    private boolean publishingEnabled;


    public void sendEvent(String jsonContent) {
        sendJson(environment.getRequiredProperty("send-configuration.event-import-url"), jsonContent);
    }

    private void sendJson(String url, String jsonContent) {
        if(!publishingEnabled) {
            LOGGER.trace("Publishing disabled - would have sent JSON object to {}: {}", url, jsonContent);
            return;
        }
        LOGGER.debug("sendJson JSON to {}", url);
        feign.Response response1 = eventDataPubilsher.pushSnapshotToEbet(jsonContent);
      /*  Response response = sendClient.target(url).request().post(Entity.entity(jsonContent, MEDIA_TYPE_JSON_V1));
        int status = response.getStatus();
        LOGGER.debug("sendJson: Response status = {}", status);
        String responseBody = response.readEntity(String.class);

        if (!response.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
            if(!StringUtils.isEmpty(responseBody)) {
                LOGGER.error(responseBody);
            }
            counterService.increment("snapshots.publishing.unsuccessful");
            if(response.getStatusInfo().getFamily().equals(Response.Status.Family.CLIENT_ERROR)) {
                throw new InvalidMessageException(responseBody);
            }
            throw new DownstreamSystemException(response.getStatusInfo().getReasonPhrase());
        }
        counterService.increment("snapshots.publishing.successful");*/
    }

}
