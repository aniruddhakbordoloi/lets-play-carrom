package com.sahaj.games.carrom.cleanstrike.striketypes;

/**
 * Created by Aniruddha on 17-11-2018.
 */
public class SingleStrike extends Strike {


    @Override
    protected void deductCoinForTheStrikePlayed() {
        this.numberOfCoinsToDeduct = 1;
    }

    @Override
    protected void addOrDeductPointsFromPlayer() {
        this.pointsForPlayer = 1;
    }

    @Override
    protected int isAttemptUnsuccessful() {
        return 0;
    }
}
