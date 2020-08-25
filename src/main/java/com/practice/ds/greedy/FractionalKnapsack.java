package com.practice.ds.greedy;

import java.beans.FeatureDescriptor;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class FractionalKnapsack {
    private class PerUnitProfit implements Comparable<PerUnitProfit>
    {
        double perUnitProfit;
        int index;
        PerUnitProfit(double profit,int i)
        {
            this.perUnitProfit=profit;
            this.index=i;
        }

        @Override
        public int compareTo(PerUnitProfit o) {
            if(this.perUnitProfit == o.perUnitProfit)
                return 0;
            if(this.perUnitProfit > o.perUnitProfit)
                return 1;
            else
                return -1;
        }
    }
    public  void findMaxProfit(int []wt, int []profit,int capacity)
    {
        double totalProfit=0.0;
        //inclusionArr;
        double[] inclusionArr = new double [profit.length];
        PerUnitProfit unitProfitObj = null;
        PriorityQueue <PerUnitProfit> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i =0;i< wt.length;i++)
        {
            unitProfitObj = new PerUnitProfit(((double)profit[i]/wt[i]),i);
            maxHeap.add(unitProfitObj);
        }
        while(capacity>0 && !maxHeap.isEmpty())
        {
            int index = maxHeap.remove().index;
            if(wt[index]<=capacity ) {
                inclusionArr[index] = 1;
                capacity=capacity-wt[index];
            }
            else
            {
                inclusionArr[index]= (double)capacity/wt[index];
                capacity=0;
            }
        }

        for(int i =0;i< inclusionArr.length;i++)
        {
            totalProfit+=inclusionArr[i]*profit[i];
        }
        System.out.println(Arrays.toString(inclusionArr));
        System.out.println(totalProfit);
    }
    public static void main(String[] args) {
            int wt[] = {2,3,5,7,1,4,1};
            int profit[] = {10,5,15,7,6,18,3};
            FractionalKnapsack knapsack = new FractionalKnapsack();
            knapsack.findMaxProfit(wt,profit,15);
    }
}
