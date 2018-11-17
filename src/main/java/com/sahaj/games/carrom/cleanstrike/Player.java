package com.sahaj.games.carrom.cleanstrike;

import java.util.Map;

/**
 * Created by Aniruddha on 16-11-2018.
 */
public class Player implements Subscriber {

    private final Striker striker;
    private int currentScore;
    private int NA = 0;
    private int consecutiveUnsuccessfulAttempts;
    private int previousUnsuccessfulAttempt;

    public Player(Striker striker) {
        this.striker = striker;
    }

    public void playStroke() {
        striker.hitCoin();
    }

    public int currentScore() {
        return this.currentScore;
    }

    @Override
    public void update(Strike strike) {
        final Map<String, Integer> currentStats = strike.updateCurrentStats(NA, NA, currentScore);
        this.currentScore = currentStats.get("currentScore");
        int currUnsuccessfulAttempt = currentStats.get("isAttemptUnsuccessful");
        if(previousUnsuccessfulAttempt > 1) {
            consecutiveUnsuccessfulAttempts = consecutiveUnsuccessfulAttempts + currUnsuccessfulAttempt;
        }
        else {
            previousUnsuccessfulAttempt = currUnsuccessfulAttempt;
        }
        if (consecutiveUnsuccessfulAttempts == 3) {
            consecutiveUnsuccessfulAttempts = 0;
            this.currentScore = this.currentScore - 1;
        }
    }
}
