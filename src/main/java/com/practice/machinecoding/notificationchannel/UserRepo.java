package com.practice.machinecoding.notificationchannel;
import java.util.*;
public class UserRepo {
    public static class UserDetails{
        public String phoneNo;
        public String WhatsAppNo;
        public String emailId;
        public UserDetails(String p,String w,String e)
        {
            this.phoneNo=p;
            this.WhatsAppNo=w;
            this.emailId=e;
        }
    }
    private UserRepo()
    { }
    private static volatile UserRepo instance=null;

    public static UserRepo getInstance()
    {
        if(instance == null)
        {
            synchronized (UserRepo.class)
            {
                if(instance == null)
                {
                    instance = new UserRepo();
                }
            }
        }
        return instance;
    }
    Map<Integer,UserDetails> userDetailsMap = new HashMap<>();
    public void addUser(int userID,String phoneNo,String wappNo, String emailId) throws Exception
    {
        if(userDetailsMap.containsKey(userID))
            throw new Exception("User Already Exsits");
        this.userDetailsMap.put(userID,new UserDetails(phoneNo,wappNo,emailId));
    }
    public UserDetails getUserDetails(int userId) throws Exception
    {
        if(!userDetailsMap.containsKey(userId))
            throw new Exception("User does not exist");
        return this.userDetailsMap.get(userId);
    }


}
