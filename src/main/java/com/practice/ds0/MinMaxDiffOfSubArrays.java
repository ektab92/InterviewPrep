package com.practice.ds0;

import java.util.Stack;

//3,1,2,4
class Pair
{
    int data;
    int count;
    Pair(int f,int s)
    {
        this.data=f;
        this.count=s;
    }
}
public class MinMaxDiffOfSubArrays {

    public static int findMinSumOfSubArr(int arr[])
    {
        Stack <Pair> stk1 = new Stack<>();
        int minSum=0;
        //iterate fro left and for each element find subarr count which has arr[i] as min
        int []left=new int [arr.length];//arr which has count of arrays where a[i] is min, considering from left

        for(int i=0;i<arr.length;i++)
        {
            int count=1;
            while(!stk1.isEmpty() && stk1.peek().data>=arr[i])
            {
               count+= stk1.pop().count;
            }
            stk1.push(new Pair(arr[i],count));
            left[i]=count;
        }
        //iterate fro right and for each element find subarr count which has arr[i] as min
        Stack <Pair> stk2 = new Stack<>();
        int []right=new int [arr.length];//arr which has count of arrays where a[i] is min, considering from right
         for(int i =arr.length-1;i>=0;i--)
         {
             int count =1;
             while(!stk2.isEmpty() && stk2.peek().data>=arr[i])
             {
                 count+=stk2.pop().count;
             }
             stk2.push(new Pair(arr[i],count));
             right[i]=count;
         }

         for(int i =0;i<arr.length;i++)
         {
             minSum+=left[i]*right[i]*arr[i];
         }
        System.out.println(minSum);
        return minSum;
    }
    //3,1,2,4
    public static int findmaxSumOfSubArr(int arr[])
    {
        int maxSum=0;
        Stack<Pair>stk1 = new Stack<>();
        int [] left = new int [arr.length];
        for(int i =0;i<arr.length;i++)
        {
            int count =1;
            while(!stk1.isEmpty() && stk1.peek().data<=arr[i])
            {
                count+=stk1.pop().count;
            }
            stk1.push(new Pair(arr[i],count));
            left[i]=count;
        }

        Stack<Pair>stk2 = new Stack<>();
        int [] right = new int [arr.length];
        for(int i =arr.length-1;i>=0;i--)
        {
            int count =1;
            while(!stk2.isEmpty() && stk2.peek().data<=arr[i])
            {
                count+=stk2.pop().count;
            }
            stk2.push(new Pair(arr[i],count));
            right[i]=count;
        }
        for(int i =0;i<arr.length;i++)
        {
            maxSum+=left[i]*right[i]*arr[i];
        }
        System.out.println(maxSum);
        return maxSum;
    }
    public static void main(String[] args) {
        int arr[] ={3,2,1,4};
        findMinSumOfSubArr(arr);
        findmaxSumOfSubArr(arr);
    }
}
