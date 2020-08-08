package com.practice.ds.amazon.arrays;

public class MobileKeyPadTyping {
    int count =0;
    int val =0;
     private int findTotalNumbers(char[][]grid,int N)
     {
         for(int i=0;i< grid.length;i++)
         {
             for(int j=0;j< grid[0].length;j++)
             {
                 val = N;
                 dfs(i,j,grid);
             }
         }
         System.out.println(count);
         return count;
     }
     private void dfs (int r,int c,char [][]grid)
     {
         val--;
         if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c] == '*' || grid[r][c]=='#')
         {
             return ;
         }
         if(val <= 0)
         {
             count++;
             return;
         }

         dfs(r,c,grid);
         dfs(r+1,c,grid);
         dfs(r,c+1,grid);
         dfs(r-1,c,grid);
         dfs(r,c-1,grid);
     }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','2','3'},
                {'4','5','6'},
                {'7','8','9'},
                {'*','0','#'}
        };
        MobileKeyPadTyping gridOps = new MobileKeyPadTyping();
        gridOps.findTotalNumbers(grid,3);
    }
}
