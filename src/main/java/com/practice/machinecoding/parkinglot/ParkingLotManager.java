package com.practice.machinecoding.parkinglot;
import java.util.*;

public class ParkingLotManager {
    ParkingLot parkingLot;
    ParkingLotManager() {}

    public void createParkingLot(int size)
    {
        this.parkingLot =new ParkingLot(size);
    }
    public int parkVehicle(String vehicleId, String color)
    {
        if (parkingLot.getEmptyLots().size() == 0)
        {
            System.out.println("Parking Lot is full");
            return -1;
        }
        Vehicle vehicle = new Vehicle(vehicleId,color);
        int lotId = parkingLot.getEmptyLots().iterator().next();
        parkingLot.getLotVehicleMap().put(lotId,vehicle);
        parkingLot.getVehicleLotMap().put(vehicleId,lotId);
        parkingLot.getEmptyLots().remove(lotId);
        Set<Integer> lots=parkingLot.getColorLotIdMap().getOrDefault(color,new HashSet<>());
        lots.add(lotId);
        parkingLot.getColorLotIdMap().put(color,lots);
        return lotId;
    }
    public void unparkVehicle(String vehicleId)
    {
       int lotId= parkingLot.getVehicleLotMap().remove(vehicleId);
       String color = parkingLot.getLotVehicleMap().get(lotId).color;
       Set<Integer> vehicleIdList = parkingLot.getColorLotIdMap().get(color);
       vehicleIdList.remove(lotId);
       parkingLot.getLotVehicleMap().remove(lotId);
       parkingLot.getEmptyLots().add(lotId);
       System.out.println(String.format("Slot id %d is free",lotId));
    }

    public Set<Integer> getSlotIdsByColor(String color)
    {
        return parkingLot.getColorLotIdMap().get(color);
    }

    public List<String> getRegNoByColor(String color)
    {
        List<String>regNoList=new ArrayList<>();
        for(int slots:parkingLot.getLotVehicleMap().keySet())
        {
            Vehicle v = parkingLot.getLotVehicleMap().get(slots);
            if(v.color == color)
            {
                regNoList.add(v.reg_No);
            }
        }
        return regNoList;
    }

    public static void main(String[] args) {
        ParkingLotManager lotManager = new ParkingLotManager();
        lotManager.createParkingLot(6);
        int lotId=lotManager.parkVehicle("RJ123","white");
        System.out.println(String.format("vehicle %s color %s parked at %d","RJ123","white",lotId));
        lotId=lotManager.parkVehicle("RJ223","red");
        System.out.println(String.format("vehicle %s color %s parked at %d","RJ223","red",lotId));
        lotId=lotManager.parkVehicle("RJ323","green");
        System.out.println(String.format("vehicle %s color %s parked at %d","RJ323","green",lotId));
        lotId=lotManager.parkVehicle("RJ423","white");
        System.out.println(String.format("vehicle %s color %s parked at %d","RJ423","white",lotId));
        lotId=lotManager.parkVehicle("RJ523","green");
        System.out.println(String.format("vehicle %s color %s parked at %d","RJ523","green",lotId));
        lotId=lotManager.parkVehicle("RJ623","blue");
        System.out.println(String.format("vehicle %s color %s parked at %d","RJ623","blue",lotId));

        List<String>vehicles=lotManager.getRegNoByColor("white");
        System.out.println("white cars : "+vehicles);

        Set<Integer> slotIds = lotManager.getSlotIdsByColor("green");
        System.out.println("slots with green vehicle"+slotIds);

        lotId=lotManager.parkVehicle("RJ723","white");
        System.out.println(String.format("vehicle %s color %s parked at %d","RJ723","white",lotId));

        lotManager.unparkVehicle("RJ123");
        lotManager.unparkVehicle("RJ323");
        vehicles=lotManager.getRegNoByColor("white");
        System.out.println("white cars : "+vehicles);

        slotIds = lotManager.getSlotIdsByColor("green");
        System.out.println("slots with green vehicle"+slotIds);

    }
}
