package com.practice.ds0;

public class CollectElementsLessThanK {

    static void CollectElements(int [] arr,int k)
    {
            int count=0,n=0,mincount,temp=0;
            int currCount=0;
            for (int i =0 ; i<arr.length;i++)
            {
                if(arr[i] <=k)
                    count++;
            }

            for(int i =0;i <count; i++)
            {
                if(arr[i]>k)
                    currCount++;
            }
            mincount = currCount;
            for(int i =1; i<arr.length-count ;i++)
            {
                if(arr[i]>k)
                    currCount--;
                if(arr[i+count] >k)
                    currCount++;
                if(mincount >currCount)
                    mincount=currCount;

            }
            //slower solution
            /**while(n<= arr.length-count)
            {
                temp=0;
                for(int j =n ; j <n+count; j++)
                {
                    if(arr[j] >= k)
                    {
                        temp++;
                    }
                }
                if(temp <mincount)
                    mincount=temp;
                n++;
            }**/
        System.out.println("minimum swaps :: "+mincount);
    }

    public static void main(String[] args) {
        int arr[]={2,7,9,5,8,7,4};
        //int arr[] = {2,1,5,6,3};
        //int arr[] ={15,4,9,6,3,1}
        CollectElements(arr,5);
    }
}
