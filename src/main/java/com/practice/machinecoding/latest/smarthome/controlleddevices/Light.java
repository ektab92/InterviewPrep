package com.practice.machinecoding.latest.smarthome.controlleddevices;

public class Light extends Device{
    public Light(String id) {
        super(id);
    }

    @Override
    public void increase() throws Exception
    {
            throw new Exception("Unsupported operation");
    }

    @Override
    public void decrease() throws Exception
    {
        throw new Exception("Unsupported operation");
    }
}
