package com.sahaj.games.carrom.cleanstrike;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Aniruddha on 16-11-2018.
 */
public class CoinHolderTest {

   private CoinHolder coinHolder = null;

   @Before
   public void setUp() {
       this.coinHolder = new CoinHolder();
   }

   @Test
   public void thatTheCoinHolderHasNineBlackCoins() {
       final int nine = 9;
       assertThat(blackCoinsInHolder(), is(nine));
   }

    private int blackCoinsInHolder() {
       return coinHolder.getBlackCoins();
    }

    @Test
    public void thatTheCoinHolderHasOneRedCoin() {
        final int one = 1;
        assertThat(redCoinsInHolder(), is(one));
    }

    private int redCoinsInHolder() {
        return coinHolder.getRedCoins();
    }

    @Test
    public void thatTheCoinHolderHasTenCoinsInTotal() {
        final int ten = 10;
        assertThat(totalCoinsInHolder(), is(10));
    }

    private int totalCoinsInHolder() {
        return coinHolder.getTotalCoins();
    }

    @Test
    public void thatTheCoinHolderHasEightBlackCoinsWhenAStrikeIsScored() {//1 coin reduced from total 9 black coins
        final int eight = 8;
        final Strike singleStrike = new SingleStrike();
        final Striker striker = new Striker(singleStrike);
        final Player player = new Player(striker);
        singleStrike.register(coinHolder);
        singleStrike.register(player);
        player.playStroke();
        assertThat(blackCoinsInHolder(), is(eight));
    }

    @Test
    public void thatTheCoinHolderHasSevenBlackCoinsWhenMultiStrikeIsScored() {
        final int seven = 7;
        final Strike multiStrike = new MultiStrike();
        final Striker striker = new Striker(multiStrike);
        final Player player = new Player(striker);
        multiStrike.register(coinHolder);
        multiStrike.register(player);
        player.playStroke();
        assertThat(blackCoinsInHolder(), is(seven));
    }

    @Test
    public void thatTheCoinHolderHasZeroRedCoinsWhenRedStrikeIsScored() {
        final int zero = 0;
        final Strike redStrike = new RedStrike();
        final Striker striker = new Striker(redStrike);
        final Player player = new Player(striker);
        redStrike.register(coinHolder);
        redStrike.register(player);
        player.playStroke();
        assertThat(redCoinsInHolder(), is(zero));
    }

    @Test
    public void thatTheCoinHolderHasTotalCoinsIntactWhenStrikerStrikeIsScored() {
        final int ten = 10;
        final Strike strikerStrike = new StrikerStrike();
        final Striker striker = new Striker(strikerStrike);
        final Player player = new Player(striker);
        strikerStrike.register(coinHolder);
        strikerStrike.register(player);
        player.playStroke();
        assertThat(totalCoinsInHolder(), is(ten));
    }

    @Test
    public void thatTheCoinHolderHasNineCoinsWhenDefunctStrike() {
        final int nine = 9;
        final Strike defunctStrike = new DefunctStrike();
        final Striker striker = new Striker(defunctStrike);
        final Player player = new Player(striker);
        defunctStrike.register(coinHolder);
        defunctStrike.register(player);
        player.playStroke();
        assertThat(totalCoinsInHolder(), is(nine));
    }
}
