package com.sahaj.games.carrom.cleanstrike.entity;

import com.sahaj.games.carrom.cleanstrike.Subscriber;
import com.sahaj.games.carrom.cleanstrike.striketypes.Strike;

import java.util.Map;

/**
 * Created by Aniruddha on 16-11-2018.
 */
public class CoinHolder implements Subscriber {

    private int blackCoins = 9;
    private int redCoins = 1;
    private int NA = 0;

    public int getTotalCoins() {
        return blackCoins + redCoins;
    }

    public int getBlackCoins() {
        return blackCoins;
    }

    public int getRedCoins() {
        return redCoins;
    }

    @Override
    public void update(Strike strike) {
        final Map<String, Integer> currentStats = strike.updateStatsPerStrike(blackCoins, redCoins, NA);
        this.blackCoins = currentStats.get("blackCoins");
        this.redCoins = currentStats.get("redCoins");
    }
}
