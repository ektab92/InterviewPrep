package com.practice.machinecoding.hotelmanagement.hotelroom;

public class DoubleRoom extends HotelRoom {
    int basePrice =2000;
    public DoubleRoom(int id, int floor, RoomType type) {
        super(id, floor, type);
    }

    @Override
    public int getPrice() {
        return 0;
    }
}
