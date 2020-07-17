package com.practice.machinecoding.latest.smarthome;

import com.practice.machinecoding.latest.smarthome.controlleddevices.DeviceTypes;
import com.practice.machinecoding.latest.smarthome.smartcontroller.SmartController;
import java.util.*;
public class SmartHomeDriver {
    Map<String, SmartController> controllerMap = new HashMap<>();

    public void addController(String controllerId)
    {
        SmartController controller = new SmartController(controllerId);
        controllerMap.put(controllerId,controller);
        System.out.println(String.format("%s added to home",controllerId));
    }

    public void removeController(String controllerId)
    {
        controllerMap.remove(controllerId);
        System.out.println(String.format("%s removed to home",controllerId));
    }

    public void delegateCommand(String c_id, String deviceId,DeviceOperations op) throws Exception
    {

        controllerMap.get(c_id).executeCommand(op,deviceId);
    }

    public static void main(String[] args) throws Exception {
        SmartHomeDriver homeDriver = new SmartHomeDriver();
        homeDriver.addController("ALEXA");
        homeDriver.addController("GOOGLE");

        SmartController alexa=homeDriver.controllerMap.get("ALEXA");
        SmartController google=homeDriver.controllerMap.get("GOOGLE");

        alexa.switchOnController();
        google.switchOnController();

        alexa.addDeviceToController(DeviceTypes.AC,"AC1");
        alexa.addDeviceToController(DeviceTypes.FAN,"FAN1");
        google.addDeviceToController(DeviceTypes.AC,"AC2");
        google.addDeviceToController(DeviceTypes.LIGHT,"LIGHT1");


        homeDriver.delegateCommand("ALEXA","FAN1",DeviceOperations.ON);
        homeDriver.delegateCommand("GOOGLE","LIGHT1",DeviceOperations.ON);
        homeDriver.delegateCommand("ALEXA","AC1",DeviceOperations.ON);
        homeDriver.delegateCommand("ALEXA","AC1",DeviceOperations.INC);
        homeDriver.delegateCommand("ALEXA","AC1",DeviceOperations.DEC);
        homeDriver.delegateCommand("ALEXA","AC1",DeviceOperations.DEC);
        alexa.getControlledDevices();

    }
}
