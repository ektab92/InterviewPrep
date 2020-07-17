package com.practice.machinecoding.latest.parkinglot;

import com.practice.machinecoding.latest.parkinglot.parkinglot.Slot;
import com.practice.machinecoding.latest.parkinglot.parkinglot.SlotSize;
import com.practice.machinecoding.latest.parkinglot.vehicles.Vehicle;
import com.practice.machinecoding.latest.parkinglot.vehicles.VehicleType;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ParkingLotManager {
    Map<Integer, Slot> slotObjMap = new HashMap<>();
    PriorityQueue<Slot> minHeapSlotSmall = new PriorityQueue<>();
    PriorityQueue<Slot> minHeapSlotMid = new PriorityQueue<>();
    PriorityQueue<Slot> minHeapSlotLarge = new PriorityQueue<>();
    Map<String,Integer> regNoSlotIDMap = new HashMap<>();

    public void addSlot(int slotID, int level,SlotSize size)
    {
        Slot slot = new Slot(slotID,  size,level);
        slotObjMap.put(slotID,slot);
        switch(size)
        {
            case SMALL:
                minHeapSlotSmall.add(slot);
                break;
            case MEDIUM:
                minHeapSlotMid.add(slot);
                break;
            case LARGE:
                minHeapSlotLarge.add(slot);
                break;
            default:
                System.out.println("slot size not supported");
        }
        System.out.println(String.format("%d slot of size %s added at level %d",slotID,size.name(),level));
    }

    public void parkVehicle(String regNo, VehicleType vType)
    {
        Vehicle vehicle = new Vehicle(regNo,vType);
        Slot s = null;
        if(vType == VehicleType.TWO_WHEELER)
        {
            if(!minHeapSlotSmall.isEmpty())
            {
                s= minHeapSlotSmall.remove();
                s.vehicle=vehicle;
                regNoSlotIDMap.put(regNo,s.slotId);
            }
            else
                System.out.println("No Slot available for 2 wheeler");
        }

       else if(vType == VehicleType.FOUR_WHEELER)
        {
            if(!minHeapSlotMid.isEmpty())
            {
                s= minHeapSlotMid.remove();
                s.vehicle=vehicle;
                regNoSlotIDMap.put(regNo,s.slotId);
            }
            else
                System.out.println("No Slot available for 4 wheeler");
        }
       else if(vType == VehicleType.EIGHT_WHEELER)
        {
            if(!minHeapSlotLarge.isEmpty())
            {
                s= minHeapSlotLarge.remove();
                s.vehicle=vehicle;
                regNoSlotIDMap.put(regNo,s.slotId);
            }
            else
                System.out.println("No Slot available for 8 wheeler");
        }
       else
           throw new RuntimeException("Vehicle Type not supported");
        System.out.println(String.format("Vehicle %s parked at Slot %d",regNo,s.slotId));
    }
    public void unParkVehicle(String regNo)
    {
        int sId = regNoSlotIDMap.get(regNo);
        Slot slotObj =slotObjMap.get(sId);
        if(slotObj.size == SlotSize.SMALL)
        {
            minHeapSlotSmall.add(slotObj);
        }
        else if(slotObj.size == SlotSize.MEDIUM)
        {
            minHeapSlotMid.add(slotObj);
        }
        else if(slotObj.size == SlotSize.LARGE)
        {
            minHeapSlotLarge.add(slotObj);
        }
        regNoSlotIDMap.remove(regNo);
        slotObj.vehicle=null;
        System.out.println(String.format("Vehicle %s unparked from Slot %d",regNo,sId));

    }

    public static void main(String[] args) throws InterruptedException {
        ParkingLotManager lotManager = new ParkingLotManager();
        System.out.println("**************Welcome to Ekta's parking lot****************");
        System.out.println("Lets create the parking lot");
        Thread.sleep(1000);
        System.out.println("Please provide total Number of slots ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int noOfSlots = Integer.parseInt(br.readLine().trim());
            for(int i =0;i< noOfSlots;i++)
            {
                String text[]=br.readLine().split("\\s+");
                lotManager.addSlot(Integer.parseInt(text[0].trim()),Integer.parseInt(text[1].trim()),SlotSize.getSlotSize(text[2].trim()));
            }

            while(true)
            {
                System.out.println("Enter your input");
                String text[] =br.readLine().split("\\s+");
                if(text[0].equalsIgnoreCase("park"))
                {
                    lotManager.parkVehicle(text[1].trim(),VehicleType.getVehicleType(text[2].trim()));
                }
                else if (text[0].equalsIgnoreCase("unpark"))
                {
                    lotManager.unParkVehicle(text[1].trim());
                }
                else
                    System.out.println("unsupported operation");
            }
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
