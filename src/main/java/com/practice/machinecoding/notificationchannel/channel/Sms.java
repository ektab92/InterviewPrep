package com.practice.machinecoding.notificationchannel.channel;

import com.practice.machinecoding.notificationchannel.UserRepo;

public class Sms implements Channels{
    String channelId="sms";
    int count=0;
    @Override
    public void sendNotification(String message,int clientId) throws Exception
    {
        this.count++;
        if(count%4 == 0)
            throw new Exception("Some Failure while sending nofification");
        UserRepo.UserDetails userDetails=UserRepo.getInstance().getUserDetails(clientId);
        if(userDetails.phoneNo == null)
            throw new Exception ("Client has no Phone Number info present");
        else
            System.out.println(String.format("Sending SMS message to %s", userDetails.phoneNo));

    }
}
