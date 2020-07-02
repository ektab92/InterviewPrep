package com.practice.machinecoding.snakeladder;

import java.util.Random;

public class GameDriver {

    public static void main(String[] args) {
        int numPlayer =4;
        PlayerDetails players = new PlayerDetails();
        SnakeLadderBoard board = new SnakeLadderBoard();
        Random diceRolls = new Random();
        for(int i=1;i<=numPlayer;i++) {
            players.addPlayer(i);
        }
        int currPlayer=1;
        int counter=1;
        while(true)
        {
            int value = diceRolls.nextInt(6)+1;
            System.out.println(String.format("Current Player Id : %d,  Dice Value : %d",currPlayer,value));
            int oldState = players.gerPlayerState(currPlayer);
            int newState = oldState+value;
            if(newState >= board.getEnd())
            {
                System.out.println(String.format("Player %d wins...closing the game",currPlayer));
                break;
            }
            else if(board.getLadderMap().containsKey(newState))
            {
                System.out.println("Found Ladder");
                newState =board.getLadderMap().get(newState);
            }
            else if (board.getSnakeMap().containsKey(newState))
            {
                System.out.println("Found Snake");
                newState = board.getSnakeMap().get(newState);
            }
            players.updatePlayerState(currPlayer,newState);
            System.out.println(String.format("Current Player Id : %d,  Dice Value : %d OldState :  %d  NewState : %d",currPlayer,value,oldState,newState));
            if(currPlayer+1 >4) {
                currPlayer = 1;
                System.out.println(String.format("Iterations in the game %d",counter++));
            }
            else
                currPlayer++;


        }
    }
}
