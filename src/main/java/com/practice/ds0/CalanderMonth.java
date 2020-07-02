package com.practice.ds0;

public class CalanderMonth {
    private static int findQuaterOfMonth(int start,int target)
    {
        for (int i =1; i <= 12;i++)
        {

            if(i == target)
            {
                int quater =0;
                if(i >= start)
                {
                    quater = ((i-start)/3)+1;
                }
                else
                {
                    quater = 4-((start-1-i)/3);
                }
                return quater;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int quater =findQuaterOfMonth(10,3);
        System.out.println("Quater to which target month belongs : "+quater);
    }
}
