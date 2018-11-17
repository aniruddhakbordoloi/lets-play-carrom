package com.sahaj.games.carrom.cleanstrike.entity;

import com.sahaj.games.carrom.cleanstrike.striketypes.*;

/**
 * Created by Aniruddha on 17-11-2018.
 */
public class CarromBoard {

    private Strike player1Strike;
    private Strike player2Strike;
    private Striker player1Striker;
    private Striker player2Striker;
    private Player player1;
    private Player player2;
    private CoinHolder coinHolder;
    private boolean continuePlay = true;

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    private Printer printer;

    public CarromBoard() {
        this.coinHolder = new CoinHolder();
        this.player1Striker = new Striker();
        this.player2Striker = new Striker();
        this.player1 = new Player(this.player1Striker);
        this.player2 = new Player(this.player2Striker);
    }

    private Strike resolveStrikeCode(final int playerStrikeCode) {
        final Strike strike;
        switch(playerStrikeCode) {
            case 1:
                strike = new SingleStrike();
                break;
            case 2:
                strike = new MultiStrike();
                break;
            case 3:
                strike = new RedStrike();
                break;
            case 4:
                strike = new StrikerStrike();
                break;
            case 5:
                strike = new DefunctStrike();
                break;
            case 6:
                strike = new NoStrike();
                break;
            default:
                strike = new NoStrike();
                break;
        }
        return strike;
    }

    public void play(final int player1StrikeCode, final int player2StrikeCode) {
        if (gameIsNotOver()) {
            resolveStrikeCode(player1StrikeCode, player2StrikeCode);
            assignStrikeToStriker();
            registerPlayersAndCoinHolderForResultsPerStrike();
            startGame();

            if (hasAnyPlayerWon()) {
                this.printer.printStats(winningPlayer() + " won the game. Final Score: "+winnerScore()+"-"+ secondWinnerScore());
                this.continuePlay = false;
            }
            else if(hasCoinsExhausted()) {
                this.printer.printStats("The game is a draw.");
                this.continuePlay = false;
            }
        }
        else {
            this.printer.printStats("The game is over. Please start a new game!");
        }
    }

    private boolean gameIsNotOver() {
        return this.continuePlay;
    }

    private int secondWinnerScore() {
        return winnerScore() == this.player1.currentScore() ? this.player2.currentScore() : this.player1.currentScore();
    }

    private int winnerScore() {
        return this.player1.currentScore() > this.player2.currentScore() ? this.player1.currentScore() : this.player2.currentScore();
    }

    private String winningPlayer() {
        return this.player1.currentScore() > this.player2.currentScore() ? "Player 1" : "Player 2";
    }

    private void startGame() {
        this.player1.playStroke();
        this.player2.playStroke();
    }

    private void assignStrikeToStriker() {
        this.player1Striker.setStrike(this.player1Strike);
        this.player2Striker.setStrike(this.player2Strike);
    }

    private void resolveStrikeCode(int player1StrikeCode, int player2StrikeCode) {
        this.player1Strike = resolveStrikeCode(player1StrikeCode);
        this.player2Strike = resolveStrikeCode(player2StrikeCode);
    }

    private boolean hasCoinsExhausted() {
        return this.coinHolder.getTotalCoins() <= 0;
    }

    private void registerPlayersAndCoinHolderForResultsPerStrike() {
        this.player1Strike.register(this.coinHolder);
        this.player2Strike.register(this.coinHolder);
        this.player1Strike.register(this.player1);
        this.player2Strike.register(this.player2);
    }

    private boolean hasAnyPlayerWon() {
        final int player1Score = this.player1.currentScore();
        final int player2Score = this.player2.currentScore();
        if (player1Score > player2Score) {
            if (player1Score >= 5 && (player1Score - player2Score) >= 3) {
                return true;
            }
        }
        else {
            if (player2Score >= 5 && (player2Score - player1Score) >= 3) {
                return true;
            }
        }
        return false;
    }
}
