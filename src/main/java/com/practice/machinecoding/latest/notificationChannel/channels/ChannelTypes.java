package com.practice.machinecoding.latest.notificationChannel.channels;

public enum ChannelTypes {
    SMS,
    EMAIL,
    W_APP;
    public static ChannelTypes getChannel(String val)
    {
        for(ChannelTypes types: ChannelTypes.values())
        {
            if(types.name().equals(val))
                return types;
        }
        return null;
    }
}
