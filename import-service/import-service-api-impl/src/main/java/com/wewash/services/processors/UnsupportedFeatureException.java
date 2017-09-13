package com.wewash.services.processors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.NOT_IMPLEMENTED )
public class UnsupportedFeatureException extends RuntimeException {
    public UnsupportedFeatureException(String errorMessage) {
        super(errorMessage);
    }
}
