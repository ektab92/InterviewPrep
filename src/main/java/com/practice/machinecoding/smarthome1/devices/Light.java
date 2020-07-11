package com.practice.machinecoding.smarthome1.devices;

public class Light extends Devices{
    public Light()
    {

    }
    @Override
    public void increaseSpeed() throws Exception {
        throw new Exception("Unsupported operation");
    }

    @Override
    public void decreaseSpeed() throws Exception{
        throw new Exception("Unsupported operation");

    }
}
