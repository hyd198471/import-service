package com.wewash.services.ebet.dto.common;

import org.apache.commons.lang.builder.EqualsBuilder;

import java.util.Date;

public class MessageHeaderDTO {
    private ProviderDTO provider;
    private Date messageTime;

    public ProviderDTO getProvider() {
        return provider;
    }

    public void setProvider(ProviderDTO provider) {
        this.provider = provider;
    }

    @SuppressWarnings("squid:S2384")
    public Date getMessageTime() {
        return messageTime;
    }

    @SuppressWarnings("squid:S2384")
    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !this.getClass().equals(o.getClass())) {
            return false;
        }

        MessageHeaderDTO other = (MessageHeaderDTO) o;

        return new EqualsBuilder()
                .append(provider, other.provider)
                .append(messageTime, other.messageTime)
                .isEquals();

    }

    @Override
    public int hashCode() {
        int result = provider.hashCode();
        result = 31 * result + messageTime.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "MessageHeaderDTO{" +
                "provider=" + provider +
                ", messageTime=" + messageTime +
                '}';
    }
}
