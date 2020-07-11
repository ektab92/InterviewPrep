package com.practice.machinecoding.smarthome.devices;

public class Light extends Device {
    public Light(){}
    public Light(int deviceId)
    {
        this.deviceId=deviceId;
        this.deviceState.put("Status","OFF");
    }

    @Override
    public void increase() throws Exception {
        throw  new Exception("Unsuuported Operation");
    }

    @Override
    public void decrease() throws Exception {
        throw  new Exception("Unsuuported Operation");
    }
}
