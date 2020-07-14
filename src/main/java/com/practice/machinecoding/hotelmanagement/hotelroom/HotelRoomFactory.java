package com.practice.machinecoding.hotelmanagement.hotelroom;

public class HotelRoomFactory {
    public static HotelRoom getRoomObject(int id,int floor, RoomType type)
    {
        switch (type)
        {
            case SINGLE:
                return new SingleRoom(id,floor,type);
            case DOUBLE:
                return new DoubleRoom(id,floor,type);
            case FAMILY:
                return new FamilyRoom(id,floor,type);
            default:
                return null;
        }
    }
}
