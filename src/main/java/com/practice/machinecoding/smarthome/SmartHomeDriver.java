package com.practice.machinecoding.smarthome;

import com.practice.machinecoding.smarthome.controllers.ControllerFactory;
import com.practice.machinecoding.smarthome.devices.Device;
import com.practice.machinecoding.smarthome.devices.DevicesFactory;

public class SmartHomeDriver {
    public static void main(String[] args) throws Exception {
        SmartHome smartHome = new SmartHome();
        // Register Controller
        smartHome.addSmartDevice("ALEXA", ControllerFactory.ControllerTypes.ALEXA);
        smartHome.addSmartDevice("GOOGLE", ControllerFactory.ControllerTypes.GOOGLE_HOME);

        // creating devices
        Device fan1 = DevicesFactory.getDevice(DevicesFactory.DeviceTypes.FAN);
        fan1.setDeviceId(1);
        Device fan2 = DevicesFactory.getDevice(DevicesFactory.DeviceTypes.FAN);
        fan2.setDeviceId(2);
        Device ac1 = DevicesFactory.getDevice(DevicesFactory.DeviceTypes.AC);
        ac1.setDeviceId(3);
        Device frg = DevicesFactory.getDevice(DevicesFactory.DeviceTypes.FRIDGE);
        frg.setDeviceId(4);
        Device lgt1 = DevicesFactory.getDevice(DevicesFactory.DeviceTypes.LIGHT);
        lgt1.setDeviceId(5);

        // register devices
        smartHome.addDevices("ALEXA",fan1);
        smartHome.addDevices("GOOGLE",fan2);
        smartHome.addDevices("ALEXA",ac1);
        smartHome.addDevices("ALEXA",frg);
        smartHome.addDevices("GOOGLE",lgt1);

        smartHome.sendCommand("ALEXA",SupportedOps.ON,fan1.getDeviceId());
    }
}
