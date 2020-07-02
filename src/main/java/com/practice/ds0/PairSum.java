package com.practice.ds0;
import java.util.*;

public class PairSum {
    public int[] twoSum(int[] nums, int target) {

        int diff;
        int []res = new int[2];
        Map <Integer,Integer> map = new HashMap<>();
        //Find the Diff first , and then check if it is present in map or not, if diff is not present in map
        //insert value of element and its index
        //If present in map , return element index and get from map the value of diff
        //we should not first populat map , before we calc diff as it might lead to failure of cases like
        //(3,3)--sum 6, (3,2,4) --sum 6
        for(int i =0;i<nums.length;i++)
        {
            diff = target-nums[i];
            if(!map.containsKey(diff) )
            {
                map.put(nums[i],i);
            }
            else
            {
                res[0]=map.get(diff);
                res[1]=i;
            }
        }
        return res;

    }
}
