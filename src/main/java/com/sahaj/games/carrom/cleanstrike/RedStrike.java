package com.sahaj.games.carrom.cleanstrike;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    /*final List<Subscriber> subscribers = new ArrayList<>();
    private int pointsScored;
    private int redCoinsToDeduct;

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
        addPointsForThePlayer();
        deductRedCoinFromHolder();
        notifySubscribers();
    }

    private void deductRedCoinFromHolder() {
        this.redCoinsToDeduct = 1;
    }

    private void addPointsForThePlayer() {
        this.pointsScored = 3;
    }

    @Override
    public Map<String, Integer> updateCurrentStats(int blackCoins, int redCoins, int currentScore) {
        final Map<String, Integer> currentStats = new HashMap<>();
        currentStats.put("blackCoins", blackCoins);
        currentStats.put("redCoins", redCoins - redCoinsToDeduct);
        currentStats.put("currentScore", currentScore + pointsScored);
        return currentStats;
    }*/
}
