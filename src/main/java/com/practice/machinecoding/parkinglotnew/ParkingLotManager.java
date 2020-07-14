package com.practice.machinecoding.parkinglotnew;

import com.practice.machinecoding.parkinglotnew.ParkingLot.Slot;
import com.practice.machinecoding.parkinglotnew.ParkingLot.SlotSize;
import com.practice.machinecoding.parkinglotnew.vehicle.Vehicle;
import com.practice.machinecoding.parkinglotnew.vehicle.VehicleType;

import java.util.*;
public class ParkingLotManager {
    Map<Integer, Slot>slotMap = new HashMap<>();
    Map<String,Integer>regNoSlotMap = new HashMap<>();
    Set<Integer>EmptySlotSmall = new HashSet<>();
    Set<Integer>EmptySlotMid = new HashSet<>();
    Set<Integer>EmptySlotLarge = new HashSet<>();
    Set<Integer>EmptySlotXLarge = new HashSet<>();

    public int parkVehicle( Vehicle vehicle) throws Exception
    {
        VehicleType vehicleType = vehicle.type ;
        int slotId=0;
        switch (vehicleType)
        {
            case TWO_WHEELER:
                {
                    if(!EmptySlotMid.isEmpty()) {
                        slotId = EmptySlotMid.iterator().next();
                        slotMap.get(slotId).vehicle=vehicle;
                        regNoSlotMap.put(vehicle.regNo, slotId);
                        EmptySlotMid.remove(slotId);
                        break;
                    }
                    else
                        throw new Exception("No Slot Empty for Two Wheeler");
                }
            case FOUR_WHEELER:
                {
                    if(!EmptySlotLarge.isEmpty()) {
                        slotId = EmptySlotLarge.iterator().next();
                        slotMap.get(slotId).vehicle=vehicle;
                        regNoSlotMap.put(vehicle.regNo, slotId);
                        EmptySlotLarge.remove(slotId);
                        break;
                    }
                    else
                    {
                        throw new Exception("No Slot Empty for Four Wheeler");
                    }
                }
            case EIGHT_WHEELER:
                {
                    if(!EmptySlotXLarge.isEmpty()) {
                        slotId = EmptySlotXLarge.iterator().next();
                        slotMap.get(slotId).vehicle=vehicle;
                        regNoSlotMap.put(vehicle.regNo, slotId);
                        EmptySlotXLarge.remove(slotId);
                        break;
                    }
                    else
                    {
                        throw new Exception("No Slot Empty for Eight Wheeler");
                    }
                }
            default:
                return -1;

        }
        return slotId;
    }

    public void unparkVehicle(String regNo ) throws Exception {
        int slotId=0;
        if(regNoSlotMap.containsKey(regNo)) {
            slotId = regNoSlotMap.get(regNo);
            VehicleType type = slotMap.get(slotId).vehicle.type;
            slotMap.get(slotId).vehicle=null;
            regNoSlotMap.remove(regNo);
            if (type == VehicleType.TWO_WHEELER) {
                EmptySlotMid.add(slotId);

            } else if (type == VehicleType.FOUR_WHEELER) {
                EmptySlotLarge.add(slotId);
            } else if (type == VehicleType.EIGHT_WHEELER) {
                EmptySlotXLarge.add(slotId);
            } else {
                System.out.println("Unable to find Vehicle");
            }
        }
        else
        {
            throw  new Exception(String.format("No Vehicle with %s Registration Number is parked in lot",regNo));
        }
        System.out.println(String.format("Unparked Vehicle %s from slot %d",regNo,slotId));
    }
    public void addSlot(int slotId, SlotSize size)
    {
        Slot newSlot = new Slot(size,slotId,null);
        slotMap.put(slotId,newSlot);
        switch (size)
        {
            case MID:
                EmptySlotMid.add(slotId);
                break;
            case LARGE:
                EmptySlotLarge.add(slotId);
                break;
            case XLARGE:
                EmptySlotXLarge.add(slotId);
                break;
            default:

        }
    }
    public int getVehicleParkingDetail(String regNo)
    {
        return regNoSlotMap.get(regNo);
    }
    public void printParkingLotStatus()
    {
        for(int slotid:slotMap.keySet())
        {
            if(slotMap.get(slotid).vehicle != null)
                System.out.println(slotid+" : "+slotMap.get(slotid).vehicle.regNo);
        }
    }

