package com.practice.machinecoding.latest.notificationChannel.channels;

public class Email extends Channel  {
    int count=0;
    @Override
    public void sendNotification(String message, int clientId) throws Exception {
        count++;
        if(count% 4 == 0)
            throw  new Exception("Failure while sending notification from Email Channel.");
        String email =userRepo.getUser(clientId).emailId;
        if(email == null)
            throw new Exception("Email does not exist.Failed to send notification");
        else
            System.out.println(String.format("notification sent to email %s",email));
    }
}
