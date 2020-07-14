package com.practice.machinecoding.parkinglotnew.ParkingLot;

import com.practice.machinecoding.parkinglotnew.vehicle.Vehicle;

public class Slot {
    SlotSize size;
    int SlotId;
    public Vehicle vehicle;
    public Slot(SlotSize size , int slotId, Vehicle v)
    {
        this.size=size;
        this.SlotId=slotId;
        this.vehicle=v;
    }
}
