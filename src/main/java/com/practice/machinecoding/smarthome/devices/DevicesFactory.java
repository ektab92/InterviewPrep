package com.practice.machinecoding.smarthome.devices;

public class DevicesFactory {
    public static enum DeviceTypes{
        FAN,
        LIGHT,
        FRIDGE,
        AC;
    };
    public static Device getDevice(DeviceTypes type)
    {
        switch(type)
        {
            case FAN:
                return new Fan();
            case LIGHT:
                return new Light();
            case FRIDGE:
                return new Fridge();
            case AC:
                return new AC();
            default:
                return null;
        }
    }
}
