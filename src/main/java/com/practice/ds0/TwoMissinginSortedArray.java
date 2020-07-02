package com.practice.ds0;

public class TwoMissinginSortedArray {
    public static void findMissing(int arr[],int N)
    {
        int expectedSum =(N*(N+1))/2;
        int actualSum=0;
        for(int i=0;i<arr.length;i++)
        {
            actualSum +=arr[i];
        }
        int mid = (expectedSum-actualSum)/2;
        int firstSum = mid*(mid+1)/2;;
        int sum=0;

        for(int i =0;i<arr.length;i++)
        {
            if(arr[i]<=mid)
                sum=sum+arr[i];
            else
                break;
        }
        int n1=firstSum-sum;
        System.out.println("firstNumber : "+n1);
        int n2= (expectedSum-actualSum)-n1;
        System.out.println("second Number: "+n2);
    }
    public static void main(String[] args) {

        int arr[]={1,2,3,5,6,7,8,9,11,12,13};
        findMissing(arr,13);
    }
}
