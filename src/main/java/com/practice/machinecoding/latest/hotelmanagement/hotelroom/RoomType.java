package com.practice.machinecoding.latest.hotelmanagement.hotelroom;

public  enum RoomType {
    SINGLE,
    DOUBLE,
    FAMILY;
    public static RoomType getRoomType(String type)
    {
        for(RoomType t : RoomType.values())
        {
            if(t.name().equalsIgnoreCase(type))
                return t;
        }
        return null;
    }
}
