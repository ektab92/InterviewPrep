package com.practice.ds.tree;

import java.util.*;
import java.util.PriorityQueue;

public class HuffManEncoding {
    static class Encode implements Comparable<Encode>{
        char c;
        int freq;
        Encode left;
        Encode right;
        Encode(char c, int freq)
        {
            this.c=c;
            this.freq=freq;
        }
        @Override
        public int compareTo(Encode e1)
        {
            if(this.freq == e1.freq) return 0;
            if(this.freq >e1.freq)  return 1 ;
            else
                return -1;
        }
    }
    static PriorityQueue<Encode> minHeap = new PriorityQueue<>();
    static Map<Character, String> charEncodingMap = new HashMap<Character, String>();
    static private void encodeInputText(PriorityQueue<Encode> minHeap)
    {
        while(minHeap.size() > 1)
        {
            Encode e1 = minHeap.remove();
            Encode e2 = minHeap.remove();
            Encode eNew = new Encode('-',e1.freq+e2.freq);
            eNew.left=e1;
            eNew.right=e2;
            minHeap.add(eNew);
        }
        getEncodingForChar(minHeap.remove(),new String());
        for(char c:charEncodingMap.keySet())
        {
            System.out.println(c+" : "+charEncodingMap.get(c));
        }
    }
    static private void getEncodingForChar(Encode root,String s)
    {
        if(root == null) return;
        if(root.left == null && root.right == null)
        {
            charEncodingMap.put(root.c,s);
            return;
        }
        getEncodingForChar(root.left,s+'0');
        getEncodingForChar(root.right,s+'1');


    }
    public static void main(String[] args) {
        int n = 6;
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };
        for(int i=0;i< charfreq.length;i++)
        {
            Encode e = new Encode(charArray[i],charfreq[i]);
            minHeap.add(e);
        }
        encodeInputText(minHeap);
    }
}
