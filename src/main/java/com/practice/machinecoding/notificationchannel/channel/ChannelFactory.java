package com.practice.machinecoding.notificationchannel.channel;


public class ChannelFactory {
    public static enum  ChannelsType{
        SMS,
        Whatsapp,
        EMAIL
    }
    public static Channels getChannelInstance(ChannelsType type)
    {
        switch (type)
        {
            case SMS:
                return new Sms();
            case EMAIL:
                return new Email();
            case Whatsapp:
                return new Whatsapp();
            default:
                return null;
        }
    }
}
