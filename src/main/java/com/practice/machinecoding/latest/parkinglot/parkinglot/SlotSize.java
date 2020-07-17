package com.practice.machinecoding.latest.parkinglot.parkinglot;

public enum SlotSize {
    SMALL,
    MEDIUM,
    LARGE;
    public static SlotSize getSlotSize(String size)
    {
        for(SlotSize s : SlotSize.values())
        {
            if(s.name().equals(size))
                return s;
        }
        return null;
    }
}

