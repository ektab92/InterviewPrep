package com.practice.machinecoding.smarthome1.devices;

public abstract class Devices {
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    String deviceId;
    protected String currState;
    Devices()
    {
        currState="OFF";
    }

    public void switchOn() throws Exception {
        if(currState == "OFF")
        {
            currState = "ON";
            System.out.println(String.format("Device %s is On",deviceId));
        }
        else
            throw new Exception("Device is already ON");
    }

     public void switchOff() throws Exception
     {
         if(currState == "ON")
         {
             currState = "OFF";
             System.out.println(String.format("Device %s is OFF",deviceId));
         }
         else
             throw new Exception("Device is already OFF");
     }

    abstract public void increaseSpeed() throws Exception;

    abstract public void decreaseSpeed() throws Exception;

}
