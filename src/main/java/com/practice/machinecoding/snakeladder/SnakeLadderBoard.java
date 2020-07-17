package com.practice.machinecoding.snakeladder;

import java.util.HashMap;
import java.util.Map;

public class SnakeLadderBoard {
    private int start=0;
    private int end=100;
    private Map<Integer,Integer> ladderMap;
    private Map<Integer,Integer> snakeMap;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public Map<Integer, Integer> getLadderMap() {
        return ladderMap;
    }

    public void setLadderMap(Map<Integer, Integer> ladderMap) {
        this.ladderMap = ladderMap;
    }

    public Map<Integer, Integer> getSnakeMap() {
        return snakeMap;
    }

    public void setSnakeMap(Map<Integer, Integer> snakeMap) {
        this.snakeMap = snakeMap;
    }

    public SnakeLadderBoard()
    {
        this(0,100);    //to avoid code duplication
                        // constructor delegation
    }

    public SnakeLadderBoard(int start,int end)
    {
        this(new HashMap<>(),new HashMap<>());
        this.start=start;
        this.end=end;
    }

    public SnakeLadderBoard(Map<Integer,Integer> snakeMap ,Map<Integer,Integer> ladderMap )
    {
        this.ladderMap= ladderMap;
        this.snakeMap=  snakeMap;

        if(this.ladderMap.size() == 0 || this.snakeMap.size() == 0)
            populateDefaultValues();
    }

    private void populateDefaultValues()
    {
        //populating ladder map with default values
        ladderMap.put(1,38);
        ladderMap.put(4,14);
        ladderMap.put(8,30);
        ladderMap.put(28,76);
        ladderMap.put(21,42);
        ladderMap.put(50,67);
        ladderMap.put(71,92);
        ladderMap.put(86,99);
        //populating snake map with default values
        snakeMap.put(97,78);
        snakeMap.put(95,56);
        snakeMap.put(88,24);
        snakeMap.put(62,18);
        snakeMap.put(48,26);
        snakeMap.put(36,6);
        snakeMap.put(32,10);
        snakeMap.put(91,9);
        snakeMap.put(56,5);

    }
}
