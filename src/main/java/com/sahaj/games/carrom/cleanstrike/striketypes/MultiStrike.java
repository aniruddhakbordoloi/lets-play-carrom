package com.sahaj.games.carrom.cleanstrike.striketypes;

/**
 * Created by Aniruddha on 17-11-2018.
 */
public class MultiStrike extends Strike {

    @Override
    protected void deductCoinForTheStrikePlayed() {
        this.numberOfCoinsToDeduct = 2;
    }

    @Override
    protected void addOrDeductPointsFromPlayer() {
        this.pointsForPlayer = 2;
    }

    @Override
    protected int isAttemptUnsuccessful() {
        return 0;
    }
}
