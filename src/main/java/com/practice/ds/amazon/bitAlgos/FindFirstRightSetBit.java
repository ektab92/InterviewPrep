package com.practice.ds.amazon.bitAlgos;

public class FindFirstRightSetBit {
    public int findFirstSetBitFromRight(int num)
    {
        boolean ans=false;
        int count = 0;
        if(num == 0) return 0;
        int val = 1;
        while(!ans)
        {
            if((int)(num&val) > 0)
                ans=true;
            else {
                val = val << 1;
                count++;
            }
        }
        System.out.println(val);
        return val;
        //return count+1;
    }
    public static void main(String[] args) {
        FindFirstRightSetBit bitOps = new FindFirstRightSetBit();
        int firstSetBit=bitOps.findFirstSetBitFromRight(9^7);
        System.out.println("first set bit from right is : "+firstSetBit);
    }
}
