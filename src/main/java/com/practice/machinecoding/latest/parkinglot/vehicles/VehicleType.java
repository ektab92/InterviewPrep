package com.practice.machinecoding.latest.parkinglot.vehicles;

public enum VehicleType {
    TWO_WHEELER,
    FOUR_WHEELER,
    EIGHT_WHEELER;
    public static VehicleType getVehicleType(String vType)
    {
        for(VehicleType vecType:VehicleType.values())
        {
            if(vecType.name().equals(vType))
            {
                return vecType;
            }
        }
        return null;
    }
}
