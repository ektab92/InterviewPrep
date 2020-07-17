package com.practice.machinecoding.latest.snakeladder;
import java.util.*;
public class PlayerDetails {
    String playerName;
    private Map<String,Integer>playerStateMap = new HashMap<>();
    public PlayerDetails(String name)
    {
        this.playerName=name;
        this.playerStateMap.put(this.playerName,0);
    }

    public int getPlayerStatus(String playerName)
    {
        return playerStateMap.get(playerName);
    }

    public void updatePlayerStatus(String playerName,int value)
    {
        playerStateMap.put(playerName,value);
    }
}
