package com.practice.machinecoding.hotelmanagement.hotelroom;
import java.util.*;

abstract public class HotelRoom implements Comparable<HotelRoom>{
    public int roomId;
    public int floor;
    public RoomType type;
    public Map<String , Boolean> amenitiesMap;
    public HotelRoom(int id,int floor, RoomType type)
    {
        this.roomId=id;
        this.floor=floor;
        this.type=type;
    }
    @Override
    public int compareTo(HotelRoom room)
    {
        if(this.floor == room.floor)
        {
            if(this.roomId>room.roomId)
                return 1;
            if(this.roomId < room.roomId)
                return -1;
            else
                return 0;
        }
        if(this.floor> room.floor)
            return 1;
        else
            return -1;

    }
    public abstract int getPrice(int noOfDays);

}
