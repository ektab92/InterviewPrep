package com.practice.ds.arrays;
import java.util.*;
class Pair
{
    int data;
    int freq;
    Pair(int data,int freq)
    {
        this.data=data;
        this.freq=freq;
    }
}
public class MaxMinAllSubArr {

    private int findMaxOfAllSubArr(int[] arr)
    {
        int [] maxLeft= new int[arr.length];
        Stack<Pair>stk1 = new Stack<>();
        Arrays.fill(maxLeft,1);
        int [] maxRight = new int[arr.length];
        Stack<Pair>stk2 = new Stack<>();
        Arrays.fill(maxRight,1);
        int maxSum=0;
        //finding min elemnet and its freq from Left
        for(int i =0;i<arr.length;i++)
        {
            if(stk1.isEmpty() || (arr[i]<stk1.peek().data))
            {
                stk1.push(new Pair(arr[i],1));
                maxLeft[i]=1;
            }
            else
            {
                while(!stk1.isEmpty() && stk1.peek().data < arr[i])
                {
                    maxLeft[i]+=stk1.pop().freq;
                }
                stk1.push(new Pair(arr[i],maxLeft[i]));
            }
        }
        //
        for(int i =arr.length-1;i>=0;i--)
        {
            if(stk2.isEmpty() || (arr[i]<stk2.peek().data))
            {
                stk2.push(new Pair(arr[i],1));
                maxRight[i]=1;
            }
            else
            {
                while(!stk2.isEmpty() && stk2.peek().data < arr[i])
                {
                    maxRight[i]+=stk2.pop().freq;
                }
                stk2.push(new Pair(arr[i],maxRight[i]));
            }
        }
        System.out.println(Arrays.toString(maxRight));
        System.out.println(Arrays.toString(maxLeft));
        for(int i =0;i< arr.length;i++)
        {
            maxSum+=arr[i]*maxRight[i]*maxLeft[i];
        }
        return maxSum;
    }
    //{4,3,-1,2} //
    private int findMinOfAllSubArr(int[] arr)
    {
        int [] minLeft= new int[arr.length];
        Stack<Pair>stk1 = new Stack<>();
        Arrays.fill(minLeft,1);
        int [] minRight = new int[arr.length];
        Arrays.fill(minRight,1);

        Stack<Pair>stk2 = new Stack<>();

        int minSum=0;
        //finding min elemnet and its freq from Left
        for(int i =0;i<arr.length;i++)
        {
            if(stk1.isEmpty() || (arr[i]>stk1.peek().data))
            {
                stk1.push(new Pair(arr[i],1));
                minLeft[i]=1;
            }
            else
            {
                while(!stk1.isEmpty() && stk1.peek().data > arr[i])
                {
                    minLeft[i]+=stk1.pop().freq;
                }
                stk1.push(new Pair(arr[i],minLeft[i]));
            }
        }
        //
        for(int i =arr.length-1;i>=0;i--)
        {
            if(stk2.isEmpty() || (arr[i]>stk2.peek().data))
            {
                stk2.push(new Pair(arr[i],1));
                minRight[i]=1;
            }
            else
            {
                while(!stk2.isEmpty() && stk2.peek().data > arr[i])
                {
                    minRight[i]+=stk2.pop().freq;
                }
                stk2.push(new Pair(arr[i],minRight[i]));
            }
        }
        System.out.println(Arrays.toString(minRight));
        System.out.println(Arrays.toString(minLeft));
        for(int i =0;i< arr.length;i++)
        {
            minSum+=arr[i]*minRight[i]*minLeft[i];
        }
        return minSum;
    }
    public static void main(String[] args) {
        int arr[] = {4,3,-1,2,3,-2,5,7};
        MaxMinAllSubArr arrOps = new MaxMinAllSubArr();
        System.out.println(arrOps.findMinOfAllSubArr(arr));
        System.out.println(arrOps.findMaxOfAllSubArr(arr));
    }
}
