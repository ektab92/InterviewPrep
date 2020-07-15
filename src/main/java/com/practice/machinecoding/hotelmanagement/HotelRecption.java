package com.practice.machinecoding.hotelmanagement;

import com.practice.machinecoding.hotelmanagement.hotelroom.RoomType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class HotelRecption {
    public static void executeTask(String input, HotelManager manager) throws Exception
    {
            String [] text=input.split("\\s+");
            switch(text[0])
            {
                case "ADD_ROOM":
                    if(text.length != 4)
                        throw new Exception("Invalid Input!!!!");
                    manager.addRooms(Integer.parseInt(text[1].trim()), RoomType.getType(text[2].trim()),Integer.parseInt(text[3].trim()));
                    break;
                case "CHECK_IN":
                    AllocationPreference pref =AllocationPreference.getAllocPref(text[4]);
                    if(text.length !=5 || pref == null)
                        throw new Exception("Invalid Input!!!!");
                    manager.checkIn(Integer.parseInt(text[1].trim()),Integer.parseInt(text[2].trim()),new Date(System.currentTimeMillis()),2,pref);
                    break;
                case "CHECK_OUT":
                    if(text.length != 2)
                        throw new Exception("Invalid Input!!!");
                    manager.checkOut(Integer.parseInt(text[1]));
                    break;
                default:
                    System.out.println("Operation not supported");
            }
    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HotelManager hotelManager = new HotelManager();
        while (true)
        {
            System.out.println("************Please provide requirements****************");
            try {
                String line =br.readLine();
                executeTask(line,hotelManager);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
