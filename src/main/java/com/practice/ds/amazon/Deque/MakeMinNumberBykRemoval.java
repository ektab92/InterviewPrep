package com.practice.ds.amazon.Deque;

import java.util.Deque;
import java.util.LinkedList;

//76502831 n=5
public class MakeMinNumberBykRemoval {
    Deque <Integer> dQ = new LinkedList<>();
    private void generateMin(String number,int index,int n)
    {
        while(index <number.length())
        {
            int num = (int) number.charAt(index) - '0';
            while (!dQ.isEmpty() && dQ.peekLast() >= num && n >= 1)
            {
                dQ.removeLast();
                n--;
            }
            dQ.addLast(num);
            index++;
        }
        StringBuilder sb = new StringBuilder();
        while(!dQ.isEmpty())
        {
            sb.append(dQ.removeFirst());
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        MakeMinNumberBykRemoval qOps = new MakeMinNumberBykRemoval();
        qOps.generateMin("76502831",0,4);
    }
}
