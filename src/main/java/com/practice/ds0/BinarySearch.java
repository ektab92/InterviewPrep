package com.practice.ds0;

import java.util.Arrays;

public class BinarySearch {
    static int search(int arr[],int k,int lo,int hi)
    {
        int mid= (hi+lo)/2;
        if(arr[mid] == k)
            return mid;
        else if(arr[mid] > k){
            return search(arr,k,lo,mid-1);
        }
        else if(arr[mid] < k){
            return search(arr,k,mid+1,hi);

        }

            return -1;
    }
    public static void main(String[] args) {
        int arr[]={5,9,11,0,3,8,13,6,19,41};
        Arrays.sort(arr);
        int index= search(arr,13,0,arr.length-1);
        System.out.println("Index: "+ index);
    }
}
