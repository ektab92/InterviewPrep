package com.practice.machinecoding.hotelmanagement;

import java.util.*;

public class GuestRepo {
    int guestId;
    static Map<Integer,GuestDetails>guestDetailsMap = new HashMap<>();
    static class GuestDetails{
        int noOfRooms;
        Date checkIn;
        int noOfDays;
        Date checkOut;
        List<Integer>roomIdList;

        public GuestDetails( int noRooms,Date checkIn,int noOfDays)
        {
            this.noOfRooms=noRooms;
            this.checkIn=checkIn;
            this.noOfDays=noOfDays;
            this.checkOut=new Date(checkIn.getTime()+(noOfDays*24*60*60*1000));
        }

    }
    public List<Integer>getRoomsByGuestId(int guestId)
    {
        return guestDetailsMap.get(guestId).roomIdList;
    }
}
