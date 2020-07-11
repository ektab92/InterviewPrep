package com.practice.ds0;

import java.util.Arrays;
import java.util.Collections;

//3,2,5
//sort===> 5,3,2
//subset with 5 as maxSum 5,[5,3],[5,3,2],[5,2] ===> 4 is count //powerset at 5 is 2^(N-i-1) i is 0
//subset with 3 as maxSum 3,[3,2] ====>2 is count////powerset at 3 is 2^(N-i-1) i is 1
//subset with 2 as maxSum 2 ====>1 is count
//for finding max sum in all 4 subsets for 5, 5 will be max hence,5*4
//in all subsets with 3 as max 3*2
//with 2 as max 2
//sum = 5*2^(N-1)+3*2^(N-2)+....
//reduce by horners rule
//5*2^3+4*2^2+3*2+2
//40+16+6+2
//64
//2,3,4,5
//2,[2,3],[2,3,4],[2,3,4,5],[2,4],[2,5],[2,4,5]
public class MaxEleSumFromAllSubset {
    public int findMaxSumSubset(Integer []arr)
    {
        Arrays.sort(arr,Collections.reverseOrder());
        int sum = arr[0];
        for(int i =1;i<arr.length;i++)
        {
            sum = 2*sum+arr[i];
        }
        return sum;
    }
    public int findMinSumSubset(Integer []arr)
    {
        Arrays.sort(arr);
        int sum = arr[0];
        for(int i =1;i<arr.length;i++)
        {
            sum = 2*sum+arr[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        Integer arr[] = {4, 3, 1};
        MaxEleSumFromAllSubset findMAx = new MaxEleSumFromAllSubset();
        System.out.println(findMAx.findMaxSumSubset(arr));
        System.out.println(findMAx.findMinSumSubset(arr));
    }
}
