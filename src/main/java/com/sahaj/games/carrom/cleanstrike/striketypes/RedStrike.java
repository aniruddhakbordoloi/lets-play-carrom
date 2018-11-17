package com.sahaj.games.carrom.cleanstrike.striketypes;

/**
 * Created by Aniruddha on 17-11-2018.
 */
public class RedStrike extends Strike {

    @Override
    protected void deductCoinForTheStrikePlayed() {
        this.numberOfRedCoinsToDeduct = 1;
    }

    @Override
    protected void addOrDeductPointsFromPlayer() {
        this.pointsForPlayer = 3;
    }

    @Override
    protected int isAttemptUnsuccessful() {
        return 0;
    }
}
