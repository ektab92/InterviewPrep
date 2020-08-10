package com.practice.ds;

import java.util.Arrays;

public class Knapsack01 {
    public void findMaxProfit(int [] wt, int [] profit, int capacity)
    {
        int dp[][] = new int [wt.length+1][capacity+1];
        Arrays.fill(dp[0],0);
        for(int i =0;i< dp.length;i++)
        {
            dp[i][0]=0;
        }
        for(int i=1;i<=wt.length;i++)
        {
            for(int j =1;j<=capacity;j++)
            {
                if(j<wt[i-1])
                {
                    dp[i][j]=dp[i-1][j];
                }
                else
                {
                    dp[i][j] =Math.max(profit[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[wt.length][capacity]);
        //tracing
        int r = wt.length;
        int c = capacity;
        while(c>0 && r>0)
        {
           if(dp[r][c]!= dp[r-1][c])
           {
               System.out.println(wt[r-1]);
               c=c-wt[r-1];
           }
               r=r-1;
        }
    }
    public static void main(String[] args) {
        Knapsack01 knapsack01 = new Knapsack01();
        int profit[] ={4,2,5,6,9,1,3,7,8};
        int wt[] =    {2,3,4,5,8,6,1,7,2};
        knapsack01.findMaxProfit(wt,profit,12);
    }
}
