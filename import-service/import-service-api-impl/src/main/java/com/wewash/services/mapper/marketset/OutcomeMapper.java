package com.wewash.services.mapper.marketset;

import com.wewash.services.dto.marketset.Outcome;
import com.wewash.services.dto.marketset.Range;
import com.wewash.services.dto.marketset.Selection;
import com.wewash.services.ebet.dto.betmarket.OutcomeDTO;
import com.wewash.services.ebet.dto.betmarket.RangeDTO;
import com.wewash.services.ebet.dto.enums.OutcomeStatus;
import com.wewash.services.exception.BadImportMessageException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static com.wewash.services.ebet.dto.enums.EbetOutcomeType.*;
import static com.wewash.services.mapper.marketset.BetgeniusMarketType.BG_AWAY_TEAM_CLEAN_SHEET;
import static com.wewash.services.mapper.marketset.BetgeniusMarketType.BG_HOME_TEAM_CLEAN_SHEET;
import static com.wewash.services.mapper.marketset.BetgeniusOutcomeType.*;

@Component
public class OutcomeMapper {
    private static final Map<Integer, String> OUTCOME_MAPPING = new HashMap<>();
    private static final Map<Integer, String> OUTCOME_MAPPING_SWAPPED = new HashMap<>();
    static final String TRADING = "Trading";

    static {
        initializeOutcomeNameMap();
        initializeOutcomeNameSwappedMap();
    }

    private static void initializeOutcomeNameMap() {
        OUTCOME_MAPPING.put(BG_OUTCOME_YES.getId(), EBET_OUTCOME_YES.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_NO.getId(), EBET_OUTCOME_NO.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_ANY_OTHER.getId(), EBET_OUTCOME_ANY_OTHER.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_OVER.getId(), EBET_OUTCOME_OVER.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_UNDER.getId(), EBET_OUTCOME_UNDER.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_HOME.getId(), EBET_OUTCOME_HOME.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_DRAW.getId(), EBET_OUTCOME_DRAW.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_AWAY.getId(), EBET_OUTCOME_AWAY.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_SOCCER_NO_GOAL.getId(), EBET_OUTCOME_SOCCER_NO_GOAL.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_SOCCER_HOME_DRAW.getId(), EBET_OUTCOME_SOCCER_HOME_DRAW.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_SOCCER_HOME_AWAY.getId(), EBET_OUTCOME_SOCCER_HOME_AWAY.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_SOCCER_AWAY_DRAW.getId(), EBET_OUTCOME_SOCCER_AWAY_DRAW.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_HANDICAP_HOME.getId(), EBET_OUTCOME_HOME.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_SOCCER_HANDICAP_DRAW.getId(), EBET_OUTCOME_DRAW.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_HANDICAP_AWAY.getId(), EBET_OUTCOME_AWAY.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_SOCCER_HOME_OVER.getId(), EBET_OUTCOME_SOCCER_HOME_OVER.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_SOCCER_HOME_UNDER.getId(), EBET_OUTCOME_SOCCER_HOME_UNDER.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_SOCCER_AWAY_OVER.getId(), EBET_OUTCOME_SOCCER_AWAY_OVER.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_SOCCER_AWAY_UNDER.getId(), EBET_OUTCOME_SOCCER_AWAY_UNDER.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_SOCCER_DRAW_OVER.getId(), EBET_OUTCOME_SOCCER_DRAW_OVER.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_SOCCER_DRAW_UNDER.getId(), EBET_OUTCOME_SOCCER_DRAW_UNDER.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_NO_RELATED_EVENT_POINT.getId(), EBET_OUTCOME_DRAW.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_SOCCER_HOME_HOME_FULL_HALFTIME.getId(),
                EBET_OUTCOME_SOCCER_HOME_HOME_FULL_HALFTIME.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_SOCCER_HOME_DRAW_FULL_HALFTIME.getId(),
                EBET_OUTCOME_SOCCER_HOME_DRAW_FULL_HALFTIME.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_SOCCER_HOME_AWAY_FULL_HALFTIME.getId(),
                EBET_OUTCOME_SOCCER_HOME_AWAY_FULL_HALFTIME.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_SOCCER_DRAW_HOME_FULL_HALFTIME.getId(),
                EBET_OUTCOME_SOCCER_DRAW_HOME_FULL_HALFTIME.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_SOCCER_DRAW_DRAW_FULL_HALFTIME.getId(),
                EBET_OUTCOME_SOCCER_DRAW_DRAW_FULL_HALFTIME.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_SOCCER_DRAW_AWAY_FULL_HALFTIME.getId(),
                EBET_OUTCOME_SOCCER_DRAW_AWAY_FULL_HALFTIME.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_SOCCER_AWAY_HOME_FULL_HALFTIME.getId(),
                EBET_OUTCOME_SOCCER_AWAY_HOME_FULL_HALFTIME.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_SOCCER_AWAY_DRAW_FULL_HALFTIME.getId(),
                EBET_OUTCOME_SOCCER_AWAY_DRAW_FULL_HALFTIME.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_SOCCER_AWAY_AWAY_FULL_HALFTIME.getId(),
                EBET_OUTCOME_SOCCER_AWAY_AWAY_FULL_HALFTIME.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_SOCCER_DRAW_HALF.getId(), EBET_OUTCOME_DRAW_HALF.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_SOCCER_FIRST_HALF.getId(), EBET_OUTCOME_FIRST_HALF.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_SOCCER_SECOND_HALF.getId(), EBET_OUTCOME_SECOND_HALF.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_SOCCER_EVEN.getId(), EBET_OUTCOME_SOCCER_EVEN.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_SOCCER_ODD.getId(), EBET_OUTCOME_SOCCER_ODD.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_NO_CARD.getId(), EBET_OUTCOME_DRAW.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_REGULAR_HOME.getId(), EBET_OUTCOME_REGULAR_HOME.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_REGULAR_AWAY.getId(), EBET_OUTCOME_REGULAR_AWAY.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_OVERTIME_HOME.getId(), EBET_OUTCOME_OVERTIME_HOME.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_OVERTIME_AWAY.getId(), EBET_OUTCOME_OVERTIME_AWAY.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_PENALTIES_HOME.getId(), EBET_OUTCOME_PENALTIES_HOME.getId());
        OUTCOME_MAPPING.put(BG_OUTCOME_PENALTIES_AWAY.getId(), EBET_OUTCOME_PENALTIES_AWAY.getId());
    }

