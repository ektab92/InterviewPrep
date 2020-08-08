package com.practice.ds.amazon.backtracking;

import java.util.Arrays;

public class KnightTourProblem {
    boolean boardVisited=false;
    private void knightTourFinder(int startRow,int startCol,int N)
    {
        int [][]board = new int[N][N];
        for(int i =0;i<N;i++)
        {
            Arrays.fill(board[i],-1);
        }
        knightTourMatrix(startRow,startCol,board,N,1);
        for(int i =0;i< board.length;i++)
            System.out.println(Arrays.toString(board[i]));
    }
    private void knightTourMatrix(int startRow,int startCol,int board[][],int N,int currMove)
    {
        if(currMove >N*N)
            boardVisited=true;
        if(startRow<0 || startCol<0 || startCol>=N || startRow>=N || board[startRow][startCol] != -1)
            return;
        board[startRow][startCol]=currMove;
        knightTourMatrix(startRow+2,startCol+1,board,N,currMove+1);
        knightTourMatrix(startRow-2,startCol+1,board,N,currMove+1);
        knightTourMatrix(startRow+2,startCol-1,board,N,currMove+1);
        knightTourMatrix(startRow-2,startCol-1,board,N,currMove+1);
        knightTourMatrix(startRow+1,startCol+2,board,N,currMove+1);
        knightTourMatrix(startRow+1,startCol-2,board,N,currMove+1);
        knightTourMatrix(startRow-1,startCol+2,board,N,currMove+1);
        knightTourMatrix(startRow-1,startCol-2,board,N,currMove+1);
        if(!boardVisited)
            board[startRow][startCol]=-1;
    }
    public static void main(String[] args)
    {
        KnightTourProblem knightTour = new KnightTourProblem();
        knightTour.knightTourFinder(0,0,8);
    }
}
