package com.sahaj.games.carrom.cleanstrike;

import com.sahaj.games.carrom.cleanstrike.entity.CoinHolder;
import com.sahaj.games.carrom.cleanstrike.entity.Player;
import com.sahaj.games.carrom.cleanstrike.entity.Striker;
import com.sahaj.games.carrom.cleanstrike.striketypes.*;
import org.junit.Before;
import org.junit.Test;

import static com.sahaj.games.carrom.cleanstrike.TestHelper.*;
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
        final Striker striker = new Striker();
        final Player player = new Player(striker);
        assignSingleStrike(striker, player, coinHolder);
        player.playStroke();
        assertThat(blackCoinsInHolder(), is(eight));
    }

    @Test
    public void thatTheCoinHolderHasSevenBlackCoinsWhenMultiStrikeIsScored() {
        final int seven = 7;
        final Striker striker = new Striker();
        final Player player = new Player(striker);
        assignMultiStrikeToStriker(coinHolder, striker, player);
        player.playStroke();
        assertThat(blackCoinsInHolder(), is(seven));
    }

    @Test
    public void thatTheCoinHolderHasZeroRedCoinsWhenRedStrikeIsScored() {
        final int zero = 0;
        final Striker striker = new Striker();
        final Player player = new Player(striker);
        assignRedStrikeToStriker(coinHolder, striker, player);
        player.playStroke();
        assertThat(redCoinsInHolder(), is(zero));
    }

    @Test
    public void thatTheCoinHolderHasTotalCoinsIntactWhenStrikerStrikeIsScored() {
        final int ten = 10;
        final Striker striker = new Striker();
        final Player player = new Player(striker);
        TestHelper.assignStrikerStrike(striker, player, coinHolder);
        player.playStroke();
        assertThat(totalCoinsInHolder(), is(ten));
    }

    @Test
    public void thatTheCoinHolderHasNineCoinsWhenDefunctStrike() {
        final int nine = 9;
        final Striker striker = new Striker();
        final Player player = new Player(striker);
        assignDefunctStrikeToStriker(coinHolder, striker, player);
        player.playStroke();
        assertThat(totalCoinsInHolder(), is(nine));
    }
}
