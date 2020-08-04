package com.practice.ds.arrays;

import java.util.*;

public class MaximumTripletSum {
    private static void findTripletSum(int[] arr)
    {
        int [] suffixArr = new int[arr.length];
        Set<Integer>sortedSet = new TreeSet<Integer>();
        int N = arr.length;
        int maximalSum=0;
        suffixArr[N-1]=arr[N-1];
        for(int i =N-2;i>=0;i--)
        {
            suffixArr[i]=Math.max(suffixArr[i+1],arr[i]);
        }
        sortedSet.add(arr[0]);
        Integer []sortedArr;
        for(int i=1;i<N-1;i++)
        {
           sortedArr = sortedSet.toArray(new Integer[0]);
           //sortedSet.
           int justLessVal = binarySearch(sortedArr,0, sortedArr.length-1, arr[i]);
           //System.out.println(justLessVal);
           if(justLessVal!=-1)
           {
               maximalSum=Math.max(maximalSum,arr[i]+justLessVal+suffixArr[i+1]);
           }
        }
        System.out.println(maximalSum);
    }
    private static int binarySearch(Integer[] arr, int lo, int hi, int target)
    {
        if(lo>hi) return -1;
        int mid=lo+(hi-lo)/2;
        if(lo==hi && target>arr[lo])
        {
            return arr[lo];
        }
        if(lo==hi && target<arr[lo])
        {
            return -1;
        }
        if(arr[mid]>target)
        {
           return binarySearch(arr,lo,mid-1,target);
        }
        else
        {
           return binarySearch(arr,mid,hi,target);
        }

    }
    public static void main(String[] args) {
        int [] arr={2,5,3,1,4,9};
        findTripletSum(arr);
    }
}
