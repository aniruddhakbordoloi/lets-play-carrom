package com.sahaj.games.carrom.cleanstrike;

import com.sahaj.games.carrom.cleanstrike.entity.CoinHolder;
import com.sahaj.games.carrom.cleanstrike.entity.Player;
import com.sahaj.games.carrom.cleanstrike.entity.Striker;
import com.sahaj.games.carrom.cleanstrike.striketypes.*;

/**
 * Created by Aniruddha on 19-11-2018.
 */
public class TestHelper {

    static void assignSingleStrike(final Striker striker, final Player player, final CoinHolder coinHolder) {
        final Strike singleStrike = new SingleStrike();
        singleStrike.register(player);
        singleStrike.register(coinHolder);
        striker.setStrike(singleStrike);
    }

    static void assignStrikerStrike(final Striker striker, final Player player, final CoinHolder coinHolder) {
        final Strike strikerStrike = new StrikerStrike();
        strikerStrike.register(player);
        strikerStrike.register(coinHolder);
        striker.setStrike(strikerStrike);
    }

    static void assignNoStrikeToStriker(CoinHolder coinHolder, Striker striker, Player player) {
        final Strike noStrike = new NoStrike();
        noStrike.register(coinHolder);
        noStrike.register(player);
        striker.setStrike(noStrike);
    }

    static void assignRedStrikeToStriker(CoinHolder coinHolder, Striker striker, Player player) {
        final Strike redStrike = new RedStrike();
        striker.setStrike(redStrike);
        redStrike.register(coinHolder);
        redStrike.register(player);
    }

    static void assignMultiStrikeToStriker(CoinHolder coinHolder, Striker striker, Player player) {
        final Strike multiStrike = new MultiStrike();
        striker.setStrike(multiStrike);
        multiStrike.register(coinHolder);
        multiStrike.register(player);
    }
}
