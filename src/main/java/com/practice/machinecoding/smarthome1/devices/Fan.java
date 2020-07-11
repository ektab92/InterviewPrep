package com.practice.machinecoding.smarthome1.devices;

import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;

public class Fan extends Devices {
    int currSpeed;
    int minSpeed;
    int maxSpeed;
    public Fan()
    {
        minSpeed=1;
        maxSpeed=5;
        currSpeed=0;
    }

    @Override
    public void increaseSpeed() throws Exception {
        if(currState == "OFF")
            throw new Exception("Fan is not ON.Cannot increase speed");
        if(currSpeed == maxSpeed)
            throw new Exception("Fan is already at max speed");
        else
        {
            currSpeed=currSpeed+1;
            System.out.println("Fan speed is increased");
        }
    }

    @Override
    public void decreaseSpeed() throws Exception {
        if(currState == "OFF")
            throw new Exception("Fan is not ON.Cannot increase speed");
        if(currSpeed == minSpeed)
            throw new Exception("Fan is already at min speed");
        else
        {
            currSpeed=currSpeed-1;
            System.out.println("Fan speed is decreased");
        }
    }

}
