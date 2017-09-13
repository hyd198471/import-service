package com.wewash.services.mapper.marketset;

import com.wewash.services.dto.marketset.MarketType;
import com.wewash.services.ebet.dto.betmarket.BetMarketTypeDTO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.wewash.services.ebet.dto.enums.EbetBetMarketType.*;
import static com.wewash.services.mapper.marketset.BetgeniusMarketType.*;

@Component
public class BetMarketTypeMapper {
    private static final Map<Integer, String> BG_MARKET_TYPE_TO_EBET = new HashMap<>();

    static {

        BG_MARKET_TYPE_TO_EBET.put(BG_MATCH_RESULT.getId(), STANDARD.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_GOALS_OVER_UNDER.getId(), POINTS_MORE_LESS_THAN.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_NEXT_TEAM_TO_SCORE.getId(), NEXT_POINT.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_HALF_TIME_NEXT_TEAM_TO_SCORE.getId(), NEXT_POINT_HALFTIME.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_HALF_TIME_RESULT.getId(), SECTION_WIN.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_REST_OF_FIRST_HALF_TOTAL_GOALS_OVER_UNDER.getId(),
                POINTS_MORE_LESS_REST_HALFTIME.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_REST_FIRST_HALF_RESULT.getId(), STANDARD_REST_HALFTIME.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_REST_MATCH_RESULT.getId(), STANDARD_REST.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_REST_MATCH_TOTAL_GOALS_OVER_UNDER.getId(), POINTS_MORE_LESS_REST.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_BOTH_TEAM_TO_SCORE.getId(), SCORE_BOTH.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_DOUBLE_CHANCE.getId(), DOUBLE_CHANCE.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_DRAW_NO_BET.getId(), HEAD_TO_HEAD.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_HANDICAP_WITH_TIE.getId(), HANDICAP.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_HOME_TEAM_CLEAN_SHEET.getId(), TEAM_SCORES.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_AWAY_TEAM_CLEAN_SHEET.getId(), TEAM_SCORES.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_ASIA_HANDICAP_HALFTIME.getId(), ASIAN_HANDICAP_HALFTIME.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_HANDICAP_WITH_TIE.getId(), HANDICAP.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_HOW_TIE_BE_DECIDED.getId(), TYPE_OF_ADVANCE.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_MATCH_RESULT_TOTAL_GOALS_OVER_UNDER.getId(),  TOTALS_TEAM_WINS.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_NEXT_CARDED_TEAM.getId(), NEXT_YELLOW_CARD.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_NEXT_CORNER_TEAM.getId(), NEXT_CORNER_KICK.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_NEXT_GOAL_TIME.getId(), POINT_MINUTE.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_ODD_EVEN_GOAL_TOTAL.getId(), ODD_EVEN.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_PLAYER_TO_SCORE_TWO_OR_MORE_GOALS.getId(), GOAL_SCORE_MIN_2.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_TEAM_WITH_MOST_BOOKING_POINTS.getId(), MORE_YELLOW_CARDS.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_TEAM_WITH_MOST_CORNERS.getId(), MORE_CORNER_KICKS.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_TO_WIN_THE_TROPHY.getId(), ASCENDENCY.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_TOTAL_BOOKING_POINTS_OVER_UNDER.getId(), YELLOW_CARDS_MORE_LESS_THAN.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_HOME_TEAM_TOTAL_GOALS_OVER_UNDER.getId(), TEAM_POINTS_MORE_LESS.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_AWAY_TEAM_TOTAL_GOALS_OVER_UNDER.getId(), TEAM_POINTS_MORE_LESS.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_CORRECT_SCORE_AAMS.getId(), CORRECT_SCORE_LIVE.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_TO_QUALIFY.getId(), ASCENDENCY.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_MATCH_RESULT_TOTAL_GOALS_OVER_UNDER.getId(), TOTALS_TEAM_WINS.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_HALF_TIME_FULL_TIME.getId(), HALFTIME_FULLTIME.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_CORRECT_SCORE_AAMS_HALFTIME.getId(), POINT_BET_HALFTIME.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_HOME_TEAM_TO_WIN_TO_NIL.getId(), TEAM_TO_WIN_TO_NIL.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_AWAY_TEAM_TO_WIN_TO_NIL.getId(), TEAM_TO_WIN_TO_NIL.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_HALFTIME_BOTH_TEAMS_TO_SCORE.getId(), SCORE_BOTH_HALFTIME.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_HALF_WITH_MOST_GOALS.getId(), MORE_HALFTIME_POINTS.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_CORNERS_HANDICAP_WITH_TIE.getId(), CORNER_KICK_HANDICAP.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_TOTAL_CORNERS_OVER_UNDER.getId(), CORNER_KICKS_MORE_LESS_THAN.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_TOTAL_CORNERS.getId(), NUMBER_OF_CORNER_KICKS.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_ODD_EVEN_GOAL_TOTAL.getId(), ODD_EVEN.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_HOW_TIE_BE_DECIDED.getId(), TYPE_OF_ADVANCE.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_NEXT_CARDED_TEAM.getId(), NEXT_YELLOW_CARD.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_TOTAL_GOALS_BANDS.getId(), NUMBER_OF_POINTS_2.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_HALF_TIME_DOUBLE_CHANCE.getId(), DOUBLE_CHANCE_FIRST_HALF.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_HOME_TEAM_TOTAL_GOALS_BANDS.getId(), TEAM_NUMBER_OF_POINTS.getId());

        BG_MARKET_TYPE_TO_EBET.put(BG_AWAY_TEAM_TOTAL_GOALS_BANDS.getId(), TEAM_NUMBER_OF_POINTS.getId());
    }

    public BetMarketTypeDTO convertToEbetDTO(MarketType marketType) {
        BetMarketTypeDTO betMarketTypeDTO = new BetMarketTypeDTO();
        betMarketTypeDTO.setId(marketType.getId());
        betMarketTypeDTO.setName(BG_MARKET_TYPE_TO_EBET.get(marketType.getId()));

        return betMarketTypeDTO;
    }
}
