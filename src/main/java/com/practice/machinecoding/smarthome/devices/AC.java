package com.practice.machinecoding.smarthome.devices;

public class AC extends Device{
    int minTemp;
    int maxTemp;
    int currTemp;
    public AC(){};
    public AC(int deviceId)
    {
        this.minTemp=17;
        this.maxTemp=35;
        this.currTemp=17;
        this.deviceId=deviceId;
        this.deviceState.put("Status","OFF");
    }
    @Override
    public  void increase() throws  Exception
    {
        if(this.deviceState.get("Status").equals("OFF"))
            throw new Exception("Device is OFF.Command will not be executed");
        if(this.currTemp== this.maxTemp)
            throw new Exception("AC Already at Max Temperature");
        else
        {
            this.currTemp = currTemp + 1;
            System.out.println(String.format("AC Temp Increased to %d", currTemp));
        }

    }
    @Override
    public  void decrease() throws  Exception
    {
        if(this.deviceState.get("Status").equals("OFF") )
            throw new Exception("Device is OFF.Command will not be executed");
        if(this.currTemp== this.minTemp)
            throw new Exception("AC Already at Min Temperature");
        else {
            this.currTemp = currTemp - 1;
            System.out.println(String.format("AC Temp Decreased to %d", currTemp));
        }

    }
}
