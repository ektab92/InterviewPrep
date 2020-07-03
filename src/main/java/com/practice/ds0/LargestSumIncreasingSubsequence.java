package com.practice.ds0;

import java.util.Arrays;

//[1, 18, 7, 5, 3, 6, 8, 2, 4, 11, -9, -3, -7, 4]
public class LargestSumIncreasingSubsequence {

    private void findMaxSum(int arr[])
    {
        int N = arr.length;
        int sumArr[]= new int[N];
        int path[] = new int [N];
        Arrays.fill(path,-1);
        for(int i =0;i<N;i++)
        {
            sumArr[i]=arr[i];
        }
        for(int i=1;i<N;i++)
        {
            for(int j=0;j<=i;j++)
            {
                if(arr[i]>arr[j])
                {
                    int sum = arr[i]+sumArr[j];
                    if(sum>sumArr[i])
                    {
                        sumArr[i] = sum;
                        path[i]=j;
                    }
                }
            }
        }
        int max=Integer.MIN_VALUE;
        int maxIndex=-1;
        for(int i=0;i<N;i++)
        {
            if(max<sumArr[i])
            {
                max = sumArr[i];
                maxIndex=i;
            }
        }
        System.out.println("maximum sum :"+max);
        System.out.println("maxSum Path");
        while(maxIndex>=0)
        {
            System.out.print(arr[maxIndex]+"-->");
            maxIndex=path[maxIndex];
        }
        //System.out.println(Arrays.toString(arr));
        //System.out.println(Arrays.toString(sumArr));
        //System.out.println(Arrays.toString(path));
    }
    public static void main(String[] args) {
        int arr[]={1, 18, 7, 5, 3, 6, 8, 2, 4, 11, -9, -3, -7, 4};
        LargestSumIncreasingSubsequence sum = new LargestSumIncreasingSubsequence();
        sum.findMaxSum(arr);

    }
}
