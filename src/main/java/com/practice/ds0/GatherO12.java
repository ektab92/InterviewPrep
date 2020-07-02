package com.practice.ds0;

import java.util.Arrays;

public class GatherO12 {
    //Dutch national flag algorithm
    //can be done by two pointers
    //count of 0,1,2
    public static void gather012(int [] arr)
    {
        int lo = 0;
        int mid =0;
        int hi = arr.length -1;
        while(mid<=hi)
        {
            if(arr[mid] == 1)
            {
                mid++;
            }
            else if(arr[mid] == 0)
            {
                int temp = arr[lo];
                arr[lo] = arr[mid];
                arr[mid] = temp;
                lo++;
                mid++;
            }
            else if(arr[mid] == 2)
            {
                int temp = arr[hi];
                arr[hi] = arr[mid];
                arr[mid] = temp;
                hi--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int [] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        gather012(arr);

    }
}
