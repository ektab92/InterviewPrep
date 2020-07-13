package com.practice.ds0;

import java.util.Arrays;

public class MergeSort {
    public void merge(int arr[],int lo,int mid,int hi)
    {
        int aux[]= new int [arr.length];
        for(int i =lo;i<=hi;i++)
        {
            aux[i]=arr[i];
        }
        int i = lo;
        int j = mid+1;
        int k=lo;
        while(i<=mid && j<=hi)
        {
            System.out.println(i+":"+j+":"+k);
            if(aux[i]<=aux[j])
            {
                arr[k]=aux[i];
                i++;
            }
            else
            {
                arr[k]=aux[j];
                j++;
            }
            k++;
        }
        while(i<=mid)
        {
            arr[k]=aux[i];
            k++;
            i++;
        }
        while(j<=hi)
        {
            arr[k]=aux[j];
            k++;
            j++;
        }
    }
    public void mergerSortArr(int arr[],int lo,int hi)
    {
        if(lo>=hi)
            return;
        int mid = lo+(hi-lo)/2;
        mergerSortArr(arr,lo,mid);
        mergerSortArr(arr,mid+1,hi);
        merge(arr,lo,mid,hi);
    }
    public static void main(String[] args) {
        int arr[]= {1,5,-1,0,4,-3,9,11,23,12};
        MergeSort sort = new MergeSort();
        sort.mergerSortArr(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
