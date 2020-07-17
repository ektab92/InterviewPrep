package com.practice.machinecoding.latest.parkinglot.parkinglot;


import com.practice.machinecoding.latest.parkinglot.vehicles.Vehicle;

public class Slot implements Comparable<Slot> {
    public int slotId;
    public SlotSize size;
    public Vehicle vehicle;
    int level;
    @Override
    public int compareTo(Slot s)
    {
        if(this.level == s.level)
        {
            if(this.slotId == this.slotId)
                return 0;
            if(this.slotId>this.slotId)
                return 1;
            else
                return -1;
        }
        if(this.level>s.level)
            return 1;
        else
            return -1;
    }
    public Slot(int sloId,SlotSize size,int level)
    {
        this.slotId=sloId;
        this.size=size;
        this.level=level;
    }
}
