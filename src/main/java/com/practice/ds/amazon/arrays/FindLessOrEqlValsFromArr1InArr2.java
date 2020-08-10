package com.practice.ds.amazon.arrays;

import java.util.Arrays;

public class FindLessOrEqlValsFromArr1InArr2 {
    //1,2,3,4,7,9
    //0,1,1,1,2,4
    private void findLessOrEqElem(int arr1[],int arr2[])
    {
        Arrays.sort(arr2);
        int [] result = new int[arr1.length];
        for(int i=0;i<arr1.length;i++)
        {
           int index= search(arr1[i],arr2);
           result[i]=index;
        }
        System.out.println(Arrays.toString(result));
    }
    private int search(int target,int []arr)
    {
        int lo =0;
        int hi = arr.length-1;
        while(lo<=hi)
        {
            int mid = lo+(hi-lo)/2;
            if(arr[mid]<=target)
            {
                lo = mid+1;
            }
            else
                hi = mid-1;
        }
        return hi;

    }
    public static void main(String[] args) {
        int arr1[] = {1,2,3,4,7,9};
        int arr2[] = {0,1,2,1,1,4};
        FindLessOrEqlValsFromArr1InArr2 arrOps = new FindLessOrEqlValsFromArr1InArr2();
        arrOps.findLessOrEqElem(arr1,arr2);
    }
}
