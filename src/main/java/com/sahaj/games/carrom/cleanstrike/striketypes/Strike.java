package com.sahaj.games.carrom.cleanstrike.striketypes;

import com.sahaj.games.carrom.cleanstrike.Subscriber;
import com.sahaj.games.carrom.cleanstrike.Subscription;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Aniruddha on 16-11-2018.
 */
public abstract class Strike implements Subscription {

    final List<Subscriber> subscribers = new ArrayList<>();
    protected int pointsForPlayer;
    protected int numberOfCoinsToDeduct;
    protected int numberOfRedCoinsToDeduct;


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

    public void execute(){
        addOrDeductPointsFromPlayer();
        deductCoinForTheStrikePlayed();
        notifySubscribers();
    }

    protected abstract void deductCoinForTheStrikePlayed();

    protected abstract void addOrDeductPointsFromPlayer();

    public Map<String, Integer> updateStatsPerStrike(int blackCoins, int redCoins, int currentScore){
        final Map<String, Integer> currentStats = new HashMap<>();
        currentStats.put("blackCoins", blackCoins - this.numberOfCoinsToDeduct);
        currentStats.put("redCoins", redCoins - this.numberOfRedCoinsToDeduct);
        currentStats.put("currentScore", currentScore + this.pointsForPlayer);
        currentStats.put("isAttemptUnsuccessful", isAttemptUnsuccessful());
        return currentStats;
    }

    protected abstract int isAttemptUnsuccessful();
}
