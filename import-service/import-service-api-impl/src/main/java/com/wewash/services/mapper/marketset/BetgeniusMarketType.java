package com.wewash.services.mapper.marketset;


import com.wewash.services.mapper.marketset.param.AwayTeamOverUnderParamImpl;
import com.wewash.services.mapper.marketset.param.AwayTeamParamImpl;
import com.wewash.services.mapper.marketset.param.BetMarketParam;
import com.wewash.services.mapper.marketset.param.HandicapParamImpl;
import com.wewash.services.mapper.marketset.param.HomeTeamOverUnderParamImpl;
import com.wewash.services.mapper.marketset.param.HomeTeamParamImpl;
import com.wewash.services.mapper.marketset.param.MarketSequenceParam;
import com.wewash.services.mapper.marketset.param.NoParamImp;
import com.wewash.services.mapper.marketset.param.OverUnderParamImpl;
import com.wewash.services.mapper.marketset.param.RestMatchOverUnderParamImpl;
import com.wewash.services.mapper.marketset.param.SequenceNumberParamImpl;
import com.wewash.services.mapper.marketset.param.WhoWillGoThroughParamImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public enum BetgeniusMarketType {
    BG_AWAY_TEAM_CLEAN_SHEET(8481, HomeTeamParamImpl::new),
    BG_HOME_TEAM_CLEAN_SHEET(8480, AwayTeamParamImpl::new),
    BG_TOTAL_CORNERS(20, NoParamImp::new),
    BG_TOTAL_BOOKING_POINTS_OVER_UNDER(7793, NoParamImp::new),
    BG_TO_WIN_THE_TROPHY(11073, NoParamImp::new),
    BG_TEAM_WITH_MOST_BOOKING_POINTS(7783, NoParamImp::new),
    BG_PLAYER_TO_SCORE_TWO_OR_MORE_GOALS(7121, NoParamImp::new),
    BG_ODD_EVEN_GOAL_TOTAL(7354, NoParamImp::new),
    BG_NEXT_GOAL_TIME(8682, NoParamImp::new),
    BG_NEXT_CARDED_TEAM(7108, SequenceNumberParamImpl::new),
    BG_MATCH_RESULT_TOTAL_GOALS_OVER_UNDER(8239, OverUnderParamImpl::new),
    BG_HOW_TIE_BE_DECIDED(6497, WhoWillGoThroughParamImpl::new),
    BG_HANDICAP_WITH_TIE(105, HandicapParamImpl::new),
    BG_ASIA_HANDICAP_HALFTIME(7871, NoParamImp::new),
    BG_HALF_TIME_FULL_TIME(3, NoParamImp::new),
    BG_DRAW_NO_BET(122, NoParamImp::new),
    BG_DOUBLE_CHANCE(7202, NoParamImp::new),
    BG_BOTH_TEAM_TO_SCORE(7079, NoParamImp::new),
    BG_AWAY_TEAM_TOTAL_GOALS_OVER_UNDER(9497, AwayTeamOverUnderParamImpl::new),
    BG_HOME_TEAM_TOTAL_GOALS_OVER_UNDER(9498, HomeTeamOverUnderParamImpl::new),
    BG_REST_MATCH_TOTAL_GOALS_OVER_UNDER(11544, RestMatchOverUnderParamImpl::new),
    BG_REST_MATCH_RESULT(8710, SequenceNumberParamImpl::new),
    BG_REST_FIRST_HALF_RESULT(30, SequenceNumberParamImpl::new),
    BG_HALF_TIME_NEXT_TEAM_TO_SCORE(11044, SequenceNumberParamImpl::new),
    BG_NEXT_TEAM_TO_SCORE(7105, SequenceNumberParamImpl::new),
    BG_REST_OF_FIRST_HALF_TOTAL_GOALS_OVER_UNDER(12931, RestMatchOverUnderParamImpl::new),
    BG_HALF_TIME_RESULT(6832, HomeTeamParamImpl::new),
    BG_GOALS_OVER_UNDER(259, OverUnderParamImpl::new),
    BG_MATCH_RESULT(2, NoParamImp::new),
    BG_TO_QUALIFY(10546, WhoWillGoThroughParamImpl::new),
    BG_CORRECT_SCORE_AAMS(12509, NoParamImp::new),
    BG_CORRECT_SCORE_AAMS_HALFTIME(12508, SequenceNumberParamImpl::new),
    BG_HOME_TEAM_TO_WIN_TO_NIL(8863, HomeTeamParamImpl::new),
    BG_AWAY_TEAM_TO_WIN_TO_NIL(8864, AwayTeamParamImpl::new),
    BG_HALFTIME_BOTH_TEAMS_TO_SCORE(10459, SequenceNumberParamImpl::new),
    BG_HALF_WITH_MOST_GOALS(25, NoParamImp::new),
    BG_TOTAL_GOALS_BANDS(253, NoParamImp::new),
    BG_HALF_TIME_DOUBLE_CHANCE(7769, NoParamImp::new),
    BG_AWAY_TEAM_TOTAL_GOALS_BANDS(7087, AwayTeamParamImpl::new),
    BG_HOME_TEAM_TOTAL_GOALS_BANDS(7086, HomeTeamParamImpl::new),
    BG_CORNERS_HANDICAP_WITH_TIE(6631, HandicapParamImpl::new),
    BG_NEXT_CORNER_TEAM(7106, SequenceNumberParamImpl::new),
    BG_TOTAL_CORNERS_OVER_UNDER(7478, OverUnderParamImpl::new),
    BG_TEAM_WITH_MOST_CORNERS(297, NoParamImp::new);

    private int marketTypeId;
    private transient Supplier<BetMarketParam> factory;
    private static Map<Integer, BetgeniusMarketType> idMap = new HashMap<>();

    static {
        for (BetgeniusMarketType marketType : BetgeniusMarketType.values()) {
            idMap.put(marketType.getId(), marketType);
        }
    }

    BetgeniusMarketType(int marketTypeId, Supplier<BetMarketParam> factory) {
        this.marketTypeId = marketTypeId;
        this.factory = factory;
    }

    public BetMarketParam getBetMarketParam() {
        return factory.get();
    }

    public int getId() {
        return marketTypeId;
    }

    public static BetgeniusMarketType getBetgeniusMarketTypeById(int marketTypeId) {
        if(idMap.containsKey(marketTypeId)) {
            return idMap.get(marketTypeId);
        }
        throw new UnknownBetMarketTypeException(String.format("Unknown market type id [%d]", marketTypeId));
    }

    public static boolean hasSequenceParameter(int marketTypeId) {
        return getBetgeniusMarketTypeById(marketTypeId).getBetMarketParam() instanceof MarketSequenceParam;
    }
}
