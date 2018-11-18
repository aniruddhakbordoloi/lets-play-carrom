package com.sahaj.games.carrom.cleanstrike;

import com.sahaj.games.carrom.cleanstrike.entity.CarromBoard;
import com.sahaj.games.carrom.cleanstrike.entity.Printer;

import java.util.Scanner;

/**
 * Created by Aniruddha on 18-11-2018.
 */
public class InputReader {
    public static void main(String[] args) {
        boolean continueToPlay = true;
        final CarromBoard carromBoard = new CarromBoard();
        carromBoard.setPrinter(new Printer());
        while(continueToPlay) {
            try {
                System.out.println("Player 1: Choose an outcome from the list below");
                System.out.println("1. Strike");
                System.out.println("2. Multistrike");
                System.out.println("3. Red strike");
                System.out.println("4. Striker strike");
                System.out.println("5. Defunct coin");
                System.out.println("6. None");
                final Scanner scanner = new Scanner(System.in);
                String player1StrikeCode = scanner.next();

                System.out.println("Player 2: Choose an outcome from the list below");
                System.out.println("1. Strike");
                System.out.println("2. Multistrike");
                System.out.println("3. Red strike");
                System.out.println("4. Striker strike");
                System.out.println("5. Defunct coin");
                System.out.println("6. None");

                String player2StrikeCode = scanner.next();
                continueToPlay = carromBoard.play(Integer.valueOf(player1StrikeCode), Integer.valueOf(player2StrikeCode));
            }
            catch(final InvalidStrikeException invalidStrikeException) {
                System.out.println(invalidStrikeException.getMessage());
            }

        }
    }
}
