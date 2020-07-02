package com.practice.ds0;

import java.util.Arrays;

//1,18,7,5,3,6,8,2,4,11
//
public class LongestIncreasingSubSequence {
    public static int[] increasingsequence(int [] arr)
    {
        int i=1;
        int L=arr.length;
        int lengthArr[] = new int[L];
        int path[] = new int[L];
        Arrays.fill(path,-1);
        Arrays.fill(lengthArr,1);
        for(;i<L;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[i]>arr[j])
                {
                    int prev=lengthArr[j]+1;
                    if(lengthArr[i]<prev)
                    {
                        lengthArr[i] = prev;
                        path[i]=j;
                    }
                }
            }
        }
        int max=Integer.MIN_VALUE;
        int m=0;
        for(int k=0;k<lengthArr.length;k++)
        {
            if(lengthArr[k]>max)
            {
                max = lengthArr[k];
                m=k;
            }
        }
        while(m>=0)
        {
            System.out.println(m);
            System.out.print(arr[m]+"-->");
            m=path[m];
        }
        System.out.println();
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(lengthArr));
        System.out.println(Arrays.toString(path));
        return lengthArr;
    }
    public static void main(String[] args) {
        int arr[]={1,18,7,5,3,6,8,2,4,11,-9,-3,-7,4};
        increasingsequence(arr);
    }
}
