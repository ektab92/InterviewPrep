package com.practice.machinecoding.hotelmanagement;

public enum AllocationPreference {
    TOP,
    BOTTOM,
    DEFAULT;
    public static AllocationPreference getAllocPref(String pref)
    {
        for(AllocationPreference p: AllocationPreference.values())
        {
            if(p.name().equalsIgnoreCase(pref))
                return p;
        }
        return null;
    }
}
