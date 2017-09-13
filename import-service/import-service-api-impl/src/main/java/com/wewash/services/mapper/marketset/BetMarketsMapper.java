package com.wewash.services.mapper.marketset;

import com.wewash.services.dto.marketset.Market;
import com.wewash.services.dto.marketset.MarketSetMessage;
import com.wewash.services.ebet.dto.betmarket.BetMarketDTO;
import com.wewash.services.exception.BadImportMessageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BetMarketsMapper {

    private static final Logger LOG = LoggerFactory.getLogger(BetMarketsMapper.class);

    @Autowired
    private BetMarketMapper betMarketMapper;

    public List<BetMarketDTO> convertToEbetDTO(MarketSetMessage message) throws BadImportMessageException {
        List<BetMarketDTO> betMarkets = new ArrayList<>();
        for (Market market: message.getMarketSet().getMarkets() ) {
            try {
                betMarkets.add(betMarketMapper.convertToEbetDTO(market));
            } catch (UnknownBetMarketTypeException e) {
                LOG.warn("Unknown bet market type - {}", e.getMessage());
                LOG.trace("Unknown bet market type", e);
            }
        }
        return betMarkets;
    }
}
