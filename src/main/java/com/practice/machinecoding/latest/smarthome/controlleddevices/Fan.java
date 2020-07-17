package com.practice.machinecoding.latest.smarthome.controlleddevices;

public class Fan extends Device{
    int minSpeed;
    int maxSpeed;
    int currSpeed;
    Fan(String id) {
        super(id);
        this.minSpeed=1;
        this.currSpeed=1;
        this.maxSpeed=1;
    }

    @Override
    public void increase() throws Exception
    {
        if(this.currState .equals( "OFF"))
            throw new Exception("Fan is not on.Please switch on Fan");
        if(this.currSpeed == this.maxSpeed)
            throw new Exception("Fan is already at maximum speed");
        else
        {
            this.currSpeed++;
            System.out.println(String.format("Fan speed increased to %d",currSpeed));
        }
    }

    @Override
    public void decrease() throws Exception
    {
        if(this.currState .equals( "OFF"))
            throw new Exception("Fan is not on.Please switch on Fan");
        if(this.currSpeed == this.minSpeed)
            throw new Exception("Fan is already at min speed");
        else
        {
            this.currSpeed--;
            System.out.println(String.format("Fan speed decreased to %d",currSpeed));
        }
    }
}
