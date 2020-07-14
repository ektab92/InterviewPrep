package com.practice.machinecoding.hotelmanagement;

import java.util.*;

public class GuestRepo {
    int guestId;
    static Map<Integer,GuestDetails>guestDetailsMap = new HashMap<>();
    static class GuestDetails{
        int noOfRooms;
        Date checkIn;
        Date checkOut;
        List<Integer>roomIdList;

        public GuestDetails( int noRooms,Date checkIn,Date checkOut)
        {
            this.noOfRooms=noRooms;
            this.checkIn=checkIn;
            this.checkOut=checkOut;
        }

    }
    public List<Integer>getRoomsByGuestId(int guestId)
    {
        return guestDetailsMap.get(guestId).roomIdList;
    }
}
