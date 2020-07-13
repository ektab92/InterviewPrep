package com.practice.machinecoding.notificationchannel.channel;

import com.practice.machinecoding.notificationchannel.UserRepo;

public class Whatsapp implements Channels{
    String channelId="whatsapp";
    int count = 0;
    @Override
    public void sendNotification(String message,int clientId) throws Exception
    {
        count++;
        if(count%5 == 0)
            throw new Exception("Some Failure while sending nofification");
        UserRepo.UserDetails userDetails=UserRepo.getInstance().getUserDetails(clientId);
        if(userDetails.WhatsAppNo == null)
            throw new Exception ("Client has no Whatsapp Number info present");
        else
            System.out.println(String.format("Sending Whatsapp message to %s", userDetails.WhatsAppNo));
    }
}
