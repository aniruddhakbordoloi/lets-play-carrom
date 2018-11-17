package com.sahaj.games.carrom.cleanstrike.striketypes;

/**
 * Created by Aniruddha on 17-11-2018.
 */
public class NoStrike extends Strike {

    @Override
    protected void deductCoinForTheStrikePlayed() {

    }

    @Override
    protected void addOrDeductPointsFromPlayer() {

    }

    @Override
    protected int isAttemptUnsuccessful() {
        return 1;
    }
}
