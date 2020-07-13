package com.practice.machinecoding.notificationchannel.channel;

import com.practice.machinecoding.notificationchannel.UserRepo;

public class Email implements Channels {
    String channelId="Email";
    int count=0;
    @Override
    public void sendNotification(String message,int clientId) throws Exception
    {
        this.count++;
        if(count%3 == 0)
            throw new Exception("Some Failure while sending nofification");
        UserRepo.UserDetails userDetails=UserRepo.getInstance().getUserDetails(clientId);
        if(userDetails.emailId == null)
            throw new Exception ("Client has no Email info present");
        else
            System.out.println(String.format("Sending Email message to %s", userDetails.emailId));
    }
}
