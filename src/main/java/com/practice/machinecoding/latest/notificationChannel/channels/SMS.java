package com.practice.machinecoding.latest.notificationChannel.channels;

public class SMS extends Channel {
    int count=0;
    @Override
    public void sendNotification(String message, int clientId) throws Exception {
        count++;
        if(count% 3 == 0)
            throw  new Exception("Failure while sending notification from SMS Channel.");
        String phone =userRepo.getUser(clientId).phNo;
        if(phone == null)
            throw new Exception("Phone does not exist.Failed to send notification");
        else
            System.out.println(String.format("sms notification sent to phone %s",phone));
    }
}
