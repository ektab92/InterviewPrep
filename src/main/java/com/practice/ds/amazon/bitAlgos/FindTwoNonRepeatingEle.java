package com.practice.ds.amazon.bitAlgos;

import java.util.*;
/*
    1. find xor of all elements of array
    2. the output of step 1 is missingNo1^missingNo2= out1
    3. Only set bits in out1 will be bits which are diff in both numbers
    4. find rightmost bit set int out1 = setBit1.
    5. now devide array into two sets, one with numbers having set.Bit1 as 1 an others with setBit1 as 0;
    6. Xor elements of the two array to get answers
 */
public class FindTwoNonRepeatingEle {
    private void findNonRepeatingEle(int [] arr)
    {
        int xor=arr[0];
        for(int i=1;i<arr.length;i++)
            xor = xor^arr[i];
        FindFirstRightSetBit rightBit = new FindFirstRightSetBit();
        int val=rightBit.findFirstSetBitFromRight(xor);
        List<Integer>rightBitSet = new ArrayList<>();
        List<Integer>rightBitNotSet = new ArrayList<>();


        for(int i=0;i< arr.length;i++)
        {
            if((arr[i]&val) >0)
                rightBitSet.add(arr[i]);
            else
                rightBitNotSet.add(arr[i]);
        }
        System.out.println(val);
        int missingNum1=rightBitSet.get(0);
        int missingNum2=rightBitNotSet.get(0);
        for(int i=1;i<rightBitSet.size();i++)
        {
            missingNum1=missingNum1^rightBitSet.get(i);
        }
        for(int i=1;i<rightBitNotSet.size();i++)
        {
            missingNum2=missingNum2^rightBitNotSet.get(i);
        }
        System.out.println(missingNum1+" : "+missingNum2);
    }
    public static void main(String[] args)
    {
        int arr[] = {2,4,7,9,2,4};
        FindTwoNonRepeatingEle bitOps = new FindTwoNonRepeatingEle();
        bitOps.findNonRepeatingEle(arr);
    }
}
