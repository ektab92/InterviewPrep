package com.practice.ds0;

import java.util.Arrays;

public class Test3Sum {
    public void find3Sum(int arr[],int target)
    {
        if(arr.length <3)
            return;
        Arrays.sort(arr);
        int N = arr.length;
        int i,left,right;
        for( i=0;i<arr.length;i++)
        {
            left=i+1;
            right=N-1;
            while(left<right)
            {
                int sum = arr[i]+arr[left]+arr[right];
                if(sum == target)
                {
                    System.out.println(arr[i] + " : " + arr[left] + " : " + arr[right]);
                    left++;
                    right--;
                }
                else if (sum <target)
                {
                    left++;
                }
                else
                    right--;
                while(left <N-1 && arr[left]== arr[left+1] )
                {
                    left++;
                }
                while(right >0 &&arr[right] == arr[right-1])
                {
                    right--;
                }
            }
            while(i<N-1 && arr[i] == arr[i+1])
            {
                i++;
            }
        }
    }
    public static void main(String[] args) {
        int arr[]={12,3,4,1,6,9,6,6};
        Test3Sum t= new Test3Sum();
        t.find3Sum(arr,24);
    }
}
