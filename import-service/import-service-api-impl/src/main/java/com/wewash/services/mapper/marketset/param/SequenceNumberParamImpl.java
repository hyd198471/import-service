package com.wewash.services.mapper.marketset.param;

import com.google.common.collect.Lists;
import com.wewash.services.dto.marketset.Market;

import java.util.List;

public class SequenceNumberParamImpl extends BetMarketParam implements MarketSequenceParam {
    @Override
    public List<String> convertToEbetParam(Market market) {
        return Lists.newArrayList(String.valueOf(market.getSequence() + 1));
    }
}
