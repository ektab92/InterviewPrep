package com.practice.machinecoding.parkinglot;
import java.util.*;
public class ParkingLot {
    int size;
    private Set<Integer> emptyLots = new TreeSet<>();
    private Map<Integer,Vehicle>LotVehicleMap = new HashMap<>();
    private Map<String,Integer>VehicleLotMap = new HashMap<>();
    private Map<String, Set<Integer>> colorLotIdMap = new HashMap<String, Set<Integer>>();


    public Map<String, Integer> getVehicleLotMap() {
        return VehicleLotMap;
    }

    public void setVehicleLotMap(Map<String, Integer> vehicleLotMap) {
        VehicleLotMap = vehicleLotMap;
    }

    public Set<Integer> getEmptyLots() {
        return emptyLots;
    }

    public void setEmptyLots(Set<Integer> emptyLots) {
        this.emptyLots = emptyLots;
    }

    public Map<Integer, Vehicle> getLotVehicleMap() {
        return LotVehicleMap;
    }

    public void setLotVehicleMap(Map<Integer, Vehicle> lotVehicleMap) {
        LotVehicleMap = lotVehicleMap;
    }

    public Map<String, Set<Integer>> getColorLotIdMap() {
        return colorLotIdMap;
    }

    public void setColorLotIdMap(Map<String, Set<Integer>> colorLotIdMap) {
        this.colorLotIdMap = colorLotIdMap;
    }


    ParkingLot(int size)
    {
        this.size = size;
        for(int i=1;i<=size;i++)
        {
            emptyLots.add(i);
        }
    }
}
