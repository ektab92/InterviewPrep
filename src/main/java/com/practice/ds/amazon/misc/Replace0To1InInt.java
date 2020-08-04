package com.practice.ds.amazon.misc;

public class Replace0To1InInt {
    private int replace0To5(int num)
    {
        int shadow = num;
        int i=0;
        while(shadow!=0)
        {
            int rem=shadow%10;
            if(rem == 0)
            {
                num = num+5*(int)Math.pow(10,i);
            }
            shadow = shadow/10;
            i++;
        }
        System.out.println(num);
        return num;
    }
    public static void main(String[] args) {
        Replace0To1InInt ops =new Replace0To1InInt();
        ops.replace0To5(1020);
        ops.replace0To5(102000);
        ops.replace0To5(123);

    }
}
