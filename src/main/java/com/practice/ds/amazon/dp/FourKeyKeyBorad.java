package com.practice.ds.amazon.dp;

public class FourKeyKeyBorad {

    private int maximiseACount(int N)
    {
        int screen[]= new int[N];
        if(N<=6) return N;
        for(int i=1;i<=6;i++)
        {
            screen[i-1]=i;
        }
        for(int n=7;n<=N;n++)
        {
            for (int b = n - 3; b >= 1; b--) {
                //if we break at 4( by zero based indexing its b-1 i.e 3 , then number of times we can write same is
                //7-4-1 = 2
                int curr = screen[b - 1] * (n - b - 1);
                if (curr > screen[n - 1])
                    screen[n - 1] = curr;
            }
        }
        System.out.println(screen[N-1]);
        return screen[N-1];
    }
    public static void main(String[] args) {
        FourKeyKeyBorad keyBorad = new FourKeyKeyBorad();
        keyBorad.maximiseACount(7);
    }
}
