package com.practice.ds0;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedArr {
    //slower solution
    static public int removeDuplicates(int[] nums) {
        int count = nums.length;
        int k =0;
        Set<Integer> hashset = new LinkedHashSet<Integer>();
        for(int i =0 ; i < nums.length;i++)
        {
            hashset.add(nums[i]);
        }
        for(Integer i:hashset){
            nums[k]=i;
            k++;
        }
        return hashset.size();
    }
    //faster solution --- inplace
    public int removeDuplicates1(int[] nums) {
        //keep count of duplicates, once new duplicate comes, move it to index-duplicate count position.
        if(nums.length ==0)
            return 0;
        int prev = nums[0];
        int repCount=0;
        for(int i = 1 ; i<nums.length;i++)
        {
            if(nums[i]==prev)
            {
                repCount++;
            }
            else
            {
                nums[i-repCount]=nums[i];
                prev=nums[i];
            }

        }
        return (nums.length-repCount);
    }


    public static void main(String[] args) {

    }
}
