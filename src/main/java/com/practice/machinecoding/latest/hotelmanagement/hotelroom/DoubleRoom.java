package com.practice.machinecoding.latest.hotelmanagement.hotelroom;

public class DoubleRoom extends HotelRoom{

    double basePrice=2000.00;
    DoubleRoom(int roomNo, int level, RoomType type) {
        super(roomNo, level, type);
    }

    @Override
    public double calcPrice(int noOfDays)
    {
        return noOfDays*basePrice;
    }
}
