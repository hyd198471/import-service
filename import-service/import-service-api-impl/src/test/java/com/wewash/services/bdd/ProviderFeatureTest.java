package com.wewash.services.bdd;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.io.FileUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.wewash.services.ImportServiceApplication;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Map;


@ContextConfiguration
@SpringBootTest(
        classes = ImportServiceApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public abstract class ProviderFeatureTest {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final TypeReference<Map<String,Object>> MAP_TYPE_REFERENCE = new TypeReference<Map<String,Object>>(){};

    static {
        MAPPER.configure(SerializationFeature.INDENT_OUTPUT, true);
        MAPPER.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
    }

    protected <T> T readValue(InputStream stream, Class<T> clazz) {
        try {
            return MAPPER.readValue(stream, clazz);
        } catch (IOException e) {
           throw new UncheckedIOException(e);
        }
    }

    protected Map<String,Object> readValueFromClasspathAsMap(String classpath) {
        return readValueAsMap(classpath);
    }

    protected Map<String, Object> readValueAsMap(InputStream stream) {
        try {
            return MAPPER.readValue(stream, MAP_TYPE_REFERENCE);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    protected Map<String, Object> readValueAsMap(String message) {
        try {
            return MAPPER.readValue(message,MAP_TYPE_REFERENCE);
        }catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    protected String writeValueAsString(Object object) {
        try {
            return MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new UncheckedIOException(e);
        }
    }

    protected void writeValueToFile(String destination, Object object) throws IOException {
        File destinationFile = new File(destination);
        FileUtils.forceMkdirParent(destinationFile);
        MAPPER.writeValue(destinationFile, object);
    }

}
