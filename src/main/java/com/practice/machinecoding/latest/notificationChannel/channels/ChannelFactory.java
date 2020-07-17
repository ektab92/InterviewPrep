package com.practice.machinecoding.latest.notificationChannel.channels;

public class ChannelFactory {
    public static Channel getChannelInstance(ChannelTypes type)
    {
        switch(type)
        {
            case EMAIL:
                return new Email();
            case SMS:
                return new SMS();
            case W_APP:
                return new Whatsapp();
            default:
                return null;
        }
    }
}
