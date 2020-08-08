package com.practice.ds.amazon.arrays;

import java.util.Arrays;

public class AlternatePositveandNegetiveArrange {
    private void rearrangeNumbers(int [] arr)
    {
        int i =0;
        int j =arr.length-1;
        while(i<j)
        {
            if(arr[i]<0) i++;
            else
            {
                while(j>=0 && arr[j]>=0 && i<j)
                    j--;

                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
        }
        int n=1;
        int p=j;
        while(n<p && p<arr.length)
        {
            int temp = arr[n];
            arr[n]=arr[p];
            arr[p]=temp;
            n+=2;
            p++;
        }

        //j+1
        System.out.println(Arrays.toString(arr)+ " "+j);
    }
    public static void main(String[] args) {
        int arr[]={-1,3,-2,5,6,7,-4,11,-15,-16};
        AlternatePositveandNegetiveArrange arrOps = new AlternatePositveandNegetiveArrange();
        arrOps.rearrangeNumbers(arr);
    }
}
