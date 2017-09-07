package com.wewash.services.domain.mapper;

import com.wewash.services.domain.ebet.dto.common.ProviderDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProviderMapper {
    @Value("${service.import-service.providerId}")
    private int providerId;
    @Value("${service.import-service.providerName}")
    private String providerName;

    public ProviderDTO getProvider() {
        ProviderDTO providerDTO = new ProviderDTO();
        providerDTO.setId(providerId);
        providerDTO.setName(providerName);
        return providerDTO;
    }
}
