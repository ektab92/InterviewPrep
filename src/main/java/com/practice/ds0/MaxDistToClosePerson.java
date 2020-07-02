package com.practice.ds0;

public class MaxDistToClosePerson {
        public static int maxDistToClosest(int[] seats) {
            int maxdiff=-1;
            int start=-1;
            for(int i =0; i <seats.length;i++)
            {

                if(seats[i] == 1 && start == -1 )
                {

                    start = i;
                    maxdiff = i;
                }
                else if(seats[i] == 1 && start != -1 )
                {
                    start =i;
                    maxdiff = Math.max(maxdiff,(i-start)/2);
                }
            }
            maxdiff = Math.max(maxdiff, (seats.length-1-start));
            return maxdiff;
        }


    public static void main(String[] args) {
        int arr[] = {1,0,0,0,1,0,0,1,0,1};
        maxDistToClosest(arr);

    }
}
