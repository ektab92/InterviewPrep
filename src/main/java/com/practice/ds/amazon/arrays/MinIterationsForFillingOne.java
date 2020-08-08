package com.practice.ds.amazon.arrays;

//1,0,0,0,0,0,1,0,0,0,1,0,0,1
public class MinIterationsForFillingOne {

    private int findMinIterations(int [] arr)
    {
        if(arr.length == 0) return 0;
        int i=0;
        boolean foundOne=false;
        int zeroCount=0;
        int res = 0;
        while(i<arr.length)
        {

            if(arr[i] == 1)
                foundOne=true;
            while(i<arr.length && arr[i] == 1)
                i++;

            while(i<arr.length && arr[i] == 0)
            {
                zeroCount++;
                i++;
            }
            int currCount=0;
            if(!foundOne && i>=arr.length ) return -1;
            if(foundOne )
            {
                if(zeroCount%2 == 0)
                    currCount = zeroCount/2;
                else
                    currCount = (zeroCount+1)/2;
                zeroCount=0;
            }
            else
            {
                currCount =zeroCount;
                zeroCount=0;
            }
        res = Math.max(res,currCount);
        }
        return res ;
    }

    public static void main(String[] args) {
        int arr[]={0,1,0,0,1,0,0,0,0,0,0,0,1,0};
        MinIterationsForFillingOne oneFiller = new MinIterationsForFillingOne();
        int iterations =oneFiller.findMinIterations(arr);
        System.out.println("no of iterations are : "+iterations);
    }
}
