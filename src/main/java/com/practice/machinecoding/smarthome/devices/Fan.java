package com.practice.machinecoding.smarthome.devices;

public class Fan extends Device {

    int minSpeed;
    int maxSpeed;
    int currSpeed;
    public Fan(){}
    public Fan(int deviceId)
    {
        this.minSpeed=1;
        this.currSpeed=1;
        this.maxSpeed=5;
        this.deviceId=deviceId;
        this.deviceState.put("Status","OFF");
    }
    @Override
    public void increase() throws Exception
    {
        if(this.deviceState.get("Status").equals("OFF") )
            throw new Exception("Device is OFF.Command will not be executed");
        if(this.currSpeed == this.maxSpeed)
            throw new Exception("Fan is already at max Speed");
        else {
            this.currSpeed = this.currSpeed + 1;
            System.out.println(String.format("Fan Speed Increased to %d", currSpeed));
        }
    }
    @Override
    public void decrease() throws Exception
    {
        if(this.deviceState.get("Status").equals("OFF") )
            throw new Exception("Device is OFF.Command will not be executed");
        if(this.currSpeed == this.minSpeed)
            throw new Exception("Fan is already at min Speed");
        else {
            this.currSpeed = this.currSpeed - 1;
            System.out.println(String.format("Fan Speed Decreased to %d", currSpeed));

        }
    }
}
