package com.sahaj.games.carrom.cleanstrike;

import com.sahaj.games.carrom.cleanstrike.entity.Printer;

/**
 * Created by Aniruddha on 17-11-2018.
 */
public class PrinterMock implements Printer {

    private static String currentStatsStatement;

    @Override
    public void printStats(final String string) {
        currentStatsStatement = string;
    }

    public static String getPrintedStats() {
        return currentStatsStatement;
    }
}
