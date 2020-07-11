package com.practice.machinecoding.smarthome.controllers;

public class ControllerFactory {
    //Enum for Devices supported
    public static enum ControllerTypes
    {
        ALEXA,
        GOOGLE_HOME,
        SIRI;
    };
    public static SmartDevice getController(ControllerTypes type)  {
        switch (type)
        {
            case ALEXA:
                return new Alexa();
            case GOOGLE_HOME:
                return new GoogleHome();
            default:
                return null;
        }
    }
}
