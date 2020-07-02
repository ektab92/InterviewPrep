package com.practice.ds0;

import java.util.Arrays;

public class ToffeeDistribution {
    public static int [] distributeTofee(int p,int c)
    {
        int toffeeCount=0;
        int index=0;
        int toffee[]=new int[p];
        while(c>0)
        {
            index=(toffeeCount++)%p;
            if(c>toffeeCount)
            {

                toffee[index] +=toffeeCount;
                c=c-toffeeCount;
            }
            else {
                toffee[index] += c;
                c=0;
            }

        }

        return toffee;
    }
    public static void main(String[] args) {
        int t[]=distributeTofee(5,25);
        System.out.println(Arrays.toString(t));
    }
}
