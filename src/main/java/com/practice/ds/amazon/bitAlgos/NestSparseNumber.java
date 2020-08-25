package com.practice.ds.amazon.bitAlgos;

import java.util.*;

public class NestSparseNumber {
    private int findNextSparse(int num)
    {
        //to get binary of number in reverse order
        List<Integer>binaryNum = new ArrayList<>();
        while(num>0)
        {
            binaryNum.add(num&1);
            num = num>>1;
        }
        //sparse number might take extra bit to appending 0
        binaryNum.add(0);
        int last_index=0;
        int nextSparseNum=0;
        for(int i =1;i<binaryNum.size()-1;i++)
        {
            if(binaryNum.get(i-1) == 1 && binaryNum.get(i) == 1 && binaryNum.get(i+1) !=1)
            {
                for(int j=i;j>=last_index;j--)
                {
                    binaryNum.set(j,0);
                }
                binaryNum.set(i+1,1);
                last_index=i+1;
            }
        }
        for(int i=0;i<binaryNum.size();i++)
        {
            nextSparseNum= nextSparseNum+binaryNum.get(i)*(int)Math.pow(2,i);
        }
        System.out.println(nextSparseNum);
        return nextSparseNum;
    }
    public static void main(String[] args) {
        NestSparseNumber sparseNumber = new NestSparseNumber();
        sparseNumber.findNextSparse(92);
    }
}
