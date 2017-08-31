package com.wewash.services.infra.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "send-configuration")
public class SendConfiguration {

    private String infoServerUrl;
    private String heartbeatUrl;
    private String integrationserviceUrl;
    private String eventImportUrl;
    private String marketImportUrl;
    private String matchStateImportUrl;
    private String user;
    private String password;
    private int connectionTimeout;

    public String getInfoServerUrl() {
        return infoServerUrl;
    }

    public void setInfoServerUrl(String infoServerUrl) {
        this.infoServerUrl = infoServerUrl;
    }

    public String getHeartbeatUrl() {
        return heartbeatUrl;
    }

    public void setHeartbeatUrl(String heartbeatUrl) {
        this.heartbeatUrl = heartbeatUrl;
    }

    public String getIntegrationserviceUrl() {
        return integrationserviceUrl;
    }

    public void setIntegrationserviceUrl(String integrationserviceUrl) {
        this.integrationserviceUrl = integrationserviceUrl;
    }

    public String getEventImportUrl() {
        return eventImportUrl;
    }

    public void setEventImportUrl(String eventImportUrl) {
        this.eventImportUrl = eventImportUrl;
    }

    public String getMarketImportUrl() {
        return marketImportUrl;
    }

    public void setMarketImportUrl(String marketImportUrl) {
        this.marketImportUrl = marketImportUrl;
    }

    public String getMatchStateImportUrl() {
        return matchStateImportUrl;
    }

    public void setMatchStateImportUrl(String matchStateImportUrl) {
        this.matchStateImportUrl = matchStateImportUrl;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public static class HttpPoolConfiguration {

        private int maxPoolSize;
        private int defaultMaxPerRoute;

        public int getMaxPoolSize() {
            return maxPoolSize;
        }

        public void setMaxPoolSize(int maxPoolSize) {
            this.maxPoolSize = maxPoolSize;
        }

        public int getDefaultMaxPerRoute() {
            return defaultMaxPerRoute;
        }

        public void setDefaultMaxPerRoute(int defaultMaxPerRoute) {
            this.defaultMaxPerRoute = defaultMaxPerRoute;
        }
    }
}
