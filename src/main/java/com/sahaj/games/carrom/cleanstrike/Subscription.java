package com.sahaj.games.carrom.cleanstrike;

/**
 * Created by Aniruddha on 17-11-2018.
 */
public interface Subscription {
    void register(Subscriber subscriber);
    void notifySubscribers();
}
