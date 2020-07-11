package com.practice.machinecoding.smarthome1.devices;

public class DeviceFactory {
    public static Devices getDevice(DevicesTypes type )
    {
        switch(type)
        {
            case FAN:
                return new Fan();
            case LIGHT:
                return new Light();
            default:
                return null;

        }
    }
}
