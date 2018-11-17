package com.sahaj.games.carrom.cleanstrike;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Aniruddha on 17-11-2018.
 */
public class PlayerTest {
    @Test
    public void thatPlayerWinsAPointForAStrike() {
        final int one = 1;
        final CoinHolder coinHolder = new CoinHolder();
        final Strike singleStrike = new SingleStrike();
        final Striker striker = new Striker(singleStrike);
        final Player player = new Player(striker);
        singleStrike.register(coinHolder);
        singleStrike.register(player);
        player.playStroke();
        assertThat(pointsScoredBy(player), is(one));
    }

    @Test
    public void thatPlayerWinsTwoPointsForMultiStrike() {
        final int two = 2;
        final CoinHolder coinHolder = new CoinHolder();
        final Strike multiStrike = new MultiStrike();
        final Striker striker = new Striker(multiStrike);
        final Player player = new Player(striker);
        multiStrike.register(coinHolder);
        multiStrike.register(player);
        player.playStroke();
        assertThat(pointsScoredBy(player), is(two));
    }

    @Test
    public void thatPlayerWinsThreePointsForRedStrike() {
        final int three = 3;
        final CoinHolder coinHolder = new CoinHolder();
        final Strike redStrike = new RedStrike();
        final Striker striker = new Striker(redStrike);
        final Player player = new Player(striker);
        redStrike.register(coinHolder);
        redStrike.register(player);
        player.playStroke();
        assertThat(pointsScoredBy(player), is(three));
    }

    @Test
    public void thatPlayerLosesAPointForStrikerStrike() {
        final int negative = -1;
        final CoinHolder coinHolder = new CoinHolder();
        final Strike strikerStrike = new StrikerStrike();
        final Striker striker = new Striker(strikerStrike);
        final Player player = new Player(striker);
        strikerStrike.register(coinHolder);
        strikerStrike.register(player);
        player.playStroke();
        assertThat(pointsScoredBy(player), is(negative));
    }

    @Test
    public void thatThePlayerLosesAPointForThreeSuccessiveUnsuccessfulAttempts() {
        final int negative = -1;
        final CoinHolder coinHolder = new CoinHolder();
        final Strike noStrike = new NoStrike();
        final Striker striker = new Striker(noStrike);
        final Player player = new Player(striker);
        noStrike.register(coinHolder);
        noStrike.register(player);
        player.playStroke();

    }

    private int pointsScoredBy(Player player) {
        return player.currentScore();
    }
}
