package com.practice.ds0;

import java.util.Arrays;

public class PairSumCloseToZero {
    public static void findpairSum(int [] arr)
    {
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length -1;
        int val1 =i;
        int val2 =j;
        int mindiff =((arr[i]+arr[j])-0);
        while(i<j)
        {
            int diff =((arr[i]+arr[j])-0);
            if(Math.abs(diff)<Math.abs(mindiff)) {
                mindiff = Math.min(Math.abs(diff), Math.abs(mindiff));
                val1 = i;
                val2 = j;
            }
            if(diff>0)
            {
                j--;
            }
            else
                i++;

        }
        System.out.println("value 1 :"+arr[val1]+" value 2 :"+arr[val2]);
    }
    public static void main(String[] args) {
        int arr[]={1,60,10,70,80,85};
        //int arr[]= {1,2,-1,4,-5,11,2};
        findpairSum(arr);
    }
}
