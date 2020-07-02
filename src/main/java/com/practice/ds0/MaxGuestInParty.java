package com.practice.ds0;

import java.util.Arrays;

public class MaxGuestInParty {
    public static int findGuestInParty(int [] arr1,int [] arr2)
    {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i=0,j=0;
        int inTime=0;
        //int outTime;
        int totalGuest=0;
        int maxGuest=0;
        //time not calculated correctly
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        while(i<arr1.length && j<arr2.length)
        {

            if(arr1[i]<=arr2[j])
            {
                totalGuest++;
                if(totalGuest>maxGuest)
                {
                    inTime=arr1[i];
                    maxGuest = totalGuest;
                }
                i++;
            }
            else
            {
                j++;
                totalGuest--;
            }
        }
        System.out.println(inTime);
        return maxGuest;
    }
    public static void main(String[] args) {
        int arr1[]={1,2,3,4,9,7,5};
        int arr2[]={4,5,6,5,10,9,8};
        int arrl[] = {1, 2, 10, 5, 5};
        int exit[] = {4, 5, 12, 9, 12};
        int maxGuest=findGuestInParty(arrl,exit);
        System.out.println("Max Guest present in party span : "+maxGuest);
    }
}
