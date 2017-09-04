package com.wewash.services.infra.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wewash.services.infra.send.EventDataPublisher;
import feign.Feign;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ClientConfig {

    @Bean
    public EventDataPublisher eventDataPublisher(SendConfiguration config) {
        ObjectMapper mapper = new ObjectMapper();

        return Feign.builder()
                .encoder(new JacksonEncoder(mapper))
                .decoder(new JacksonDecoder(mapper))
                .logger(new Slf4jLogger(EventDataPublisher.class))
                .logLevel(Logger.Level.FULL)
                .requestInterceptor(new BasicAuthRequestInterceptor(config.getUser(), config.getPassword()))
                .target(EventDataPublisher.class, config.getInfoServerUrl());
    }


}
