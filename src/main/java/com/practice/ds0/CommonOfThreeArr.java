package com.practice.ds0;

import java.util.ArrayList;
import java.util.*;
public class CommonOfThreeArr {
    public static void commonEle(int [] arr1,int [] arr2, int [] arr3)
    {
        int k =0;//2nd array counter
        int j =0;//3rd array counter
        List <Integer> list = new ArrayList<>();
        for(int i =0; i < arr1.length;)
        {
            if(arr1[i] > arr2[k])
                k++;
            if(arr1[i] > arr3[j])
                j++;
            if(arr1[i]< arr2[k] || arr1[i] < arr3[j] )
                i++;
            else if (arr1[i] == arr2[k] && arr1[i] == arr3[j])
            {
                    list.add(arr1[i]);
                    i++;
                    j++;
                    k++;
            }
        }
        System.out.println(list.toString());
    }
    public static void main(String[] args) {
        int [] a1 = {1,5,10,20,40,80};
        int [] a2 = {6,7,20,80,100};
        int [] a3 = {3,4,15,20,30,70,80,120};
        commonEle(a1,a2,a3);

    }
}
