package com.sahaj.games.carrom.cleanstrike.entity;

import com.sahaj.games.carrom.cleanstrike.striketypes.Strike;

/**
 * Created by Aniruddha on 16-11-2018.
 */

public class Striker {

    public void setStrike(final Strike strike) {
        this.strike = strike;
    }

    private Strike strike;

    public Striker(final Strike strike) {
        this.strike = strike;
    }

    public Striker() {
    }

    public void hitCoin() {
        strike.execute();
    }

}
