package com.practice.machinecoding.latest.snakeladder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GameDriver {
    static Map<String,PlayerDetails>playerObjMap = new HashMap<>();
    static SnakeLadderBoard board = new SnakeLadderBoard();

    public void addPlayer(String playerName) throws Exception
    {
        PlayerDetails player = new PlayerDetails(playerName);
        if(!playerObjMap.containsKey(playerName))
            playerObjMap.put(playerName,player);
        else
            throw new Exception("Player with smae name already exists. Please choose diff name");
    }

    public void deletePlayer(String playerName) throws Exception
    {
        if(playerObjMap.containsKey(playerName)) {
            playerObjMap.remove(playerName);
            System.out.println(String.format("player %s has been removed", playerName));
        }
        else
            throw new Exception("No such player Exists");
    }
    public static boolean  playGame(String playerName,int diceValue)
    {
       PlayerDetails playerObj= playerObjMap.get(playerName);
       int currState =playerObj.getPlayerStatus(playerName);
       int newState = currState+diceValue;
       if(newState >= 100)
       {
           System.out.println(String.format("%s, wins the game.",playerName));
           return true;
       }
       if(board.ladderMap.containsKey(newState))
       {
           System.out.println(String.format("%s got a Ladder !!!!Congrats",playerName));
           playerObj.updatePlayerStatus(playerName,board.ladderMap.get(newState));
       }
       else if (board.snakeMap.containsKey(newState))
       {
           System.out.println(String.format("%s got a Snake !!!!Bad Luck",playerName));
           playerObj.updatePlayerStatus(playerName,board.snakeMap.get(newState));
       }
       else
       {
           playerObj.updatePlayerStatus(playerName,newState);
       }
       System.out.println(String.format("%s has reached %d after this dice roll",playerName,playerObj.getPlayerStatus(playerName)));
       return false;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Snake Ladder Game!!!");
        System.out.println("Please add Number of Snakes");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {

           String l1 = br.readLine().trim();
           System.out.println(String.format("Please add %d details of Snake head and tail .",Integer.parseInt(l1)));
           for(int l =0;l<Integer.parseInt(l1);l++)
           {
               String snake[]=br.readLine().split("\\s+");
               board.snakeMap.put(Integer.parseInt(snake[0].trim()),Integer.parseInt(snake[1].trim()));
           }

           System.out.println("Please add Number of Ladders");
           String l2 = br.readLine().trim();
           System.out.println(String.format("Please add %d details of Ladder head and tail .",Integer.parseInt(l2)));
           for(int l =0;l<Integer.parseInt(l2);l++)
           {
                String ladder[]=br.readLine().split("\\s+");
                board.ladderMap.put(Integer.parseInt(ladder[0].trim()),Integer.parseInt(ladder[1].trim()));
           }

           System.out.println("Please provide Number of Players");
           Integer l3 = Integer.parseInt(br.readLine().trim());
           String player[]= new String [l3];
           System.out.println("Please register Players");
           for(int l =0;l<l3;l++)
           {
               String playerName = br.readLine().trim();
               player[l]=playerName;
               playerObjMap.put(playerName,new PlayerDetails(playerName));
           }

           Random random = new Random();
           System.out.println("***********Welcome to Ekta's Snake Ladder Game***********");
           int i =0;
           while(true)
           {
               if (i ==l3)
                    i=0;
               int r =random.nextInt(6)+1;
               String playerName = player[i];
               System.out.println(String.format("%s got dice value %d ",playerName,r));
               boolean isFinished=playGame(playerName,r);
               if(isFinished)
               {
                   break;
               }
               i++;
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
