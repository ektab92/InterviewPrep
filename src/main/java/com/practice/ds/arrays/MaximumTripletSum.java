package com.practice.ds.arrays;

import java.util.*;
/*
    1. Prepare Suffix Arr, that is SuffixArr[i], is greatest val on right of i
    2. Sorted Set to keep sorted values before arr[i]
 */

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
           sortedSet.add(arr[i]);
           sortedArr = sortedSet.toArray(new Integer[0]);
           //sortedSet.
           int justLessVal = binarySearch(sortedArr, arr[i]);
           //System.out.println(justLessVal);
           if(justLessVal!=-1)
           {
               maximalSum=Math.max(maximalSum,arr[i]+arr[justLessVal]+suffixArr[i+1]);
           }
        }
        System.out.println(maximalSum);
    }
    private static int binarySearch(Integer[] arr, int target)
    {
        int start = 0, end = arr.length-1;

        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;

            // Move to the left side if the target is smaller
            if (arr[mid] >= target) {
                end = mid - 1;
            }

            // Move right side
            else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int [] arr={2,5,3,1,4,9};
        findTripletSum(arr);
    }
}
