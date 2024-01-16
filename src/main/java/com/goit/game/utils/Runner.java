package com.goit.game.utils;

import static com.goit.game.data.BoxData.box;

/*
* Class Runner implements the main loop of the game using method startGame()
*/

public class Runner {
    private Runner(){
    }
    private static boolean boxAvailable = false;
    private static byte winner = 0;
    private static boolean boxEmpty = false;
    public static void startGame(){
        System.out.println("Enter box number to select. Enjoy!\n");
        while (true) {
            Util.printBox();
            if(!boxEmpty){
                for(int i = 0; i < 9; i++)
                    box[i] = ' ';
                boxEmpty = true;
            }
            Util.printWinner(winner);
            if (winner == 1 || winner == 2 || winner == 3 ){
                break;
            }
            Util.checkInput();
            if(Util.isWinnerConditionOne()){
                winner = 1;
                continue;
            }
            for(int i=0; i<9; i++){
                if(box[i] != 'X' && box[i] != 'O'){
                    boxAvailable = true;
                    break;
                }
            }
            if(boxAvailable == false){
                winner = 3;
                continue;
            }
            Util.getRandom();
            if(Util.isWinnerConditionTwo()){
                winner = 2;
            }
        }
    }
}
