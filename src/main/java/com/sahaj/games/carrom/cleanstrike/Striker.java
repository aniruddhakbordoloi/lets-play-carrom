package com.sahaj.games.carrom.cleanstrike;

/**
 * Created by Aniruddha on 16-11-2018.
 */

public class Striker {

    private Strike strike;

    public Striker(Strike strike) {
        this.strike = strike;
    }

    public void hitCoin() {
        strike.execute();
    }
}