    public static void main(String[] args) throws Exception {
        ParkingLotManager parkingLotManager = new ParkingLotManager();
        //MID- 4 , Large -3 XL-2
        parkingLotManager.addSlot(1,SlotSize.MID);
        parkingLotManager.addSlot(2,SlotSize.LARGE);
        parkingLotManager.addSlot(3,SlotSize.XLARGE);
        parkingLotManager.addSlot(4,SlotSize.MID);
        parkingLotManager.addSlot(5,SlotSize.LARGE);
        parkingLotManager.addSlot(6,SlotSize.XLARGE);
        parkingLotManager.addSlot(7,SlotSize.MID);
        parkingLotManager.addSlot(8,SlotSize.MID);
        parkingLotManager.addSlot(9,SlotSize.LARGE);
        //4W -4, 2W -3, 8W-3
        Vehicle v1 = new Vehicle("ABV-XX1888",VehicleType.FOUR_WHEELER);
        Vehicle v2 = new Vehicle("BBV-XX2888",VehicleType.FOUR_WHEELER);
        Vehicle v3 = new Vehicle("CBV-XX3888",VehicleType.TWO_WHEELER);
        Vehicle v4 = new Vehicle("DBV-XX4888",VehicleType.EIGHT_WHEELER);
        Vehicle v5 = new Vehicle("EBV-XX5888",VehicleType.FOUR_WHEELER);
        Vehicle v6 = new Vehicle("FBV-XX6888",VehicleType.TWO_WHEELER);
        Vehicle v7 = new Vehicle("GBV-XX7888",VehicleType.TWO_WHEELER);
        Vehicle v8 = new Vehicle("HBV-XX8888",VehicleType.EIGHT_WHEELER);
        Vehicle v9 = new Vehicle("GBV-XX9888",VehicleType.FOUR_WHEELER);
        Vehicle v10 = new Vehicle("ABV-XX10888",VehicleType.EIGHT_WHEELER);


        int s1=parkingLotManager.parkVehicle(v1);
        System.out.println(String.format("Vehicle %s, parked at %d",v1.regNo,s1));
        int s2=parkingLotManager.parkVehicle(v2);
        System.out.println(String.format("Vehicle %s, parked at %d",v2.regNo,s2));
        int s3=parkingLotManager.parkVehicle(v3);
        System.out.println(String.format("Vehicle %s, parked at %d",v3.regNo,s3));
        int s4=parkingLotManager.parkVehicle(v4);
        System.out.println(String.format("Vehicle %s, parked at %d",v4.regNo,s4));
        int s5=parkingLotManager.parkVehicle(v5);
        System.out.println(String.format("Vehicle %s, parked at %d",v5.regNo,s5));

        int s6=parkingLotManager.parkVehicle(v8);
        System.out.println(String.format("Vehicle %s, parked at %d",v8.regNo,s6));

        parkingLotManager.unparkVehicle(v4.regNo);
        int s7=parkingLotManager.parkVehicle(v10);
        System.out.println(String.format("Vehicle %s, parked at %d",v10.regNo,s7));

        int s8=parkingLotManager.parkVehicle(v6);
        System.out.println(String.format("Vehicle %s, parked at %d",v6.regNo,s8));

        int s9=parkingLotManager.parkVehicle(v7);
        System.out.println(String.format("Vehicle %s, parked at %d",v7.regNo,s9));

        parkingLotManager.unparkVehicle(v5.regNo);
        int s10=parkingLotManager.parkVehicle(v9);
        System.out.println(String.format("Vehicle %s, parked at %d",v9.regNo,s10));
        parkingLotManager.printParkingLotStatus();


    }
}
