package com.wewash.services.mapper.marketset.param;

import com.google.common.collect.Lists;
import com.wewash.services.dto.marketset.Market;

import java.util.List;

public class HomeTeamOverUnderParamImpl extends BetMarketParam {
    @Override
    public List<String> convertToEbetParam(Market market) {
        List<String> params = Lists.newArrayList();
        params.add(HOME_TEAM);
        params.add(PARAM_FORMAT.format(Math.abs(market.getHandicap())));
        return params;
    }
}
