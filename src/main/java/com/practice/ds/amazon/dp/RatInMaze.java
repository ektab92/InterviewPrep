package com.practice.ds.amazon.dp;

import java.util.Arrays;

public class RatInMaze {

    public void findtotalPaths(int [][]grid)
    {
        int dp[][] = new int [grid.length][grid[0].length];
        for(int i=0;i<dp.length;i++)
        {
            if(grid[0][i] == 1) break;
            else
            {
                dp[0][i]=1;
            }
        }
        for(int i=1;i<dp.length;i++)
        {
            if(grid[i][0] == 1) break;
            else
            {
                dp[i][0]=1;
            }
        }
        for(int i =1;i< dp.length;i++)
        {
            for(int j=1;j< dp[0].length;j++)
            {
                if(grid[i][j]!= 1 )
                {
                    dp[i][j]= dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        System.out.println(dp[dp.length-1][dp[0].length-1]);
    }
    public void findPathMatrix(int [][]grid)
    {
        int dp[][] = new int [grid.length][grid[0].length];
        for(int i =0;i<dp.length;i++)
        {
            if(grid[0][i] == 1)
                break;
            else
                dp[0][i]=1;
        }
        for(int i =1;i<dp[0].length;i++)
        {
            if(grid[i][0] == 1)
                break;
            else
                dp[i][0]=1;
        }
        for(int i=1;i<grid.length;i++)
        {
            for(int j=1;j<grid[0].length;j++)
            {
                if(grid[i][j] != 1  && (dp[i-1][j]== 1 || dp[i][j-1]==1))
                    dp[i][j]=1;
            }
        }
        for(int i=0;i< grid.length;i++)
            System.out.println(Arrays.toString(dp[i]));
    }
    public static void main(String[] args) {
        //0 represents a path and 1 represents a blocker
        int [][]grid = {{0, 0, 1, 0},{0,0,0,0},{0,0,1,0},{1,1,0,0}};
        RatInMaze mazePuzzle = new RatInMaze();
        mazePuzzle.findPathMatrix(grid);
        mazePuzzle.findtotalPaths(grid);
    }
}
