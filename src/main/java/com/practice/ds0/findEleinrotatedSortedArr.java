package com.practice.ds0;

import java.util.Arrays;

public class findEleinrotatedSortedArr {

    public static int findEle(int []arr,int n)
    {
        if (arr == null || arr.length == 0 )
            return -1;
        int pivot =findPivot(arr,0,arr.length-1);
        if(arr[pivot] == n)
            return pivot;
        else if (n> arr[arr.length-1])
            return binarysearch(arr,0,pivot-1,n);
        else return binarysearch(arr,pivot,arr.length-1,n);
    }
    public static int binarysearch(int arr[],int lo,int hi,int target)
    {
        if(lo<=hi)
        {
            int mid = lo +(hi-lo)/2;
            if(arr[mid] == target)
                return mid;
            if(arr[mid]> target)
                return binarysearch(arr,lo,mid-1,target);
            else
               return binarysearch(arr,mid+1,hi,target);

        }
        return -1;
    }
    public static int findPivot(int arr[],int lo,int hi)
    {
        if(lo== hi)
            return lo;
        int mid = lo +(hi-lo)/2;
        if(arr[mid]> arr[hi])
            return  findPivot(arr,mid+1,hi);
        else
            return  findPivot(arr,lo,mid);

    }
    public static void main(String[] args) {
        int [] arr= {4,5,6,1,2,3};
        System.out.println(Arrays.toString(arr));
        int index=findEle(arr,5);
        System.out.println("pivot is present at index: "+index);

    }
}
