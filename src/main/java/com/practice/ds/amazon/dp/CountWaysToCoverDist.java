package com.practice.ds.amazon.dp;
/*
Given a distance ‘dist, count total number of ways to cover the distance with 1, 2 and 3 steps.
 */
public class CountWaysToCoverDist {
    private int countWays(int N)
    {
        int count[] = new int[N+1];
        count[0]=1;
        count[1]=1;
        count[2]=2;
        for(int i =3;i<=N;i++)
        {
            count[i]=count[i-3]+count[i-2]+count[i-1];
        }
        System.out.println(count[N]);
        return count[N];
    }
    public static void main(String[] args) {
        CountWaysToCoverDist dpOps = new CountWaysToCoverDist();
        dpOps.countWays(6);

    }
}
