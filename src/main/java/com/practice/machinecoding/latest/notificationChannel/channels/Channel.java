package com.practice.machinecoding.latest.notificationChannel.channels;

import com.practice.machinecoding.latest.notificationChannel.users.UserRepo;

public abstract class Channel {

    public int totalRequest;
    public int totalFailure;
    public double successFactor;
    public double getSuccessFactor() {
        return successFactor;
    }
    public void updateSuccessFactor()
    {
        double sf = ((double)(totalRequest-totalFailure)/totalRequest)*100;
        setSuccessFactor(sf);
    }

    public void setSuccessFactor(double successFactor) {
        this.successFactor = successFactor;
    }

    Channel()
    {
        this.successFactor=0.0;
    }
    UserRepo userRepo = UserRepo.getInstance();

    public abstract void sendNotification(String message,int clientId) throws Exception;
}
