package com.practice.ds;

import java.util.Arrays;

public class MatrixMultiplication {

    public int findCost(int arr[]){
        int temp[][] = new int[arr.length][arr.length];
        for(int l = 2;l<arr.length;l++)
        {
            for(int i =0;i<arr.length-l;i++)
            {
                int j=i+l;
                temp[i][j]=1000000;
                for(int k=i+1;k<j;k++) {
                    temp[i][j] = Math.min(temp[i][j],temp[i][k]+temp[k][j]+arr[i]*arr[k]*arr[j]);
                }
            }
        }
        for(int i =0;i<temp.length;i++)
            System.out.println(Arrays.toString(temp[i]));
        return temp[0][temp.length-1];
    }

    public static void main(String args[]){
        MatrixMultiplication mmc = new MatrixMultiplication();
        int arr[] = {4,2,3,5,3};
        int cost = mmc.findCost(arr);
        System.out.print(cost);
    }
}