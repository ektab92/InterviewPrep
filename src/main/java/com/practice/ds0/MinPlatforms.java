package com.practice.ds0;

import java.util.Arrays;

public class MinPlatforms {
    public static void findPlatform(int arr[],int dep[])
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int a =0,d=0;
        int N = arr.length;
        int platformCount=0;
        int resultCount=0;
        while(a<N && d<N)
        {
            if(platformCount>resultCount)
                resultCount=platformCount;
            if(arr[a]<=dep[d])
            {
                a++;
                platformCount++;
            }
            else
            {
                d++;
                platformCount--;
            }
        }
        System.out.println("Minimum platforms : "+resultCount);
    }
    public static void main(String[] args) {
        int arr[]= {900,940,950,1100,1500,1800,750,0300};
        int dep[]= {910,1120,1130,1200,1900,2000,1400,0100};
        findPlatform(arr,dep);
    }
}
