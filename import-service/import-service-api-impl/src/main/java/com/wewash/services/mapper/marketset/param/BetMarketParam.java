package com.wewash.services.mapper.marketset.param;


import com.wewash.services.dto.marketset.Market;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public abstract class BetMarketParam {

    static final NumberFormat PARAM_FORMAT = new DecimalFormat("0.##", new DecimalFormatSymbols(Locale.ENGLISH));
    static final String AWAY_TEAM = "2";
    static final String HOME_TEAM = "1";

    public abstract List<String> convertToEbetParam(Market market);
}