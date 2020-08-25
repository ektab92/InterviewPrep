package com.practice.ds.amazon.arrays;

import java.util.Deque;
import java.util.LinkedList;

public class SumMinMaxInKSizeSubArr {
    Deque<Integer>minAtBottom = new LinkedList<>();
    Deque<Integer>maxAtBottom = new LinkedList<>();
    private int findSum(int arr[],int k)
    {
        processWindow(arr,0,k);
        int minMaxSum = arr[minAtBottom.peekFirst()]+arr[maxAtBottom.peekFirst()];
        for(int i=1;i<=arr.length-k;i++)
        {
            while(minAtBottom.peekFirst()<i)
                minAtBottom.removeFirst();
            while(maxAtBottom.peekFirst()<i)
                maxAtBottom.removeFirst();
            processWindow(arr,i+k-1,i+k);
            minMaxSum += arr[minAtBottom.peekFirst()]+arr[maxAtBottom.peekFirst()];
        }
        System.out.println(minMaxSum);
        return minMaxSum;
    }
    private void processWindow(int []arr,int start,int k)
    {
        for(int i=start;i<k;i++)
        {
            if(minAtBottom.isEmpty() ||arr[i]>arr[minAtBottom.peekLast()])
                minAtBottom.addLast(i);
            else
            {
                while(!minAtBottom.isEmpty() && arr[i]<arr[minAtBottom.peekLast()])
                {
                    minAtBottom.removeLast();
                }
                minAtBottom.addLast(i);
            }
            if(maxAtBottom.isEmpty() || arr[i]<arr[maxAtBottom.peekLast()])
                maxAtBottom.addLast(i);
            else
            {
                while(!maxAtBottom.isEmpty() && arr[i]>arr[maxAtBottom.peekLast()])
                {
                    maxAtBottom.removeLast();
                }
                maxAtBottom.addLast(i);
            }

        }
    }
    public static void main(String[] args) {
        int [] arr = {2,5,-1,7,-3,-1,-2};
        SumMinMaxInKSizeSubArr arrops = new SumMinMaxInKSizeSubArr();
        arrops.findSum(arr,4);
    }
}
