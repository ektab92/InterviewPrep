package com.practice.ds.amazon.graphs;

public class LargestRegion {
    int regionLength=0;
    int maxLength=0;
    private int findLengthOfLargstRegion(int[][]matrix)
    {
        int N = matrix.length;
        int M = matrix[0].length;
        int [][]visited = new int[N][M];
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(visited[i][j]!=1 && matrix[i][j]==1)
                {
                    regionLength=0;
                    dfs(i,j,matrix,visited);
                    maxLength=Math.max(maxLength,regionLength);
                }
            }
        }
        System.out.println(maxLength);
        return maxLength;
    }
    private void dfs(int r,int c,int [][]matrix,int [][]visited)
    {

        if(r<0 ||c<0 ||r>= matrix.length||c>=matrix[0].length||visited[r][c]==1 || matrix[r][c]==0)
        {
            return;
        }
        visited[r][c]=1;
        regionLength++;
        dfs(r+1,c+1,matrix,visited);
        dfs(r+1,c-1,matrix,visited);
        dfs(r-1,c-1,matrix,visited);
        dfs(r-1,c+1,matrix,visited);
        dfs(r+1,c,matrix,visited);
        dfs(r,c+1,matrix,visited);
        dfs(r-1,c,matrix,visited);
        dfs(r,c-1,matrix,visited);
    }

    public static void main(String[] args) {
        int M[][] = {
                { 0, 0, 1, 1, 0 },
                { 1, 0, 1, 1, 0 },
                { 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 1 }
        };
        LargestRegion regionCounter = new LargestRegion();
        regionCounter.findLengthOfLargstRegion(M);
    }
}
