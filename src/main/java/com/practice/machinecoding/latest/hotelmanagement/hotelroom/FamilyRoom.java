package com.practice.machinecoding.latest.hotelmanagement.hotelroom;

public class FamilyRoom extends HotelRoom {
    double basePrice=3000.00;
    FamilyRoom(int roomNo, int level, RoomType type) {
        super(roomNo, level, type);
    }

    @Override
    public double calcPrice(int noOfDays)
    {

        return noOfDays*basePrice;
    }
}
