package com.practice.ds.amazon.dp;

import java.util.Arrays;

public class PartitionArrInTwoEqualSumSubsets {
    private boolean paritionArr(int [] arr)
    {
        int sum=0;
        for(int i =0;i<arr.length;i++)
        {
            sum=sum+arr[i];
        }
        if(sum%2 !=0) {
            System.out.println("Cant form subsets of equal sum if total arr sum is odd");
            return false;
        }

        boolean [][]sumPossible = new boolean[arr.length+1][sum/2+1];
        Arrays.fill(sumPossible[0],false);
        for(int i =0;i<sum/2+1;i++)
        {
            sumPossible[i][0]=true;
        }

        for(int i =1;i<sumPossible.length;i++)
        {
            for(int j=1;j<sumPossible[0].length;j++)
            {
                if(j<arr[i-1])
                    sumPossible[i][j]=sumPossible[i-1][j];
                else
                {
                    sumPossible[i][j]=sumPossible[i-1][j-arr[i-1]];
                }
            }
        }
        if(sumPossible[sumPossible.length-1][sumPossible[0].length-1]) {
            int r = arr.length;
            int c = sum / 2;
            while (r > 0 && c > 0) {
                if (r > 0 && sumPossible[r][c] == sumPossible[r - 1][c]) {
                    r = r - 1;
                } else {
                    System.out.println(r - 1);
                    c = c - arr[r - 1];
                    r = r - 1;

                }
            }
        }
        System.out.println(sumPossible[sumPossible.length-1][sumPossible[0].length-1]);
        return sumPossible[sumPossible.length-1][sumPossible[0].length-1];
    }
    public static void main(String[] args) {
        int []arr = {3,1,1,2,2,1};
        PartitionArrInTwoEqualSumSubsets sumSubsets = new PartitionArrInTwoEqualSumSubsets();
        sumSubsets.paritionArr(arr);

    }
}
