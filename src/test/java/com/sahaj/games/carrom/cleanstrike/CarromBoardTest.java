package com.sahaj.games.carrom.cleanstrike;

import com.sahaj.games.carrom.cleanstrike.entity.CarromBoard;
import org.junit.Test;

import static com.sahaj.games.carrom.cleanstrike.PrinterMock.getPrintedStats;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Aniruddha on 17-11-2018.
 */
public class CarromBoardTest {

    @Test
    public void thatGameIsWonWhenTheWinnerScoresMinFiveAndThreeMoreThanOpponent() throws InvalidStrikeException {
        final int player1Strike = 1;
        final int player2MultiStrike = 2;
        final CarromBoard carromBoard = new CarromBoard();
        carromBoard.setPrinter(new PrinterMock());
        carromBoard.play(player1Strike, player2MultiStrike);
        carromBoard.play(player1Strike, player2MultiStrike);
        carromBoard.play(player1Strike, player2MultiStrike);
        assertThat(printedStatus(), is("Player 2 won the game. Final Score: 6-3"));
    }

    private String printedStatus() {
        return getPrintedStats();
    }

    @Test
    public void thatGameIsADrawWhenCoinsExhaustedWithoutMinLeadForEitherPlayer() throws InvalidStrikeException {
        final int player1MultiStrike = 2;
        final int player2MultiStrike = 2;
        final CarromBoard carromBoard = new CarromBoard();
        carromBoard.setPrinter(new PrinterMock());
        carromBoard.play(player1MultiStrike, player2MultiStrike);
        carromBoard.play(player1MultiStrike, player2MultiStrike);
        carromBoard.play(player1MultiStrike, player2MultiStrike);
        assertThat(printedStatus(), is("The game is a draw."));
    }

    @Test
    public void thatGameCannotBeContinuedOnceOver() throws InvalidStrikeException {
        final int player1MultiStrike = 2;
        final int player2MultiStrike = 2;
        final CarromBoard carromBoard = new CarromBoard();
        carromBoard.setPrinter(new PrinterMock());
        carromBoard.play(player1MultiStrike, player2MultiStrike);
        carromBoard.play(player1MultiStrike, player2MultiStrike);
        carromBoard.play(player1MultiStrike, player2MultiStrike);
        carromBoard.play(player1MultiStrike, player2MultiStrike);
        assertThat(printedStatus(), is("The game is over. Please start a new game!"));
    }
}
