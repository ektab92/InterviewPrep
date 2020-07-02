package com.practice.mockrounds.day5;

import java.util.Arrays;

//2,3,9,10,11,0,0,0=n length 5
//1,4,6=m length 3
//
public class MergeTwoSortedArr {
    private void mergeArr(int []a,int []b,int m,int n)
    {
        int f=m-1;//big arr ctr
        int s=n-1;//small arr ctr
        int l=m+n-1;//l of big arr ctr
        while(f>=0 && s>=0)
        {
            if (a[f]<b[s])
            {
                a[l]=b[s];
                s--;
            }
            else
            {
                a[l]=a[f];
                f--;
            }
            l--;
        }
        if(f==-1 && s>=0)
        {
            while(s>=0)
            {
                a[l]=b[s];
                s--;
                l--;
            }
        }
        System.out.println(Arrays.toString(a));
    }
    public static void main(String[] args) {
        MergeTwoSortedArr merge = new MergeTwoSortedArr();

        int a[]={2,3,9,10,11,0,0,0,0,0,0,0};
        int b[]={1,4,6};
        merge.mergeArr(a,b,5,3);
    }
}
