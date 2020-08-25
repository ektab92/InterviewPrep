package com.practice.ds.amazon.arrays;

import java.util.Stack;

public class MinMaxSumAllSubArr {
    class Pair
    {
        int num;
        int frq;
        Pair(int n,int f)
        {
            this.num=n;
            this.frq=f;
        }
    }

    private int findSum(int []arr)
    {
        Stack<Pair>LeftStk = new Stack<>();
        Stack<Pair>RightStk = new Stack<>();
        int [] left = new int[arr.length];
        int [] right = new int[arr.length];

        for(int i =0;i<arr.length;i++)
        {
            Pair p=null;
            if(LeftStk.isEmpty() || arr[i]>LeftStk.peek().num)
            {
                p = new  Pair(arr[i],1);
                LeftStk.push(p);
            }else
            {
                int freq=1;
                p=null;
                while(!LeftStk.isEmpty() &&arr[i]<LeftStk.peek().num)
                {
                    p = LeftStk.pop();
                    p.num=arr[i];
                    freq+=p.frq;
                }
                p.frq=freq;
                LeftStk.push(p);
            }
            left[i]=p.frq;
        }

        for(int i=arr.length-1;i>=0;i--)
        {
            Pair p=null;
            if(RightStk.isEmpty() || arr[i]>RightStk.peek().num)
            {
                p = new  Pair(arr[i],1);
                RightStk.push(p);
            }else
            {
                int freq=1;
                p=null;
                while(!RightStk.isEmpty() &&arr[i]<RightStk.peek().num)
                {
                    p = RightStk.pop();
                    p.num=arr[i];
                    freq+=p.frq;
                }
                p.frq=freq;
                RightStk.push(p);
            }
            right[i]=p.frq;
        }
        int sum =0;
        for(int i=0;i< arr.length;i++)
        {
            sum +=arr[i]*left[i]* right[i];
        }
        System.out.println(sum);
        return sum;
    }
    public static void main(String[] args) {
        int arr[] = {4,1,2,3};
        MinMaxSumAllSubArr arrOps = new MinMaxSumAllSubArr();
        arrOps.findSum(arr);
    }
}
