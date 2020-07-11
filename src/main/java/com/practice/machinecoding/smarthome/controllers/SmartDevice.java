package com.practice.machinecoding.smarthome.controllers;

import com.practice.machinecoding.smarthome.SupportedOps;
import com.practice.machinecoding.smarthome.devices.Device;

import java.util.*;

public abstract class SmartDevice {
    protected int smartDeviceId;
    protected Map<Integer,Device>controlledDevices = new HashMap<>();

    public Map<Integer, Device> getControlledDevices() {
        return controlledDevices;
    }

    public void executeCommand(SupportedOps operation, int deviceId) throws Exception {
        Device device = controlledDevices.get(deviceId);
        if(device == null)
            throw new Exception ("This device is not controlled by Google Home");
        else
        {
            if(operation == SupportedOps.ON)
            {
                device.switchOn(deviceId);
            }
            else if(operation == SupportedOps.OFF)
            {
                device.switchOff(deviceId);
            }
            else if (operation == SupportedOps.INC)
            {
                device.increase();
            }
            else if (operation == SupportedOps.DEC)
            {
                device.decrease();
            }
        }
    }
}
