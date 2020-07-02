package com.practice.ds0;

public class ThirdMax {
    public int thirdMax(int[] arr) {
        //Example {1,2 ,Integer.Min_value}
        long m1 = Long.MIN_VALUE;
        long m2 = Long.MIN_VALUE;
        long m3 = Long.MIN_VALUE;;
        //Empty array check to be added
        if(arr.length == 0)
            return 0;
        for(int i =0 ; i <arr.length ; i++)
        {
            if(arr[i]> m1)
            {
                m3 = m2;
                m2 = m1;
                m1 = (long)arr[i];

            }
            else
            {
                if(arr[i]>m2 && arr[i] != m1)
                {
                    m3 = m2;
                    m2 = (long)arr[i];
                }
                else
                {
                    if(arr[i]> m3 && arr[i] != m1 && arr[i]!= m2)
                        m3=(long)arr[i];
                }
            }
        }
        if(m3 == Long.MIN_VALUE)
            return (int)m1;
        else
            return (int)m3;

    }
}
