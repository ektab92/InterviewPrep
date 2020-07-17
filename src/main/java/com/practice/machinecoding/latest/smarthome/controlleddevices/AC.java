package com.practice.machinecoding.latest.smarthome.controlleddevices;

public class AC extends Device {

    int currTemp;
    int minTemp;
    int maxTemp;
    public AC(String id)
    {
        super(id);
        this.currTemp=17;
        this.minTemp=17;
        this.maxTemp=35;
    }

    @Override
    public void increase() throws Exception
    {
        if(this.currState .equals( "OFF"))
            throw new Exception("AC is not on.Please switch on AC");
        if(this.currTemp == this.maxTemp)
            throw new Exception("AC is already at maximum Temperature");
        else
        {
            this.currTemp++;
            System.out.println(String.format("AC Tempreture increased to %d",currTemp));
        }
    }

    @Override
    public void decrease() throws Exception
    {
        if(this.currState .equals( "OFF"))
            throw new Exception("AC is not on.Please switch on AC");
        if(this.currTemp == this.minTemp)
            throw new Exception("AC is already at minimum Temperature");
        else
        {
            this.currTemp--;
            System.out.println(String.format("AC Tempreture decreased to %d",currTemp));
        }
    }
}
