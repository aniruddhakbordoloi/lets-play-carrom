package com.sahaj.games.carrom.cleanstrike.entity;

/**
 * Created by Aniruddha on 18-11-2018.
 */
public class Printer implements IPrinter {

    @Override
    public void printStats(final String stats) {
        System.out.println(stats);
    }
}
