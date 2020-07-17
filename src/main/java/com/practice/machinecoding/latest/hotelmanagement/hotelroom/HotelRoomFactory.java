package com.practice.machinecoding.latest.hotelmanagement.hotelroom;

public class HotelRoomFactory {
    public static HotelRoom getRoomObject(int roomNo,int floor, RoomType type)
    {
        switch(type)
        {
            case SINGLE:
                return new SingleRoom(roomNo,floor,type);
            case DOUBLE:
                return new DoubleRoom(roomNo,floor,type);
            case FAMILY:
                return new FamilyRoom(roomNo,floor,type);
            default :
                return null;
        }

    }
}
