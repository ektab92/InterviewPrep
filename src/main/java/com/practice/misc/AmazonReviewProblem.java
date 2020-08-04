package com.practice.misc;

import java.util.*;

public class AmazonReviewProblem {
    // Space complexity is O(n+s) where n is number of keywords, s is number words in reviews[i]
    // Time complexity is O(m + nLogk) where m is the total number of words in reviews,
    // n number of words in keywords and k is size of PriorityQueue
    static List<String> topKFrequent(String[] keywords, String[] reviews, int k) {
        Map<String, Word> map = new HashMap<>();
        // O(n)
        for (String key : keywords) {
            map.put(key, new Word(key, 0));
        }

        // O(m)
        for (String r : reviews) {
            String[] rev = r.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase().split(" ");
            for (String key : rev) {
                if (map.containsKey(key)) {
                    map.put(key, new Word(key, map.get(key).count + 1));
                }
            }
        }

        PriorityQueue<Word> minHeap = new PriorityQueue<Word>((a, b) -> {
            int cmp = a.count - b.count;
            if (cmp != 0) return cmp;
            return a.w.compareTo(b.w);
        });

        // O(nlogk)  since we keep our PriorityQueue within k+1 that why is it logo
        //  if you don't limit your PriorityQueue then you will have nlogn time
        for (Map.Entry<String, Word> entry : map.entrySet()) {
            minHeap.add(entry.getValue());
            if (minHeap.size() > k) minHeap.poll();
        }

        LinkedList<String> list = new LinkedList();

        // O(k) I think since we know  k < n we can disregard this for the Big O
        while (!minHeap.isEmpty()) {
            list.addFirst(minHeap.poll().w);
        }

        return list;

    }

    static class Word {
        String w;
        int count;

        Word(String w, int count) {
            this.w = w;
            this.count = count;
        }
    }


    public static void main(String[] args) {
        int k = 2;
        String[] keywords = new String[]{"anacell", "cetracular", "betacellular"};
        String[] reviews = new String[]{
                "Anacell, provides the best services in the city",
                "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell,"};

        System.out.println(topKFrequent(keywords, reviews, k).toString());
    }
}

