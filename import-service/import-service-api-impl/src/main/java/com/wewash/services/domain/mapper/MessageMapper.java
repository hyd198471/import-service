package com.wewash.services.domain.mapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wewash.services.exception.PoisonMessageException;
import com.wewash.services.model.FixtureSnapshot;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UncheckedIOException;

@Service
public class MessageMapper {

    private static final ObjectMapper MAPPER = new ObjectMapper().findAndRegisterModules();

    static {
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public<T> T readValue(String message, Class<T> valueType) {
        try {
            return MAPPER.readValue(message, valueType);
        } catch (IOException e) {
            throw new PoisonMessageException(e.getMessage(), e);
        }
    }


    public <T> T readValue(FixtureSnapshot entity, Class<T> valueType) {
        return readValue(entity.getSnapshotJson(), valueType);
    }


}
