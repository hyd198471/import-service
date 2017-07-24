package com.wewash.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadImportMessageException extends RuntimeException {
    public BadImportMessageException(String msg) {
        super(msg);
    }

    public BadImportMessageException(String message, Throwable cause) {
        super(message, cause);
    }

}
