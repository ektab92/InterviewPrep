package com.practice.ds0;
import java.util.*;
public class closestThreePairSum {
    public static int threeSumClosest(int[] nums, int target) {
        int closestSum = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i =0; i < nums.length;i++)
        {
            int left =i+1;
            int right = nums.length-1;
            while(left < right)
            {
                int sum = nums[left]+nums[right]+nums[i];
                if(sum == target)
                    return target;
                if(Math.abs(sum-target) <=Math.abs(closestSum))
                    closestSum=sum;
                if(sum <target)
                    left++;
                else
                    right--;

            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        int arr[] = {-1,2,1,-4};
        threeSumClosest(arr,1);
    }
}
