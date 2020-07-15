package com.practice.machinecoding.hotelmanagement.hotelroom;

public enum RoomType {
    SINGLE,
    DOUBLE,
    FAMILY;

    public static RoomType getType(String type)
    {
        for(RoomType tp : RoomType.values()){
            if(tp.name().equals(type)){
                return tp;
            }
        }
        return null;
    }
}
