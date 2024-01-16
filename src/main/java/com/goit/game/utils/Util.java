package com.goit.game.utils;

import java.util.Scanner;

import static com.goit.game.data.BoxData.box;

/*
*Class with game util methods
*/

public class Util {
    private Util(){
    }
    private static final Scanner scan = new Scanner(System.in);

// Util Class print start box for game
    public static void printBox() {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
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
                if (box[input - 1] == 'X' || box[input - 1] == 'O')
                    System.out.println("That one is already in use. Enter another.");
                else {
                    box[input - 1] = 'X';
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
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
    }

// Util class check winner by X
    public static boolean isWinnerConditionOne() {
        return (box[0] == 'X' && box[1] == 'X' && box[2] == 'X') || (box[3] == 'X' && box[4] == 'X' && box[5] == 'X') || (box[6] == 'X' && box[7] == 'X' && box[8] == 'X') ||
               (box[0] == 'X' && box[3] == 'X' && box[6] == 'X') || (box[1] == 'X' && box[4] == 'X' && box[7] == 'X') || (box[2] == 'X' && box[5] == 'X' && box[8] == 'X') ||
               (box[0] == 'X' && box[4] == 'X' && box[8] == 'X') || (box[2] == 'X' && box[4] == 'X' && box[6] == 'X');
    }

// Util class check winner by 0
    public static boolean isWinnerConditionTwo() {
        return ((box[0] == 'O' && box[1] == 'O' && box[2] == 'O') || (box[3] == 'O' && box[4] == 'O' && box[5] == 'O') || (box[6] == 'O' && box[7] == 'O' && box[8] == 'O') ||
                (box[0] == 'O' && box[3] == 'O' && box[6] == 'O') || (box[1] == 'O' && box[4] == 'O' && box[7] == 'O') || (box[2] == 'O' && box[5] == 'O' && box[8] == 'O') ||
                (box[0] == 'O' && box[4] == 'O' && box[8] == 'O') || (box[2] == 'O' && box[4] == 'O' && box[6] == 'O'));
    }
}
