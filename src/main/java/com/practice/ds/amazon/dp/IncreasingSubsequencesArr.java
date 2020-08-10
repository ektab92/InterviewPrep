package com.practice.ds.amazon.dp;

import java.util.Arrays;

public class IncreasingSubsequencesArr {
    //also printing array elements in both cases
    private int findIncreasingSqnce(int [] arr)
    {
        int dp[] = new int [arr.length];
        Arrays.fill(dp,1);
        int path[] = new int [arr.length];
        Arrays.fill(path,-1);
        for(int i =1;i<arr.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[i]>arr[j])
                {
                    if(dp[i]<dp[j]+1)
                    {
                        dp[i]=dp[j]+1;
                        path[i]=j;
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        int maxIndex =-1;
        for(int i =0;i<dp.length;i++)
        {
            if(dp[i]>max)
            {
                max = dp[i];
                maxIndex=i;
            }
        }
        while(maxIndex>=0)
        {
            System.out.println(arr[maxIndex]);
            maxIndex = path[maxIndex];
        }
        System.out.println("max Length of inreasing sequence : "+max);
        return max;
    }
    private int findMaxSumIncresingSqnce(int [] arr)
    {
        int []increasingSum = new int [arr.length];
        for(int i =0;i< arr.length;i++)
            increasingSum[i]=arr[i];
        int []path = new int [arr.length];
        Arrays.fill(path,-1);
        for(int i =1;i<arr.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[i]>arr[j]) {
                    if (increasingSum[i] < increasingSum[j] + arr[i])
                    {
                        increasingSum[i] = increasingSum[j] + arr[i];
                        path[i]=j;
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        int maxIndex=-1;
        for(int i=0;i< increasingSum.length;i++)
        {
            if(max<increasingSum[i])
            {
                max=increasingSum[i];
                maxIndex=i;
            }
        }
        while(maxIndex>=0)
        {
            System.out.println(arr[maxIndex]);
            maxIndex= path[maxIndex];
        }
        System.out.println("max sum of increasing subsequence is : "+max);
        return 0;
    }
    public static void main(String[] args) {
        int arr[] ={1,101,2,3,100,4,5};
        IncreasingSubsequencesArr sqnceProblems = new IncreasingSubsequencesArr();
        //sqnceProblems.findIncreasingSqnce(arr);
        sqnceProblems.findMaxSumIncresingSqnce(arr);
    }
}
