package com.practice.ds0;
//wrong solution
public class OnceOccuringElement {
    public static void singleOccurance(int [] arr)
    {
        int sumofBits =0,j=0;
        StringBuilder sb = new StringBuilder();
        while( j< 32) {
            int mask = 1 <<j;//leftshift
            sumofBits=0;
            for (int i = 0; i < arr.length; i++) {
                sumofBits = arr[i] & mask + sumofBits;
            }

            sb.append(sumofBits%3);
            j++;
        }
        System.out.println(sb.reverse());
    }
    public static void main(String[] args) {
        int [] arr = {2,5,5,3,1,3,3,1,1,5,7,7,7};
        singleOccurance(arr);
    }
}
