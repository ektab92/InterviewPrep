package com.practice.ds0;

import java.util.Arrays;

public class QuickSort {

    static int partition(int [] arr,int lo,int hi)
    {
        int pivot = arr[lo];
        int i = lo+1;
        int j = hi;
        while(true) {

            while (arr[i] < pivot) {
                i++;
                if (i == hi)
                    break;
            }
            while (arr[j] > pivot) {
                j--;
                if (j == lo)
                    break;
            }
            if(i>=j)
                break;
            int temp = arr[i];
            arr[i]= arr[j];
            arr[j] = temp;
        }

        // A = [1,2,3]
        // pivot = A[lo] = A[0]
        // j =3
        // temp = A[j]
        // A[j] = pivot
        // pivot = temp
        int temp = arr[j];
        arr[j]=arr[lo];
        arr[lo] = temp;
        return j;

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
        int arr [] = {5,9,12,1,0,3,14,7};
         QuickSort.sortArray(arr,0,arr.length-1);
        //System.out.println(Arrays.toString(arr));
    }
}
