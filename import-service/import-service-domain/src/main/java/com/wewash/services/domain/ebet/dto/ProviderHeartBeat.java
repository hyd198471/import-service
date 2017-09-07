package com.wewash.services.domain.ebet.dto;


import com.wewash.services.domain.ebet.dto.heartbeat.HeartBeatDTO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/v1/heart-beat")
@Produces("application/json")
@Consumes("application/json")
public interface ProviderHeartBeat {

    @POST
    Response heartBeat(HeartBeatDTO heartBeat);
}
