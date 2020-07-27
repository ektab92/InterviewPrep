package com.practice.machinecoding.splitwise.user;

import java.util.*;

public class UserRepository {
    public Map<Integer,UserDetails> userObjectMap = new HashMap<>();
    private UserRepository(){};
    private static volatile UserRepository userRepo=null;
    public static UserRepository getInstance()
    {
        if(userRepo == null)
        {
            synchronized (UserRepository.class)
            {
                if(userRepo == null)
                    userRepo = new UserRepository();
            }
        }
        return userRepo;
    }
    public void addUser(int userId, String userName)
    {
        UserDetails userDetails = new UserDetails(userId,userName);
        userObjectMap.put(userId,userDetails);
        System.out.println(String.format ("user %d added to user repository!!Welcome to SplitWise Expense Management App",userId));
    }

    public void removeUser(int userId)
    {
        userObjectMap.remove(userId);
        System.out.println(String.format ("user %d removed from user repository!!We Except you back soon",userId));
    }
}
