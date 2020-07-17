package com.practice.machinecoding.latest.hotelmanagement.user;

import java.util.*;

public class UserRepo {
    private Map<Integer,UserDetails>userDetailsMap = new HashMap<>();

    public static class UserDetails{
        public int userId;
        String name;
        Date checkIn;
        Date checkOut;
        public int noOfDays;
        int noOfRooms;
        public List<Integer> roomNo;

       public UserDetails(int id, String name,Date checkIn ,int days,int noOfRooms)
        {
            this.userId=id;
            this.name = name;
            this.checkIn = checkIn;
            this.noOfRooms=noOfRooms;
            this.noOfDays= days;
            this.checkOut = new Date(checkIn.getTime()+(days*24*60*60*1000));
            this.roomNo=new ArrayList<>();
        }
    }
    private UserRepo(){};
    private static volatile UserRepo userRepo = null;

    public static UserRepo getUserRepoInstance()
    {
        if(userRepo == null)
        {
            synchronized (UserRepo.class)
            {
                if(userRepo == null)
                {
                    userRepo = new UserRepo();
                }
            }
        }
        return userRepo;
    }

    public UserDetails getUserDetails(int userId) throws Exception
    {
        if(userDetailsMap.containsKey(userId))
            return userDetailsMap.get(userId);
        else
            throw new Exception("User does not exist in repo");
    }
    public void addUser(int userId, String name,Date checkIn, int days,int noOfRooms )
    {
        UserDetails user = new UserDetails(userId,name,checkIn,days,noOfRooms);
        userDetailsMap.put(userId,user);
        System.out.println(String.format("user %s added",name));
    }
}