    private static void initializeOutcomeNameSwappedMap() {

        OUTCOME_MAPPING_SWAPPED.put(BG_OUTCOME_YES.getId(), EBET_OUTCOME_NO.getId());

        OUTCOME_MAPPING_SWAPPED.put(BG_OUTCOME_NO.getId(), EBET_OUTCOME_YES.getId());

    }

    public OutcomeDTO convertToEbetDTO(Selection selection, int marketTypeId) throws BadImportMessageException {
        OutcomeDTO outcomeDTO = new OutcomeDTO();
        outcomeDTO.setId(selection.getId());

        mapTradingInformation(selection, outcomeDTO);
        mapChoiceParameters(selection, marketTypeId, outcomeDTO);

        outcomeDTO.setStatus(OutcomeStatus.ONGOING);
        return outcomeDTO;
    }

    private void mapTradingInformation(Selection selection, OutcomeDTO outcomeDTO) {
        outcomeDTO.setOdds(BigDecimal.valueOf(selection.getDecimal()));
        outcomeDTO.setTraded(isOutcomeTradable(selection));
    }

    private boolean isOutcomeTradable(Selection selection) {
        return TRADING.equalsIgnoreCase(selection.getTradingStatus());
    }

    private void mapChoiceParameters(Selection selection, int marketTypeId, OutcomeDTO outcomeDTO) {
        Outcome outcome = selection.getOutcome();
        Range range = selection.getRange();
        if (outcome != null) {
            outcomeDTO.setName(getNameFromOutcome(outcome.getId(), marketTypeId));
        } else if (range != null) {
            mapRange(outcomeDTO, range);
        }
    }

    private String getNameFromOutcome(int betgeniusOutcomeId, int betgeniusMarketTypeId) {
        if (betgeniusMarketTypeId == BG_AWAY_TEAM_CLEAN_SHEET.getId()
                || betgeniusMarketTypeId == BG_HOME_TEAM_CLEAN_SHEET.getId()) {
            return OUTCOME_MAPPING_SWAPPED.get(betgeniusOutcomeId);
        } else {
            return OUTCOME_MAPPING.get(betgeniusOutcomeId);
        }
    }

    private void mapRange(OutcomeDTO outcomeDTO, Range range) {
        RangeDTO rangeDTO = new RangeDTO();
        rangeDTO.setHighValue(range.getHigh());
        rangeDTO.setLowValue(range.getLow());
        outcomeDTO.setRange(rangeDTO);
    }
}
