package com.wewash.services.infra.send;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.INTERNAL_SERVER_ERROR )
public class DownstreamSystemException extends RuntimeException {
    public DownstreamSystemException(String message) {
        super(message);
    }
}
