package com.practice.machinecoding.latest.snakeladder;

import java.util.*;

public class SnakeLadderBoard {
    int start;
    int end;
    Map<Integer,Integer>snakeMap;
    Map<Integer,Integer>ladderMap;

    public SnakeLadderBoard()
    {
        this.start=0;
        this.end=100;
        snakeMap= new HashMap<>();
        ladderMap=new HashMap<>();
    }

    public void addSnakes(int head ,int tail)
    {
        snakeMap.put(head,tail);
        System.out.println(String.format("Snake added to ladder with head at %d  and tail at %d",head,tail));
    }

    public void addLadder(int head, int tail)
    {
        ladderMap.put(head,tail);
        System.out.println(String.format("Ladder added in board with head at %d and tail at %d",head,tail));
    }

}
