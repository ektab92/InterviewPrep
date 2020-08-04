package com.practice.ds.amazon.arrays;

import java.util.*;
public class PrintPrevSmallOnLeft {
    private void printPrevSmaller(int[]arr)
    {
        int result [] = new int [arr.length];
        Stack<Integer>stk = new Stack<>();
        //{1, 6, 4, 10, 2, 5}
        for(int i =0;i<arr.length;i++)
        {
            if(stk.isEmpty())
            {
                result[i]=0;
            }
            else if(stk.peek() <= arr[i])
            {
                result[i]=stk.peek();
            }
            else
            {
                while(!stk.isEmpty() && stk.peek()>arr[i])
                {
                    stk.pop();
                }
                result[i]=stk.peek();
            }
            stk.push(arr[i]);

        }
        System.out.println(Arrays.toString(result));
    }
    public static void main(String[] args) {
        int arr[] = {1, 6, 4, 10, 2, 5};
        PrintPrevSmallOnLeft arrOps = new PrintPrevSmallOnLeft();
        arrOps.printPrevSmaller(arr);
    }
}
