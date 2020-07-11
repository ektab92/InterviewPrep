package com.practice.machinecoding.smarthome;

import java.util.*;

import com.practice.machinecoding.smarthome.controllers.ControllerFactory;
import com.practice.machinecoding.smarthome.controllers.SmartDevice;
import com.practice.machinecoding.smarthome.devices.Device;

public class SmartHome {
    Map<String, SmartDevice> controllersMap;

    public SmartHome()
    {
        controllersMap = new HashMap<>();
    }

    public void addSmartDevice(String id, ControllerFactory.ControllerTypes name)
    {
       SmartDevice device= ControllerFactory.getController(name);
       controllersMap.put(id,device);
    }

    public void addDevices(String controllerId, Device device){
        controllersMap.get(controllerId).getControlledDevices().put(device.getDeviceId(),device);
    }

    public void sendCommand(String controller,SupportedOps operation,int deviceId)
    {
        try {
            controllersMap.get(controller).executeCommand(operation,deviceId);
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }
}
