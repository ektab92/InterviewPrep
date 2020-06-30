package com.practice.java;

import java.util.*;

public class PriorityQTesting {
    private static class FreqCount implements Comparable<FreqCount>{
        int data;
        int freq;

        public FreqCount(int data, int freq){
            this.data = data;
            this.freq = freq;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof FreqCount)) return false;
            FreqCount freqCount = (FreqCount) o;
            return data == freqCount.data;
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }

        @Override
        public int compareTo(FreqCount other){
            if(this.freq == other.freq) return 0;
            return this.freq > other.freq? 1:-1;
        }
    }
    public static void main(String[] args) {
        Map<Integer, FreqCount> freqMap = new HashMap<>();
        PriorityQueue<FreqCount> maxHeap = new PriorityQueue<FreqCount>(Collections.reverseOrder());
        int[] arr = {1,2,3,4,1,2,2,6,7,1,2,4,5,4,4};
        for(int i=0;i<arr.length;i++){
            FreqCount c = freqMap.getOrDefault(arr[i], new FreqCount(arr[i],0));
            //maxHeap.remove(c);
            if(!maxHeap.contains(c)){
                c.freq++;
                maxHeap.add(c);
            }else {
                c.freq++;
            }
            freqMap.put(arr[i], c);
            System.out.println(maxHeap.peek().data +" : "+ maxHeap.peek().freq);
        }
    }
}
