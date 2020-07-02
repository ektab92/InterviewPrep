package com.practice.ds0;
//1,2,3,4,0,6,7,8
public class Problem2 {
    public static int findMissing(int arr[])
    {
        int n = arr.length;
        int cSum = ((n-1)*(n))/2;
        int sum =0;
        for(int i=0;i<n;i++)
        {
            sum =sum+arr[i];
        }
        return sum-cSum;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,4};
        System.out.println(findMissing(arr));
    }
}
