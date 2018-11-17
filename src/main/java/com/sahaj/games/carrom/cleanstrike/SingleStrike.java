package com.sahaj.games.carrom.cleanstrike;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /*private int pointsScored = 0;
    private int numberOfCoinsToDeduct = 0;
    final List<Subscriber> subscribers = new ArrayList<>();

    @Override
    public void execute() {
        deductACoinFromBoard();
        addPointsToPlayer();
        notifySubscribers();
    }

    @Override
    public Map<String, Integer> updateCurrentStats(int blackCoins, int redCoins, int currentScore) {
        final Map<String, Integer> currentStats = new HashMap<>();
        blackCoins = blackCoins - numberOfCoinsToDeduct;
        currentScore = currentScore + pointsScored;
        currentStats.put("blackCoins", blackCoins);
        currentStats.put("redCoins", redCoins);
        currentStats.put("currentScore", currentScore);
        return currentStats;
    }

    private void deductACoinFromBoard() {
        this.numberOfCoinsToDeduct = 1;
    }

    private void addPointsToPlayer() {
        this.pointsScored = 1;
    }

    @Override
    public void register(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for(Subscriber subscriber : subscribers) {
            subscriber.update(this);
        }
    }*/
}
