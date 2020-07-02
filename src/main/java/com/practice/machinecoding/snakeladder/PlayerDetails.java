package com.practice.machinecoding.snakeladder;

import java.util.*;

public class PlayerDetails {
    private Map<Integer,Integer> playerStateMap=new HashMap<>();
    public PlayerDetails(){}

    public void addPlayer(int playerId)
    {
        playerStateMap.put(playerId,0);
    }
    public int gerPlayerState(int playerId)
    {
       return playerStateMap.get(playerId);
    }
    public void updatePlayerState(int playerId,int newState)
    {
        this.playerStateMap.put(playerId,newState);
    }
}
