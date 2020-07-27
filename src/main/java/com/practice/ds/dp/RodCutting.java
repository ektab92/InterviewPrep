package com.practice.ds;

import java.util.Arrays;

public class RodCutting {
    public void findMaxProfit(int []len, int[]profit,int length)
    {
        int dp[][]=new int[profit.length+1][length+1];
        Arrays.fill(dp[0],0);
        for(int i =0;i<dp.length;i++)
        {
            dp[i][0]=0;
        }
        for(int i =1;i<dp.length;i++)
        {
            for(int j =1;j<dp[0].length;j++)
            {
                if(j<len[i-1])
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    dp[i][j]= Math.max(profit[i-1]+dp[i][j-len[i-1]],dp[i-1][j]);
                }
            }
        }
        for(int i=0;i< dp.length;i++)
        {
            System.out.println(Arrays.toString(dp[i]));
        }

        int r = dp.length-1;
        int c = dp[0].length-1;

        while(length>0)
        {
            while(dp[r][c] == dp[r-1][c])
            {
                r=r-1;
            }
            System.out.println(len[r-1]);
            length = length-len[r-1];
            c= length;
        }
        System.out.println(dp[dp.length-1][dp[0].length-1]);
    }
    public static void main(String[] args) {

        int  profit [] = {3,2,2,1,3,16};
        int  len[] =      {4,3,2,1,5,6};
        RodCutting rodCut = new RodCutting();
        rodCut.findMaxProfit(len,profit,8);
    }
}
