package com.practice.ds.amazon.arrays;


import java.util.*;

public class MaxInKSizeSubArr {
    Deque<Integer>maxAtBottom = new LinkedList<>();

    private List<Integer> findMax(int [] arr,int k)
    {
        List<Integer>answer = new ArrayList<>();
        processWindow(arr,0,k);
        answer.add(arr[maxAtBottom.peekFirst()]);
        for(int i =1;i<=arr.length-k;i++)
        {
            while(!maxAtBottom.isEmpty() && maxAtBottom.peekFirst()<i)
            {
                maxAtBottom.removeFirst();
            }
            processWindow(arr,i,i+k);
            answer.add(arr[maxAtBottom.peekFirst()]);
        }
        return answer;
    }
    private void processWindow(int arr[],int start,int end)
    {
        for(int i=start;i<end;i++)
        {
            while(!maxAtBottom.isEmpty() &&  arr[maxAtBottom.peekLast()] < arr[i])
            {
                maxAtBottom.removeLast();
            }
            maxAtBottom.addLast(i);

        }
    }
    public static void main(String[] args) {
        int [] arr = {2,5,-1,7,-3,-1,-2};
        MaxInKSizeSubArr processor = new MaxInKSizeSubArr();
        System.out.println(processor.findMax(arr,4));

    }
}
