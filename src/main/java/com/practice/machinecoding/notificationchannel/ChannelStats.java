package com.practice.machinecoding.notificationchannel;

public class ChannelStats implements Comparable<ChannelStats>{
    public String ChannelId;
    public int totalRequest;
    public int failedCount;
    public double successFactor;
    ChannelStats(String channelId,int totalRequest,int failedCount,double successFactor)
    {
        this.ChannelId=channelId;
        this.totalRequest=totalRequest;
        this.failedCount=failedCount;
        this.successFactor=successFactor;
    }
    @Override
    public int compareTo(ChannelStats statObj)
    {
        if(this.successFactor == statObj.successFactor)
            return 0;
        if(this.successFactor > statObj.successFactor)
            return 1;
        else
            return -1;
    }
    public void updateSuccessFactor()
    {
        this.successFactor = ((double)(this.totalRequest-this.failedCount)/this.totalRequest)*100;
    }
}
