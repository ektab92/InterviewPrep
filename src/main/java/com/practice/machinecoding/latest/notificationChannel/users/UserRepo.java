package com.practice.machinecoding.latest.notificationChannel.users;

import java.util.*;

public class UserRepo {

    private Map<Integer,UserDetails> userDetailsMap = new HashMap<>();
    public static class UserDetails
    {
        public  int clientId;
        public String phNo;
        public String whatsAppNo;
        public String emailId;
        UserDetails(int clientId,String phone,String whatsap,String email)
        {
            this.clientId=clientId;
            this.phNo=phone;
            this.whatsAppNo=whatsap;
            this.emailId=email;
        }
    }
    private UserRepo(){};
    private static volatile UserRepo userRepo= null;
    public static UserRepo getInstance()
    {
        if(userRepo == null)
        {
            synchronized (UserRepo.class)
            {
                if(userRepo == null)
                    userRepo = new UserRepo();
            }
        }
        return userRepo;
    }
    public void addUser(int clientId, String ph, String whatsapp, String email)
    {
        userDetailsMap.put(clientId,new UserDetails(clientId,ph,whatsapp,email));
        System.out.println(String.format("User %d has been added to user repository",clientId));
    }
    public UserDetails getUser(int clientId)
    {
        return userDetailsMap.get(clientId);
    }
}
