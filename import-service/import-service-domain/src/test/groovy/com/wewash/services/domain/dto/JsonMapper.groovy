package com.wewash.services.domain.dto

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import org.apache.commons.io.IOUtils

import java.nio.charset.StandardCharsets

class JsonMapper {

    private static final ObjectMapper MAPPER = new ObjectMapper()

    static {
        MAPPER.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true)
        MAPPER.configure(SerializationFeature.INDENT_OUTPUT, true)
        MAPPER.findAndRegisterModules()
    }

    static String readFile(String resource, Class<?> callingClass) {
        return IOUtils.toString(callingClass.getResourceAsStream(resource), StandardCharsets.UTF_8)
    }

    static Object readFromClassPath(Class<?> callingClass, String resource, Class<?> objectClass) {
        return MAPPER.readValue(callingClass.getResourceAsStream(resource), objectClass)
    }


    static <T> T mapString(String json, Class<T> objectClass) {
        return MAPPER.readValue(json, objectClass)
    }

    static String mapObject(Object object) throws IOException {
        return MAPPER.writeValueAsString(object)
    }
}
