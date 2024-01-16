package com.goit.game.utils;

import java.util.Scanner;

import static com.goit.game.data.BoxData.BOX;

/*
*Class with game util methods
*/

public class Util {
    private Util(){
    }
    private static final Scanner scan = new Scanner(System.in);

// Util Class print start box for game
    public static void printBox() {
        System.out.println("\n\n " + BOX[0] + " | " + BOX[1] + " | " + BOX[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + BOX[3] + " | " + BOX[4] + " | " + BOX[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + BOX[6] + " | " + BOX[7] + " | " + BOX[8] + " \n");
    }

// Util Class print result of user game
    public static void printWinner(byte winner) {
        switch (winner) {
            case 1 -> System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            case 2 -> System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            case 3 -> System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
        }
    }

// Util Class check move of user
    public static void checkInput() {
        while (true) {
            byte input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (BOX[input - 1] == 'X' || BOX[input - 1] == 'O')
                    System.out.println("That one is already in use. Enter another.");
                else {
                    BOX[input - 1] = 'X';
                    break;
                }
            } else
                System.out.println("Invalid input. Enter again.");
        }
    }

// Util class get random move from computer
    public static void getRandom() {
        while (true) {
            byte rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (BOX[rand - 1] != 'X' && BOX[rand - 1] != 'O') {
                BOX[rand - 1] = 'O';
                break;
            }
        }
    }

// Util class check winner by X
    public static boolean isWinnerConditionOne() {
        return (BOX[0] == 'X' && BOX[1] == 'X' && BOX[2] == 'X') || (BOX[3] == 'X' && BOX[4] == 'X' && BOX[5] == 'X') || (BOX[6] == 'X' && BOX[7] == 'X' && BOX[8] == 'X') ||
               (BOX[0] == 'X' && BOX[3] == 'X' && BOX[6] == 'X') || (BOX[1] == 'X' && BOX[4] == 'X' && BOX[7] == 'X') || (BOX[2] == 'X' && BOX[5] == 'X' && BOX[8] == 'X') ||
               (BOX[0] == 'X' && BOX[4] == 'X' && BOX[8] == 'X') || (BOX[2] == 'X' && BOX[4] == 'X' && BOX[6] == 'X');
    }

// Util class check winner by 0
    public static boolean isWinnerConditionTwo() {
        return ((BOX[0] == 'O' && BOX[1] == 'O' && BOX[2] == 'O') || (BOX[3] == 'O' && BOX[4] == 'O' && BOX[5] == 'O') || (BOX[6] == 'O' && BOX[7] == 'O' && BOX[8] == 'O') ||
                (BOX[0] == 'O' && BOX[3] == 'O' && BOX[6] == 'O') || (BOX[1] == 'O' && BOX[4] == 'O' && BOX[7] == 'O') || (BOX[2] == 'O' && BOX[5] == 'O' && BOX[8] == 'O') ||
                (BOX[0] == 'O' && BOX[4] == 'O' && BOX[8] == 'O') || (BOX[2] == 'O' && BOX[4] == 'O' && BOX[6] == 'O'));
    }
}
