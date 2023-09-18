package org.example;

import java.util.Scanner;

public class NumberGuessingGameApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice = "y";

        System.out.println("Welcome to the number guessing game!");
        System.out.println("++++++++++++++++++++++++++++++++++++\n");

        while (!choice.equalsIgnoreCase("n")) {
            // + try-again Block
            System.out.println("I'm thinking of a random number between 1 and 100.");
            System.out.println("Try to guess it!\n");
            // + Game Block
            // Start a game
            // - pick a randmon #
            int rand = getRandomNumber();
            int guessCount = 0;

            System.out.println("Rand # = " + rand);

            int guess = 0;

            while (guess != rand) {
                // + Repeat until guess = random
                // - prompt user for guess    => getIntWithinRange()
                // - evaluate the guess       => getIntWithinRange()
                guess = getIntWithinRange(sc, "Enter number: ", 0, 101);
                guessCount++;
                // - if guess matches random - winner!
                // - if guess doesn't match random - display message and go back to prompt
                // - example: number 78
                // - guess: 12  diff: -66  msg: way too low     => diff < -10
                // - guess: 70  diff: -8   msg: too low         => diff < 0
                // - guess: 90  diff: 12   msg: way too high    => diff > 10
                // - guess: 80  diff:  2   msg: too high        => diff > 0
                // - guess: 78  diff:  0   msg: winner!
                int diff = guess - rand;

                if (diff == 0) {
                    System.out.println(getWinMessage(guessCount));
                } else {
                    System.out.println(getWrongGuessMessage(diff));
                }

            }

            choice = getStringValues(sc, "Try again? (y/n)", "y", "n");
        }

        System.out.println("Bye! Thanks for playing!");

    }

    private static String getStringValues(Scanner sc, String prompt, String str1, String str2) {
        // - prompt "try again?"
        // - if choice = "y" or "n" - valid
        // - if choice "y" repeat block, if "n" end program
        // - if choice invalid, repeat prompt
        boolean isValid = false;
        String choice = "";
        while (!isValid) {
            choice = getString(sc, prompt);
            if (choice.equals("")) {
                System.out.println("Error... entry required.");
            }
            else if (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
                System.out.println("Error... entry must be either 'y' or 'n'.");
            }
            else {
                isValid = true;
            }
        }
        return choice;
    }

    private static String getString(Scanner sc, String prompt) {
        System.out.println(prompt);
        String s = sc.nextLine();
        return s;
    }

    private static String getWinMessage(int guessCount) {
        String msg = "You got it in "+guessCount+" tries.\n";

        if (guessCount<=3) {
            msg += "Great work! You are a mathematical wizard.";
        }
        else if (guessCount <= 7) {
            msg += "Not too bad! You've got some potential.";
        }
        else {
            msg += "What took you so long? Maybe you should take some lessons.";
        }

        return msg;
    }

    private static String getWrongGuessMessage(int diff) {
        String msg = "Too high!";
        if (diff < -10) {
            msg = "Way too low!";
        }
        else if (diff < 0) {
            msg = "Too low!";
        }
        else if (diff > 10) {
            msg = "Way too high!";
        }

        return msg;
    }

    // get a random # between 1 and 100
    private static int getRandomNumber() {
        int randNum = (int)(Math.random() * 100) + 1;
        return randNum;
    }

    // get a valid int greater than the min, less than the max
    private static int getIntWithinRange(Scanner sc, String prompt, int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            // input is valid if whole number & between 1 and 100
            i = getInt(sc, prompt);
            if (i <= min) {
                System.out.println("Error! Number must be greater than "+min+"!");
            }
            else if (i >= max) {
                System.out.println("Error! Number must be less than "+max+"!");
            }
            else {
                isValid = true;
            }
        }

        return i;
    }

    private static int getInt(Scanner sc, String prompt) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.println(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            }
            else {
                System.out.println("Error! Please enter a whole number.");
            }
            sc.nextLine();
        }

        return i;
    }
}