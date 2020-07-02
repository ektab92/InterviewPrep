package com.practice.ds0;

public class findLandBodies {
    static int R,C;
    static int visited[][];

    public static int findIslands(int mapInfo[][]) {
        visited = new int[mapInfo.length][mapInfo[0].length];
        int countIslands = 0;

        R = mapInfo.length;
        C = mapInfo[0].length;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (mapInfo[i][j] == 1 && visited[i][j] != 1) {
                    dfs(mapInfo, i, j);
                    countIslands = countIslands + 1;
                }
            }
        }
        return countIslands;
    }

    private static void dfs(int mapInfo[][],int r,int c)
    {
       if(r >= R  || c>= C ||r<0 || c<0 )
           return;
       visited[r][c]=1;
        System.out.println("r : "+r +"c: "+c);

        if( r-1 >=0 &&mapInfo[r-1][c]==1 && visited[r-1][c]!=1)
           dfs(mapInfo,r-1,c);
       if(c-1>=0 && mapInfo[r][c-1]==1 && visited[r][c-1]!=1)
           dfs(mapInfo,r,c-1);
       if(r<R-1 && mapInfo[r+1][c]==1 && visited[r+1][c]!=1)
           dfs(mapInfo,r+1,c);
       if(c<C-1 && mapInfo[r][c+1]==1 && visited[r][c+1]!=1)
           dfs(mapInfo,r,c+1);
    }
    static int N;
    static int M;
    static int visit[][];
    private static int findIslandsinGlobe(int mapInfo[][])
    {
        N=mapInfo.length;
        M=mapInfo[0].length;
        visit=new int[N][M];
        int count=0;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(visit[i][j] != 1 && mapInfo[i][j]!=0)
                {
                    findcircularIsland(mapInfo,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    private static void findcircularIsland(int arr[][],int s,int e)
    {
        if(arr[s][e] ==0)
            return;
        visit[s][e]=1;
        if(visit[(s+1)%N][e] != 1 )
            findcircularIsland(arr,(s+1)%N,e);

        if(visit[s][(e+1)%M] != 1)
            findcircularIsland(arr,s,(e+1)%M);

        if(visit[(s-1+N)%N][e] != 1)
            findcircularIsland(arr,(s-1+N)%N,e);

        if(visit[s][(e-1+M)%M] != 1)
            findcircularIsland(arr,s,(e-1+M)%M);

    }
    public static void main(String[] args) {
        int mapInfo[][]={
                {1,0,0,1},
                {0,1,1,0},
                {1,1,1,0},
                {0,0,0,1},
                {0,1,0,1}};
        //int islands=findIslands(mapInfo);
        int islands = findIslandsinGlobe(mapInfo);
        System.out.println("isalnd count : "+islands);

    }
}
