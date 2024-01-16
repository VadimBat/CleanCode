package com.goit.game.utils;

import static com.goit.game.data.BoxData.BOX;

/*
* Class Runner implements the main loop of the game using method startGame()
*/

public class Runner {
    private Runner(){
    }
    private static boolean boxAvailable = false;
    private static byte winner = 0;
    private static boolean boxEmpty = false;

// Main loop as game engine
    public static void startGame(){
        System.out.println("Enter box number to select. Enjoy!\n");
        while (true) {
            Util.printBox();
            makeEmptyBox();
            Util.printWinner(winner);
            if (winner >= 1 && winner <= 3 ){
                break;
            }
            Util.checkInput();
            if(Util.isWinnerConditionOne()){
                winner = 1;
                continue;
            }
            checkBoxAvailable();
            if(!boxAvailable){
                winner = 3;
                continue;
            }
            Util.getRandom();
            if(Util.isWinnerConditionTwo()){
                winner = 2;
            }
        }
    }

// Make box empty
    private static void makeEmptyBox(){
        if(!boxEmpty){
            for(int i = 0; i < 9; i++)
                BOX[i] = ' ';
            boxEmpty = true;
        }
    }

// Check available box position
    private static boolean checkBoxAvailable(){
        for(int i=0; i<9; i++){
            if(BOX[i] != 'X' && BOX[i] != 'O'){
                boxAvailable = true;
                break;
            }
        }
        return boxAvailable;
    }
}
