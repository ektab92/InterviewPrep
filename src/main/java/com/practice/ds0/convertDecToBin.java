package com.practice.ds0;

public class convertDecToBin {
    public static void decToBinary(int num)
    {
        int mod;
        StringBuilder str;
        if(num == 0)
            System.out.println(0);
        else
        {
            str = new StringBuilder();
            while(num != 0)
            {
                //mod = num%2;
                mod = num & 1;
                str.append(mod);
                //num = num/2;
                num = num >>  1;

            }
            System.out.println(str.reverse());
        }

    }
    public static void main(String[] args) {
        decToBinary(17);
    }
}
