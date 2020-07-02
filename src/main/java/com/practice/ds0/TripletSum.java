package com.practice.ds0;

public class TripletSum {
    static void tripletSum(int []arr,int sum)
    {
        for(int i=0;i<arr.length;i++)
        {
            int t1=arr[i];
            int temp=0;
            int pairsum = sum -t1;
            int j =i+1;
            int k=arr.length-1;
            while(j<arr.length && k>j)
            {
                temp = arr[j]+arr[k];
                if(temp >pairsum)
                {
                    j++;
                }
                else if(temp <pairsum)
                {
                    k--;
                }
                else
                {
                    System.out.println("i= "+arr[i] +" j= "+arr[j]+" k= "+arr[k]);
                    break;
                }
            }


        }
    }

    public static void main(String[] args) {
        int arr[] ={12,9,6,4,3,1};
        tripletSum(arr,16);
    }
}
