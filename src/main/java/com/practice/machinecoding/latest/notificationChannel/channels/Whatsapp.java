package com.practice.machinecoding.latest.notificationChannel.channels;

public class Whatsapp extends Channel {
    int count=0;
    @Override
    public void sendNotification(String message, int clientId)  throws  Exception{
        count++;
        if(count% 5 == 0)
            throw  new Exception("Failure while sending notification from WhatsApp Channel.");
        String w_app =userRepo.getUser(clientId).whatsAppNo;
        if(w_app == null)
            throw new Exception("Whatsapp number does not exist.Failed to send notification");
        else
            System.out.println(String.format("whatsapp notification sent to number %s",w_app));
    }
}
