package com.practice.ds.amazon.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Steps:-
 *     1. Generate all rotations of given boxes,on the basis with constraint :- l>w
 *     2. Sort the generated boxes on basis of base area l*w
 *     3. Find longest decreasing sequence, by :-
 *         3.1  initialise dp array(height of each box at each index assuming default 1 box is stacked)
 *              and path array (-1)
 *         3.2 comparing l1 Of box1 > l2 of box2 && w1 of box1 >w2 of box2
 *             add height to dp[i] if decresing sequence found and maximise this height
 *     4. find the maximum in dp array, which denotes the length of max stack we can make
 *     5. trace path and print boxes.
 */
public class BoxStacking {

    private int [][] generateRotations(int[][]inputBoxes)
    {
        //inputBoxes[i][0]=Length,inputBoxes[i][1]=Width,inputBoxes[i][2]=Length[i][2]
        //generating all possible rotations on the basis with constraint, l>w
        int [][]boxes= new int[inputBoxes.length*3][3];
        for(int i =0;i< inputBoxes.length;i++)
        {
           int l = inputBoxes[i][0];
           int w = inputBoxes[i][1];
           int h = inputBoxes[i][2];
           boxes[3*i]=new int[]{Math.max(l,w),Math.min(l,w),h};
           boxes[3*i+1]=new int[]{Math.max(l,h),Math.min(l,h),w};
           boxes[3*i+2]= new int[]{Math.max(w,h),Math.min(w,h),l};
        }
        return boxes;
    }
    private int stackBoxes(int [][]boxes)
    {
       int [][]possibleRotations =generateRotations(boxes);
        //comparator logic to sort on basis of base area i.e l*w
        Comparator<int []>c = new Comparator<int[]>() {
            @Override
            public int compare(int[] d1, int[] d2) {
                if(d1[0]*d1[1]==d2[0]*d2[1])
                    return 0;
                if(d1[0]*d1[1]>d2[0]*d2[1])
                    return -1;
                else
                    return 1;
            }
        };

        Arrays.sort(possibleRotations,c);

        //path matrix and dp matrix
        int dp [] = new int [possibleRotations.length];
        //worst case, each box is independently stacked to best height is h of box
        for(int i=0;i< possibleRotations.length;i++)
        {
            dp[i]= possibleRotations[i][2];
        }
        int path[] = new int [possibleRotations.length];
        Arrays.fill(path,-1);

        for(int i =1;i< possibleRotations.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(possibleRotations[i][0]< possibleRotations[j][0] &&
                        possibleRotations[i][1]< possibleRotations[j][1])
                {
                    int height = possibleRotations[i][2];
                    if(dp[i]<height+dp[j])
                    {
                        dp[i]=height+dp[j];
                        path[i]=j;
                    }
                }
            }
        }
        int max=Integer.MIN_VALUE;
        int bestIndex=-1;
        for(int i=0;i<dp.length;i++)
        {
            if(dp[i]>max)
            {
                max=dp[i];
                bestIndex=i;
            }
        }
        while(bestIndex >=0)
        {
            System.out.println(Arrays.toString(possibleRotations[bestIndex]));
            bestIndex= path[bestIndex];
        }
        System.out.println(max);
        return max;
    }
    public static void main(String[] args) {
        int[][] boxTypes = {
                {7, 6, 4},
                {3, 2, 1},
                {6, 5, 4},
                {32, 12, 10}
        };
        BoxStacking stacker = new BoxStacking();
        stacker.stackBoxes(boxTypes);
    }
}
