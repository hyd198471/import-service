package com.wewash.services.domain.ebet.dto.matchstate;

public enum MatchState {
    PREMATCH(0), POST_MATCH(100), GAME_ABANDONED(101);

    private int value;

    MatchState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
