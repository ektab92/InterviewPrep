package com.practice.machinecoding.hotelmanagement.hotelroom;

public class SingleRoom extends HotelRoom{
    int basePrice = 1000;
    public SingleRoom(int id, int floor, RoomType type) {
        super(id, floor, type);
    }

    @Override
    public int getPrice() {
        return 0;
    }
}
