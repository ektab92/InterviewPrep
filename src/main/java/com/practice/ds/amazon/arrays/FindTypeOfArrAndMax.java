package com.practice.ds.amazon.arrays;

public class FindTypeOfArrAndMax {

    //3,2,1,5,4
    //3,4,5,1,2
    private void findType(int []arr)
    {
        int i=1;
        int N = arr.length;
        while(i<=N-1 && arr[i-1]<arr[i]  )
        {
            i++;
        }
        if(i == N)
        {
            System.out.println("Increasing array with max as : " + arr[N - 1]);
            return;
        }
        if(i == 1)
        {
            while(i<=N-1 && arr[i-1]> arr[i])
            {
                i++;
            }
            if(i == N)
            {
                System.out.println("Decreasing array wth max as : " + arr[0]);
                return;
            }
            else
            {
                System.out.println("Decreasing rotated array with max as : "+arr[i]);
                return;
            }

        }else
        {
            System.out.println("Increasing rotated array with max as :"+arr[i-1]);
        }

    }
    public static void main(String[] args) {
        int arr1[] = {5,4,3,2,1};
        int arr2[] = {4,3,2,1,5};
        int arr3[] = {3,2,1,5,4};
        int arr4[] = {2,1,5,4,3};
        int arr5[] = {1,5,4,3,2};
        FindTypeOfArrAndMax arrOps = new FindTypeOfArrAndMax();
        arrOps.findType(arr1);
        arrOps.findType(arr2);
        arrOps.findType(arr3);
        arrOps.findType(arr4);
        arrOps.findType(arr5);

    }
}
