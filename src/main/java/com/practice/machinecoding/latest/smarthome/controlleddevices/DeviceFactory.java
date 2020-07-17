package com.practice.machinecoding.latest.smarthome.controlleddevices;

public class DeviceFactory {
    public static Device getdevice(DeviceTypes types,String deviceId)
    {
        switch(types)
        {
            case LIGHT:
                return new Light(deviceId);
            case FAN:
                return new Fan(deviceId);
            case AC:
                return new AC(deviceId);
            default:
                return null;
        }
    }
}
