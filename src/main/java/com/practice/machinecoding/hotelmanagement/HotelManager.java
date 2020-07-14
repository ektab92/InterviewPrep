package com.practice.machinecoding.hotelmanagement;

import com.practice.machinecoding.hotelmanagement.hotelroom.HotelRoom;
import com.practice.machinecoding.hotelmanagement.hotelroom.HotelRoomFactory;
import com.practice.machinecoding.hotelmanagement.hotelroom.RoomType;

import javax.xml.bind.annotation.XmlType;
import java.util.Collections;
import java.util.*;
import java.util.PriorityQueue;

public class HotelManager {
    int maxFloors;
    //floor 1 room1 on top..then so on
    PriorityQueue<HotelRoom> minHeap = new PriorityQueue<>();

    //floor n room n ..then so on
    PriorityQueue<HotelRoom> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    Map <Integer,Integer> roomIdGuestIdMap = new HashMap<>();
    Map<Integer, HotelRoom>roomIdRoomMap = new HashMap<>();

    public void addRooms(int roomId,RoomType type, int floor)
    {
        HotelRoom hotelRoomObj=HotelRoomFactory.getRoomObject(roomId,floor,type);
        roomIdRoomMap.put(roomId,hotelRoomObj);
        minHeap.add(hotelRoomObj);
        maxHeap.add(hotelRoomObj);
    }

    public void checkIn(int guestId,int noOfRooms, Date checkinDate, Date checkOutDate,AllocationPreference pref)
    {
        int k =0;
        List<Integer>roomIds = new ArrayList<>();
        if(pref == AllocationPreference.TOP)
        {
            while(k<noOfRooms)
            {
                HotelRoom roomObj = maxHeap.remove();
                roomIdGuestIdMap.put(roomObj.roomId,guestId);
                roomIds.add(roomObj.roomId);
                minHeap.remove(roomObj);
                k++;
            }
        }
        else
        {
            while(k<noOfRooms)
            {
                HotelRoom roomObj = minHeap.remove();
                roomIdGuestIdMap.put(roomObj.roomId,guestId);
                roomIds.add(roomObj.roomId);
                maxHeap.remove(roomObj);
                k++;
            }
        }
        GuestRepo.GuestDetails guestDetails = new GuestRepo.GuestDetails(noOfRooms,checkinDate,checkOutDate);
        guestDetails.roomIdList = roomIds;
        GuestRepo.guestDetailsMap.put(guestId,guestDetails);
        System.out.println(String.format("Rooms allocated to guest %d, are %s",guestId,roomIds.toString()));
    }
    public void checkOut(int guestId)
    {
        GuestRepo.GuestDetails guestObj =GuestRepo.guestDetailsMap.get(guestId);
        for(int roomId:guestObj.roomIdList)
        {
            maxHeap.add(roomIdRoomMap.get(roomId));
            minHeap.add(roomIdRoomMap.get(roomId));
            roomIdGuestIdMap.remove(roomId);
        }
        System.out.println(String.format("checked out guest %d, from rooms %s",guestId,guestObj.roomIdList.toString()));
        guestObj.roomIdList.clear();

    }

    public static void main(String[] args) {
        HotelManager hotelManager = new HotelManager();
        hotelManager.addRooms(1,RoomType.SINGLE,1);
        hotelManager.addRooms(2,RoomType.DOUBLE,1);
        hotelManager.addRooms(3,RoomType.FAMILY,1);

        hotelManager.addRooms(4,RoomType.SINGLE,2);
        hotelManager.addRooms(5,RoomType.SINGLE,2);
        hotelManager.addRooms(6,RoomType.DOUBLE,3);
        hotelManager.addRooms(7,RoomType.FAMILY,3);

        hotelManager.addRooms(8,RoomType.FAMILY,4);
        hotelManager.addRooms(9,RoomType.FAMILY,4);
        hotelManager.addRooms(10,RoomType.DOUBLE,4);
        hotelManager.addRooms(11,RoomType.FAMILY,4);

        Long nowDate = System.currentTimeMillis();
        hotelManager.checkIn(20,1,new Date(nowDate),new Date (nowDate+2*24*60*60*1000), AllocationPreference.DEFAULT);

        hotelManager.checkIn(21,2,new Date(nowDate),new Date (nowDate+2*24*60*60*1000), AllocationPreference.TOP);
        hotelManager.checkOut(20);

    }
}
