package com.practice.machinecoding.latest.smarthome.controlleddevices;

public abstract class Device {
    String deviceId;
    String currState;
    Device(String id)
    {
        this.deviceId=id;
        this.currState="OFF";
    }
    public void switchOn() throws Exception
    {
        if(this.currState .equals( "OFF"))
        {
            this.currState="ON";
            System.out.println(String.format("Device %s is switched On",deviceId));
        }
        else
            throw new Exception(String.format("Device %s is already ON",deviceId));
    }
    public void switchOff() throws Exception
    {
        if(this.currState .equals( "ON"))
        {
            this.currState="OFF";
            System.out.println(String.format("Device %s is switched Off",deviceId));
        }
        else
            throw new Exception(String.format("Device %s is already OFF",deviceId));
    }
    abstract public void increase() throws Exception;
    abstract public void decrease() throws Exception;
}
