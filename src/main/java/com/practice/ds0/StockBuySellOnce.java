package com.practice.ds0;

public class StockBuySellOnce {
    public static int maxProfit(int[] arr) {
        //idea is to keep track of profit.
        //initialise first index as min and maxprofit as zero
        //if min is less than or equal any index element, update min
        // else find profit and update maxprofit

        int min = arr[0];
        int maxProfit = 0;
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] <= min)
            {
                min = arr[i];
            }
            else {
                int profit = arr[i] - min;
                if (profit > maxProfit)
                    maxProfit = profit;
            }

        }
        return maxProfit;

    }
    public static void main(String[] args) {
        int arr[]= {7,1,5,3,6,4,11,0,2,3};
        int profit =maxProfit(arr);
        System.out.println("the profit :"+profit);
    }

}
