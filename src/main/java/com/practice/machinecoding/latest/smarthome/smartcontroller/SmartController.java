package com.practice.machinecoding.latest.smarthome.smartcontroller;

import com.practice.machinecoding.latest.smarthome.DeviceOperations;
import com.practice.machinecoding.latest.smarthome.controlleddevices.Device;
import com.practice.machinecoding.latest.smarthome.controlleddevices.DeviceFactory;
import com.practice.machinecoding.latest.smarthome.controlleddevices.DeviceTypes;

import java.util.*;

public class SmartController  {
    String controllerId;
    String currState;
    private Map<String, Device> deviceObjMap ;

    public SmartController(String c_id)
    {
        this.controllerId=c_id;
        this.currState="OFF";
        this.deviceObjMap=new HashMap<>();
    }
    public void switchOnController() throws Exception
    {
        if(this.currState.equals("OFF"))
        {
            this.currState="ON";
            System.out.println(String.format("%s is switched On at your Service",this.controllerId));
        }
        else
            throw new Exception(String.format("%s is already On",this.controllerId));
    }

    public void addDeviceToController(DeviceTypes type,String deviceId)
    {
        Device device = DeviceFactory.getdevice(type,deviceId);
        deviceObjMap.put(deviceId,device);
        System.out.println(String.format("%s added to Contoller %s",deviceId,this.controllerId));
    }
    public void executeCommand(DeviceOperations op, String device) throws Exception {
        Device deviceObj = deviceObjMap.get(device);
        switch (op) {
            case ON:
                deviceObj.switchOn();
                break;
            case OFF:
                deviceObj.switchOff();
                break;
            case DEC:
                deviceObj.decrease();
                break;
            case INC:
                deviceObj.increase();
                break;
        }
    }
    public void removeDeviceToController(DeviceTypes type,String deviceId)
    {
        deviceObjMap.remove(deviceId);
        System.out.println(String.format("%s removed from Contoller %s",deviceId,this.controllerId));
    }
    public void getControlledDevices()
    {
        System.out.println(String.format("devices controlled by %s are %s",this.controllerId,deviceObjMap.keySet().toString()));
    }

}
