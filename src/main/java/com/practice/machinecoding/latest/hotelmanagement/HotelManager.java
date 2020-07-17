package com.practice.machinecoding.latest.hotelmanagement;

import com.practice.machinecoding.latest.hotelmanagement.hotelroom.HotelRoom;
import com.practice.machinecoding.latest.hotelmanagement.hotelroom.HotelRoomFactory;
import com.practice.machinecoding.latest.hotelmanagement.hotelroom.RoomType;
import com.practice.machinecoding.latest.hotelmanagement.user.UserRepo;

import java.util.*;

public class HotelManager {
    UserRepo userRepo = UserRepo.getUserRepoInstance();
    Map<Integer, HotelRoom> roomObjMap = new HashMap<>();
    Map<Integer,Integer> roomIdGuestIdMap = new HashMap<>();
    PriorityQueue<HotelRoom> roomMinHeap = new PriorityQueue<>();

    public void addRoom(int roomNo, int level, RoomType type)
    {
        HotelRoom room = HotelRoomFactory.getRoomObject(roomNo,level,type);
        roomObjMap.put(roomNo,room);
        roomMinHeap.add(room);
        System.out.println(String.format("Room %d added to floor %d",roomNo, level));
    }

    public void checkIn(int guestId, String name,int noOfDays,int noOfRooms) throws Exception
    {
        userRepo.addUser(guestId,name,new Date(System.currentTimeMillis()),noOfDays,noOfRooms);
        UserRepo.UserDetails guest = userRepo.getUserDetails(guestId);
        if(roomMinHeap.size()>=noOfRooms)
        {
            for(int i =0;i<noOfRooms;i++)
            {
                HotelRoom room = roomMinHeap.remove();
                guest.roomNo.add(room.roomNo);
                roomIdGuestIdMap.put(room.roomNo,guestId);
            }
            System.out.println(String.format("guest %d has booked rooms %s",guestId,guest.roomNo.toString()));
        }
        else
            throw new Exception("No rooms available");

    }

    public void checkOut(int guestId) throws Exception {
        List rooms=userRepo.getUserDetails(guestId).roomNo;
        double price =0.0;
        for(int i =0;i< rooms.size();i++)
        {
            HotelRoom roomObj =roomObjMap.get(rooms.get(i));
            price+= roomObj.calcPrice(userRepo.getUserDetails(guestId).noOfDays);
            roomIdGuestIdMap.remove(roomObj.roomNo);
            roomMinHeap.add(roomObj);
        }
        System.out.println(String.format("Good Bye %d . Your Bill is %f.",guestId,price));
        userRepo.getUserDetails(guestId).roomNo=null;

    }

    public static void main(String[] args) throws Exception {
        HotelManager hotelManager = new HotelManager();
        hotelManager.addRoom(1, 1, RoomType.getRoomType("SINGLE"));
        hotelManager.addRoom(2,1,RoomType.getRoomType("Double"));
        hotelManager.addRoom(3, 1, RoomType.getRoomType("Double"));
        hotelManager.addRoom(4,1,RoomType.getRoomType("Family"));

        hotelManager.addRoom(11, 2, RoomType.getRoomType("SINGLE"));
        hotelManager.addRoom(21,2,RoomType.getRoomType("Double"));
        hotelManager.addRoom(31, 2, RoomType.getRoomType("Double"));
        hotelManager.addRoom(41,2,RoomType.getRoomType("Family"));

        hotelManager.checkIn(100,"X",2,2);
        hotelManager.checkIn(200,"Y",1,2);
        hotelManager.checkOut(200);
        //hotelManager.checkIn(500,"Y",1,20);
        //hotelManager.userRepo.addUser(100,"X"));
       // hotelManager.userRepo.addUser(100,"X");
    }
}
