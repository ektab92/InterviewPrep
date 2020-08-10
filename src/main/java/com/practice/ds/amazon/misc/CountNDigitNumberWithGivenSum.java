package com.practice.ds.amazon.misc;

public class CountNDigitNumberWithGivenSum {
    /*
    Idea is if we need to find 4 digt number with sum 6,Range will be
    pow(10,4-1) to pow(10,4)-1
    i.e pow(10,3) to 9999
    keep checking each number in this range i its sum of digits is divisible by 9
    If number gets divisible by 9 , increment number by 9, else keep incrementing by 9
    and maintains count for result
     */
    private int findDigitsWithGivenSum(int n,int sum)
    {
        int lo = (int)Math.pow(10,n-1);
        int totalNumbers=0;
        int hi = (int)Math.pow(10,n)-1;
        while(lo<=hi)
        {
            //447
            int temp = lo;
            int digitSum=0;
            while(temp>0)
            {
                digitSum+= temp%10;
                temp = temp/10;
            }
            if(digitSum == sum)
            {
                System.out.println(lo);
                lo = lo+9;
                totalNumbers=totalNumbers+1;
            }
            else
                lo = lo+1;

        }
        System.out.println(totalNumbers);
        return totalNumbers;
    }
    public static void main(String[] args) {
        CountNDigitNumberWithGivenSum digitCounter = new CountNDigitNumberWithGivenSum();
        digitCounter.findDigitsWithGivenSum(4,6);
    }
}
