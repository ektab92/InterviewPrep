package com.practice.ds.amazon.arrays;

import java.util.Arrays;

public class zigZagArray {
    private void doZigZag(int arr[])
    {
        int i =1;
        while(i<arr.length)
        {
            if(arr[i-1] > arr[i])
            {
                if(arr[i-1]>arr[i+1])
                {
                    int temp = arr[i];
                    arr[i]=arr[i-1];
                    arr[i-1]=temp;
                }
                else if(arr[i-1]<arr[i+1])
                {
                    int temp = arr[i+1];
                    arr[i+1] =arr[i];
                    arr[i]=temp;

                }
            }else if(arr[i-1]<arr[i])
            {
                if(arr[i+1]>arr[i])
                {
                    int temp = arr[i+1];
                    arr[i+1]=arr[i];
                    arr[i] = temp;
                }
            }
            i=i+2;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int arr[]={4, 3, 7, 8, 6, 2, 1};
        zigZagArray arrOps = new zigZagArray();
        arrOps.doZigZag(arr);
    }
}
