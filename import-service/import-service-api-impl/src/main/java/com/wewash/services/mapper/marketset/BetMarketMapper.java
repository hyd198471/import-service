package com.wewash.services.mapper.marketset;

import com.wewash.services.dto.marketset.Market;
import com.wewash.services.dto.marketset.Selection;
import com.wewash.services.ebet.dto.betmarket.BetMarketDTO;
import com.wewash.services.ebet.dto.betmarket.OutcomeDTO;
import com.wewash.services.exception.BadImportMessageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class BetMarketMapper {
    @Autowired
    private BetMarketTypeMapper betMarketTypeMapper;

    @Autowired
    private OutcomeMapper outcomeMapper;

    @Autowired
    private BetMarketStatusMapper betMarketStatusMapper;

    public BetMarketDTO convertToEbetDTO(Market market) throws BadImportMessageException {

        BetMarketDTO betMarketDTO = new BetMarketDTO();
        betMarketDTO.setId(market.getId());
        betMarketDTO.setBetMarketType(betMarketTypeMapper.convertToEbetDTO(market.getMarketType()));

        int marketTypeId = market.getMarketType().getId();
        BetgeniusMarketType betgeniusMarketType = BetgeniusMarketType.getBetgeniusMarketTypeById(marketTypeId);
        betMarketDTO.setParameters(betgeniusMarketType.getBetMarketParam().convertToEbetParam(market));

        betMarketDTO.setOutcomes(convertSelections(market, marketTypeId));

        betMarketDTO.setBetMarketStatus(betMarketStatusMapper.convertToEbetDTO(market.getTradingStatus()));

        betMarketDTO.setExpiresAt(convertToDate(market.getExpiryUtc()));
        return betMarketDTO;
    }

    private List<OutcomeDTO> convertSelections(Market market, int marketTypeId) throws BadImportMessageException {
        List<OutcomeDTO> outcomes = new ArrayList<>();
        for (Selection selection : market.getSelections()) {
            outcomes.add(outcomeMapper.convertToEbetDTO(selection, marketTypeId));
        }
        return outcomes;
    }


    private Date convertToDate(OffsetDateTime startTime) {
        return Date.from(startTime.toInstant());
    }

}
