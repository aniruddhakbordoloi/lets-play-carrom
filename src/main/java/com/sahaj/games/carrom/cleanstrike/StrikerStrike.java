package com.sahaj.games.carrom.cleanstrike;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Aniruddha on 17-11-2018.
 */
public class StrikerStrike extends Strike {

    @Override
    protected void deductCoinForTheStrikePlayed() {
        this.numberOfCoinsToDeduct = 0;
    }

    @Override
    protected void addOrDeductPointsFromPlayer() {
        this.pointsForPlayer = -1;
    }

    @Override
    protected int isAttemptUnsuccessful() {
        return 1;
    }

    /*final List<Subscriber> subscribers = new ArrayList<>();
    private int scoreToDeduct;

    @Override
    public void register(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for(Subscriber subscriber : subscribers) {
            subscriber.update(this);
        }
    }

    @Override
    public void execute() {
        deductAScoreFromThePlayer();
        notifySubscribers();
    }

    private void deductAScoreFromThePlayer() {
        this.scoreToDeduct = 1;
    }

    @Override
    public Map<String, Integer> updateCurrentStats(int blackCoins, int redCoins, int currentScore) {
        final Map<String, Integer> currentStats = new HashMap<>();
        currentStats.put("blackCoins", blackCoins);
        currentStats.put("redCoins", redCoins);
        currentStats.put("currentScore", currentScore - scoreToDeduct);
        return currentStats;
    }*/
}
