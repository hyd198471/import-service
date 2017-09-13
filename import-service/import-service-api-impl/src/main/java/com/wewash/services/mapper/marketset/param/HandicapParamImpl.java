package com.wewash.services.mapper.marketset.param;

import com.google.common.collect.Lists;
import com.wewash.services.dto.marketset.Market;

import java.util.List;

public class HandicapParamImpl extends BetMarketParam {

    private static final String ZERO = "0";

    @Override
    public List<String> convertToEbetParam(Market market) {
        List<String> params = Lists.newArrayList();
        double handicap = market.getHandicap();
        if(handicap >= 0) {
            params.add(ZERO);
            params.add(PARAM_FORMAT.format(Math.abs(handicap)));
        } else {
            params.add(PARAM_FORMAT.format(Math.abs(handicap)));
            params.add(ZERO);
        }
        return params;
    }
}
