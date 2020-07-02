package com.practice.ds0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KSumSubArray {
    private int arr [];
    private int k;
    public KSumSubArray(int findSum,int arr [])
    {
        this.arr = arr;
        this.k = findSum;
    }
    public void findKSumSubarray()
    {
        Map<Integer,List <Integer>> map = new HashMap<Integer, List<Integer>>();
        int sum =0;
        int diff;
        List <Integer> zeroslist = new ArrayList<>();
        zeroslist.add(-1);
        map.put(0,zeroslist);
        for(int i =0; i< arr.length ; i++)
        {
            sum = sum+arr[i];
            diff = sum - k;
            if(map.containsKey(diff))
            {
                List <Integer> index=map.get(diff);
                for(int j =0; j < index.size();j++)
                {
                    System.out.println((index.get(j)+1)+"::"+i);
                }

            }
            if(map.containsKey(sum))
            {
                List <Integer> sumIndices = map.get(sum);
                sumIndices.add(i);
                map.put(sum,sumIndices);
            }
            else
            {
                List <Integer> newsumIndices = new ArrayList<>();
                newsumIndices.add(i);
                map.put(sum,newsumIndices);

            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        KSumSubArray findsum = new KSumSubArray(-10,arr);
        findsum.findKSumSubarray();
    }
}
