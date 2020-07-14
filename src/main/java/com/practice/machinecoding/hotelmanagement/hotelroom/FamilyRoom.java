package com.practice.machinecoding.hotelmanagement.hotelroom;

public class FamilyRoom extends HotelRoom {
    public FamilyRoom(int id, int floor, RoomType type) {
        super(id, floor, type);
    }
    int basePrice=3000;
    @Override
    public int getPrice() {
        return 0;
    }
}
