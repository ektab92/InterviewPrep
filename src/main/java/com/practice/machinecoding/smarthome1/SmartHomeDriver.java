package com.practice.machinecoding.smarthome1;

import com.practice.machinecoding.smarthome1.devices.DeviceFactory;
import com.practice.machinecoding.smarthome1.devices.Devices;
import com.practice.machinecoding.smarthome1.devices.DevicesTypes;

import java.util.*;

public class SmartHomeDriver {
    Map<String, SmartDevices>controllerIdObjMap = new HashMap<>();
    SmartHomeDriver()
    {

    }
    public void addSmartController(String controllerId) throws Exception
    {
        if(controllerIdObjMap.containsKey(controllerId))
            throw new Exception("smart device already exists");
        controllerIdObjMap.put(controllerId,new SmartDevices());
    }
    public void addDevice(String controllerId, String deviceId,Devices d) throws Exception
    {
        if(!controllerIdObjMap.containsKey(controllerId))
            throw new Exception("smart device not exists");
        SmartDevices Obj =controllerIdObjMap.get(controllerId);
        Obj.deviceIdObjectMap.put(deviceId,d);
    }
    public void sendCommand(String controllersId, Operations operations,String deviceId) throws Exception
    {
        if(!controllerIdObjMap.containsKey(controllersId))
            throw new Exception("smart device not exists");
        SmartDevices Obj =controllerIdObjMap.get(controllersId);
        Obj.controlDevices(operations,deviceId);
    }

    public static void main(String[] args) throws  Exception {
        SmartHomeDriver driver = new SmartHomeDriver();
        driver.addSmartController("ALEXA");

        Devices fan1 = DeviceFactory.getDevice(DevicesTypes.FAN);
        fan1.setDeviceId("Fan1");
        driver.addDevice("ALEXA","Fan1",fan1);
        driver.sendCommand("ALEXA",Operations.ON,fan1.getDeviceId());
        driver.sendCommand("ALEXA",Operations.INC_SPEED,fan1.getDeviceId());
        driver.sendCommand("ALEXA",Operations.INC_SPEED,fan1.getDeviceId());
        driver.sendCommand("ALEXA",Operations.INC_SPEED,fan1.getDeviceId());
        driver.sendCommand("ALEXA",Operations.OFF,fan1.getDeviceId());
        driver.sendCommand("ALEXA",Operations.INC_SPEED,fan1.getDeviceId());
        //driver.sendCommand("ALEXA",Operations.INC_SPEED,fan1.getDeviceId());
    }
}
