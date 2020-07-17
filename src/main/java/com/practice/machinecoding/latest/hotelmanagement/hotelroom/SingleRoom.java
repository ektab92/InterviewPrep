package com.practice.machinecoding.latest.hotelmanagement.hotelroom;

public class SingleRoom extends HotelRoom{

    int basePrice = 1000;
    SingleRoom(int roomNo, int level, RoomType type) {
        super(roomNo, level, type);
    }

    @Override
    public double calcPrice(int noOfDays)
    {
        return noOfDays*basePrice;
    }
}
