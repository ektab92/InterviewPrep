package com.practice.machinecoding.smarthome.devices;

public class Fridge extends Device{
    int currTemp;
    int minTemp;
    int maxTemp;
    public Fridge() {}
    public Fridge(int deviceId)
    {
        this.currTemp=30;
        this.minTemp=10;
        this.maxTemp=30;
        this.deviceId=deviceId;
        this.deviceState.put("Status","OFF");
    }
    @Override
    public  void increase() throws  Exception
    {
        if(this.deviceState.get("Status").equals("OFF") )
            throw new Exception("Device is OFF.Command will not be executed");
        if(this.deviceState.get("Status").equals("ON") )
            throw new Exception("Device is OFF.Command will not be executed");
        if(this.currTemp== this.maxTemp)
            throw new Exception("Fridge Already at Max Temprature");
        else {
            this.currTemp = currTemp + 1;
            System.out.println(String.format("Fridge Temp Increased to %d", currTemp));
        }

    }
    @Override
    public  void decrease() throws  Exception
    {
        if(this.deviceState.get("Status").equals("OFF") )
            throw new Exception("Device is OFF.Command will not be executed");
        if(this.deviceState.get("Status").equals("ON") )
            throw new Exception("Device is OFF.Command will not be executed");
        if(this.currTemp== this.minTemp)
            throw new Exception("Fridge Already at Min Temprature");
        else {
            this.currTemp = currTemp - 1;
            System.out.println(String.format("Fridge Temp Decreased to %d", currTemp));
        }

    }
}
