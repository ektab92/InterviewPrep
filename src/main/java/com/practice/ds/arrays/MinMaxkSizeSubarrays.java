package com.practice.ds.arrays;

import java.util.Deque;
import java.util.LinkedList;

public class MinMaxkSizeSubarrays {
    Deque<Integer>maxAtBottom = new LinkedList<>();
    Deque<Integer>minAtBottom = new LinkedList<>();
    public int findMinMaxSum(int[]arr,int k)
    {
        int total=0;

        processCurrWindow(arr, 0,k);
        total += arr[minAtBottom.peekFirst()]+arr[maxAtBottom.peekFirst()];

        for(int i =1;i<=arr.length-k;i++)
        {

            while(!minAtBottom.isEmpty() && minAtBottom.peekFirst()<i )
            {
                minAtBottom.removeFirst();
            }
            while(!maxAtBottom.isEmpty() && maxAtBottom.peekFirst()<i)
            {
                maxAtBottom.removeFirst();
            }
            processCurrWindow(arr,i,i+k);
            total += arr[minAtBottom.peekFirst()]+arr[maxAtBottom.peekFirst()];
        }

        return total;
    }

    private void processCurrWindow(int[] arr,int start, int end) {
        for(int i=start;i<end;i++)
        {
            //Fill Deque with max element index at bottom
            if(maxAtBottom.isEmpty()|| arr[maxAtBottom.peekLast()] > arr[i])
            {
                maxAtBottom.addLast(i);
            }
            else
            {
                while(!maxAtBottom.isEmpty() && arr[maxAtBottom.peekLast()]< arr[i] )
                {
                    maxAtBottom.removeLast();
                }
                maxAtBottom.addLast(i);
            }

            //Fill Deque with max element index at top
            if(minAtBottom.isEmpty() || arr[minAtBottom.peekLast()] < arr[i])
            {
                minAtBottom.addLast(i);
            }
            else
            {
                while(!minAtBottom.isEmpty() && arr[minAtBottom.peekLast()]> arr[i] )
                {
                    minAtBottom.removeLast();
                }
                minAtBottom.addLast(i);
            }

        }
    }

    public static void main(String[] args) {
        int [] arr = {2,5,-1,7,-3,-1,-2};
        MinMaxkSizeSubarrays processor = new MinMaxkSizeSubarrays();
        System.out.println(processor.findMinMaxSum(arr,4));
    }
}
