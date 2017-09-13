package com.wewash.services.ebet.dto.event;

import org.apache.commons.lang.builder.EqualsBuilder;

public class ConfigDTO {

    //This used to be the Config enum - but codehaus objectMapper complains about an empty enum, so String for now
    private String config;
    private String value;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ConfigDTO that = (ConfigDTO) o;

        return new EqualsBuilder()
                .append(config, that.config)
                .append(value, that.value)
                .isEquals();
    }

    @Override
    public int hashCode() {
        int result = config.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ConfigDTO{" +
                "config=" + config +
                ", value='" + value + '\'' +
                '}';
    }
}
