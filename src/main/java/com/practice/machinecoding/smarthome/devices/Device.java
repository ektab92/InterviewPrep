package com.practice.machinecoding.smarthome.devices;
import java.util.*;
public abstract class Device {
   protected int deviceId;
   public Map<String,String> deviceState = new HashMap<>();

   protected Device(){
      deviceState.put("Status", "OFF");
   }

   public void setDeviceId(int deviceId) {
      this.deviceId = deviceId;
   }

   public int getDeviceId() {
      return deviceId;
   }

   public void switchOn(int deviceId) throws Exception {
      if(deviceState.get("Status").equals("OFF"))
      {
         deviceState.put("Status", "ON");
         System.out.println(String.format("device %d started",deviceId));
      }
      else
         throw new Exception("The Device is already on");
   }
   public void switchOff(int deviceId) throws Exception
   {
      if(deviceState.get("Status").equals("ON"))
      {
         deviceState.put("Status", "OFF");
         System.out.println(String.format("device %d stopped",deviceId));
      }
      else
         throw new Exception("The Device is already OFF");
   }
   public abstract void increase() throws Exception;
   public abstract void decrease() throws Exception;



}
