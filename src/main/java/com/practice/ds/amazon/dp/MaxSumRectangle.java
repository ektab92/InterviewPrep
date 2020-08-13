package com.practice.ds.amazon.dp;

public class MaxSumRectangle {
    /*
    The idea is to fix the left and right columns one by one and find the maximum sum contiguous rows for every left and right column pair using Kadane's
    We basically find top and bottom row numbers (which have maximum sum) for every fixed left and right column pair.
    To find the top and bottom row numbers, calculate sun of elements in every row from left to right and store these sums in an array say temp[].
    So temp[i] indicates sum of elements from left to right in row i.
    If we apply Kadane’s 1D algorithm on temp[], and get the maximum sum subarray of temp,
    this maximum sum would be the maximum possible sum with left and right as boundary columns.
     To get the overall maximum sum, we compare this sum with the maximum sum so far.
     */
    private int findMaxSumRectangle(int[][] matrix)
    {
        int top=0,bottom=0,left=0,right=0;
        int [] aux=new int[matrix.length];
        int L=0,R=0;

        int max_sum_rectangle = Integer.MIN_VALUE;

        for(L=0;L<matrix[0].length;L++)
        {
            for(R=L;R<matrix[0].length;R++)
            {
                if(L==R)
                {
                    for(int k=0;k<matrix.length;k++)
                    {
                        aux[k]=matrix[k][R];
                    }
                }else
                {
                    for(int k=0;k<matrix.length;k++)
                    {
                        aux[k]+=matrix[k][R];
                    }
                }
                //maximum sum array kadane's on aux array
                int max_ending_here=0;
                int max_till_now =Integer.MIN_VALUE;
                int LL=0;
                int RR=0;
                for(int i=0;i< aux.length;i++)
                {
                    if(max_ending_here+aux[i]< aux[i])
                    {
                        max_ending_here=aux[i];
                        LL = i;
                    }else{
                        max_ending_here+=aux[i];
                    }
                    if(max_till_now<max_ending_here)
                    {
                        max_till_now=max_ending_here;
                        RR=i;
                    }
                }
                if(max_sum_rectangle<max_till_now)
                {
                    max_sum_rectangle=max_till_now;
                    top=LL;
                    bottom=RR;
                    left=L;
                    right=R;
                }
            }

        }

        System.out.println("max sum = "+max_sum_rectangle+" top ="+ top +
                            " bottom = "+bottom+" left= "+left+" right ="+right);
        return max_sum_rectangle;
    }
    public static void main(String[] args) {
        int [][]matrix = {{1,2,-1,-4,-20},{-8,-3,4,2,1},{3,8,10,1,3},{-4,-1,1,7,-6}};
        MaxSumRectangle sumRectangle = new MaxSumRectangle();
        sumRectangle.findMaxSumRectangle(matrix);
    }
}
