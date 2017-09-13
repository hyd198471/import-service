package com.wewash.services.mapper.marketset.param;

import com.google.common.collect.Lists;
import com.wewash.services.dto.marketset.Market;

import java.util.List;

public class WhoWillGoThroughParamImpl extends BetMarketParam {
    private static final String WHO_WILL_GO_THROUGH = "-2";
    @Override
    public List<String> convertToEbetParam(Market market) {
        return Lists.newArrayList(WHO_WILL_GO_THROUGH);
    }
}
