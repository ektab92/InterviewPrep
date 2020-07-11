package com.practice.machinecoding.smarthome1;

import java.util.*;

import com.practice.machinecoding.smarthome1.devices.Devices;
import com.practice.machinecoding.smarthome1.devices.DevicesTypes;

public class SmartDevices {
    public Map<String, Devices>deviceIdObjectMap = new HashMap<>();
    public SmartDevices()
    {

    }
    public void controlDevices (Operations operation, String deviceId) throws Exception {
        if(!deviceIdObjectMap.containsKey(deviceId))
            throw new Exception("Device not found");
        Devices deviceObj=deviceIdObjectMap.get(deviceId);
        switch(operation)
        {
            case ON:
                deviceObj.switchOn();
                break;
            case OFF:
                deviceObj.switchOff();
                break;
            case INC_SPEED:
                deviceObj.increaseSpeed();
                break;
            case DEC_SPEED:
                deviceObj.decreaseSpeed();
                break;
        }

    }
}
