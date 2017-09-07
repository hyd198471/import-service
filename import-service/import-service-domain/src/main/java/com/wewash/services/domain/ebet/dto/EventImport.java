package com.wewash.services.domain.ebet.dto;


import com.wewash.services.domain.ebet.dto.event.EventDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/v1/events")
@Produces("application/vnd.tipico.events-v1+json")
@Consumes("application/vnd.tipico.events-v1+json")
public interface EventImport {

    @POST
    Response importEvent(EventDTO event);

}
