package com.wewash.services.mapper.marketset;

import com.wewash.services.ebet.dto.enums.BetMarketStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BetMarketStatusMapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(BetMarketStatusMapper.class);

    public BetMarketStatus convertToEbetDTO(String tradingStatus) {
        if ("Open".equalsIgnoreCase(tradingStatus)) {
            return BetMarketStatus.OPEN;
        } else if ("Suspended".equalsIgnoreCase(tradingStatus)
                || ("Closed".equalsIgnoreCase(tradingStatus))) {
            return BetMarketStatus.BLOCKED;
        }

        LOGGER.error("Unknown trading status from betgenius: {}", tradingStatus);
        return BetMarketStatus.BLOCKED;
    }
}
