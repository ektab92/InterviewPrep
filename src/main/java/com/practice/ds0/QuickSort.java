package com.practice.ds0;

import java.util.Arrays;

public class QuickSort {
    
    static int partition(int [] arr,int lo,int hi)
    {
       int pivotIndex=lo;
       int left=lo+1;
       int right=hi;
       while(true)
       {
           while(left<=right && arr[left]<=arr[pivotIndex]  )
           {
               left++;
           }
           while(right >=left && arr[right]>=arr[pivotIndex] )
           {
               right--;
           }
           if(left>=right)
               break;
           int temp =arr[left];
           arr[left]=arr[right];
           arr[right]=temp;
       }
       int temp = arr[pivotIndex];
       arr[pivotIndex]=arr[right];
       arr[right]=temp;
       return right;
    }

    static void sortArray(int [] arr,int low,int high)
    {
        if(low>= high)
            return;

        System.out.println("Before Pivot"+Arrays.toString(arr));
        int pivot = partition(arr, low, high);
        System.out.println("After Pivot :"+Arrays.toString(arr));
        sortArray(arr,low,pivot-1);
        sortArray(arr,pivot+1,high);

    }


    public static void main(String[] args) {
        int arr [] = {5,7,8,9,10,11,12,1,3,4,-1,-4,5,4,1};
         QuickSort.sortArray(arr,0,arr.length-1);
        //System.out.println(Arrays.toString(arr));
    }
}
