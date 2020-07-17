package com.practice.machinecoding.latest.hotelmanagement.hotelroom;

import java.util.*;
abstract public class HotelRoom implements Comparable<HotelRoom>{
    public int roomNo;
    int level;
    RoomType type;
    Map<String,Boolean>amenitiesMap;
    HotelRoom(int roomNo,int level,RoomType type)
    {
        this.roomNo=roomNo;
        this.level=level;
        this.type=type;
        amenitiesMap=new HashMap<>();
    }
    @Override
    public int compareTo(HotelRoom room)
    {
        if(this.level == room.level)
        {
            if(this.roomNo == room.roomNo)
                return 0;
            if(this.roomNo > room.roomNo)
                return 1;
            else
                return -1;
        }
        if(this.level > room.level)
            return 1;
        else return -1;
    }

    public abstract double calcPrice(int noOfDays);
}
