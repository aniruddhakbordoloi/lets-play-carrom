package com.sahaj.games.carrom.cleanstrike;

import com.sahaj.games.carrom.cleanstrike.entity.CoinHolder;
import com.sahaj.games.carrom.cleanstrike.entity.Player;
import com.sahaj.games.carrom.cleanstrike.entity.Striker;
import com.sahaj.games.carrom.cleanstrike.striketypes.*;
import org.junit.Test;

import static com.sahaj.games.carrom.cleanstrike.TestHelper.*;
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
        final Striker striker = new Striker();
        final Player player = new Player(striker);
        assignSingleStrike(striker, player, coinHolder);
        player.playStroke();
        assertThat(pointsScoredBy(player), is(one));
    }

    @Test
    public void thatPlayerWinsTwoPointsForMultiStrike() {
        final int two = 2;
        final CoinHolder coinHolder = new CoinHolder();
        final Striker striker = new Striker();
        final Player player = new Player(striker);
        assignMultiStrikeToStriker(coinHolder, striker, player);
        player.playStroke();
        assertThat(pointsScoredBy(player), is(two));
    }

    @Test
    public void thatPlayerWinsThreePointsForRedStrike() {
        final int three = 3;
        final CoinHolder coinHolder = new CoinHolder();
        final Striker striker = new Striker();
        final Player player = new Player(striker);
        assignRedStrikeToStriker(coinHolder, striker, player);
        player.playStroke();
        assertThat(pointsScoredBy(player), is(three));
    }

    @Test
    public void thatPlayerLosesTwoPointsForDefunctStrike() {
        final CoinHolder coinHolder = new CoinHolder();
        final Striker striker = new Striker();
        final Player player = new Player(striker);
        assignDefunctStrikeToStriker(coinHolder, striker, player);
        player.playStroke();
        assertThat(pointsScoredBy(player), is(-2));
    }

    @Test
    public void thatPlayerLosesAPointForStrikerStrike() {
        final int negative = -1;
        final CoinHolder coinHolder = new CoinHolder();
        final Striker striker = new Striker();
        final Player player = new Player(striker);
        assignStrikerStrike(striker, player, coinHolder);
        player.playStroke();
        assertThat(pointsScoredBy(player), is(negative));
    }

    @Test
    public void thatThePlayerLosesAPointForThreeSuccessiveUnsuccessfulAttempts() {
        final CoinHolder coinHolder = new CoinHolder();
        final Striker striker = new Striker();
        final Player player = new Player(striker);
        assignNoStrikeToStriker(coinHolder, striker, player);
        player.playStroke();
        player.playStroke();
        player.playStroke();
        assertThat(pointsScoredBy(player), is(-1));
    }

    @Test
    public void thatThePlayerLosesAPointForThreeConsecutiveFouls() {//Each Striker strike reduces a point and 3 consecutive fouls further reduces another.
        final CoinHolder coinHolder = new CoinHolder();
        final Striker striker = new Striker();
        final Player player = new Player(striker);
        assignStrikerStrike(striker, player, coinHolder);
        player.playStroke();
        player.playStroke();
        player.playStroke();
        assertThat(pointsScoredBy(player), is(-4));
    }

    @Test
    public void thatAlternateFoulsAreNotConsideredConsecutive() {
        final CoinHolder coinHolder = new CoinHolder();
        final Striker striker = new Striker();
        final Player player = new Player(striker);
        assignFoulStrike(striker, player, coinHolder);
        player.playStroke();
        assignSingleStrike(striker, player, coinHolder);
        player.playStroke();
        assignFoulStrike(striker, player, coinHolder);
        player.playStroke();
        assignFoulStrike(striker, player, coinHolder);
        player.playStroke();
        assertThat(pointsScoredBy(player), is(-2));
    }

    private void assignFoulStrike(final Striker striker, final Player player, final CoinHolder coinHolder) {
        assignStrikerStrike(striker, player, coinHolder);
    }

    private int pointsScoredBy(Player player) {
        return player.currentScore();
    }
}
