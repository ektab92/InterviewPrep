package com.practice.ds0;
import java.util.*;
import java.util.LinkedList;
class Index{
    int row;
    int col;
    Index(int r,int c)
    {
        this.row=r;
        this.col=c;
    }
}
public class CountTimeInFileReplicationAmazon {
    Queue<Index> q = new LinkedList<>();
    int time = 0;
    int R, C;

    private int countTimeForReplication(int server[][]) {
        R = server.length;
        C = server[0].length;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (server[i][j] == 1) {
                    Index pos = new Index(i, j);
                    q.add(pos);
                }
            }
        }
        q.add(null);
        while (!q.isEmpty()) {
            Index curr = q.remove();
            Index newIndexes;
            if (curr != null ) {
                if (curr.row + 1 < R && server[curr.row+1][curr.col ] != 1) {
                    server[curr.row + 1][curr.col] = 1;
                    newIndexes = new Index(curr.row + 1, curr.col);
                    q.add(newIndexes);
                }
                if (curr.col + 1 < R && server[curr.row][curr.col + 1] != 1) {
                    server[curr.row][curr.col + 1] = 1;
                    newIndexes = new Index(curr.row, curr.col + 1);
                    q.add(newIndexes);
                }
                if (curr.row - 1 > 0 && server[curr.row - 1][curr.col] != 1) {
                    server[curr.row - 1][curr.col] = 1;
                    newIndexes = new Index(curr.row - 1, curr.col);
                    q.add(newIndexes);
                }
                if (curr.col - 1 > 0 && server[curr.row][curr.col - 1] != 1) {
                    server[curr.row][curr.col - 1] = 1;
                    newIndexes = new Index(curr.row, curr.col - 1);
                    q.add(newIndexes);
                }
            }
            else
            {
                if(!q.isEmpty())
                {
                    time++;
                    q.add(null);
                }
            }
        }
        return time;
    }


    public static void main(String[] args) {
        int servers[][] = {
                {1, 0, 0, 1},
                {0, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 1}};
        CountTimeInFileReplicationAmazon counter = new CountTimeInFileReplicationAmazon();
        int time =counter.countTimeForReplication(servers);
        System.out.println("Time to copy file to all servers:"+time);

    }
}
