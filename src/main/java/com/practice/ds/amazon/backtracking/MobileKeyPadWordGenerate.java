package com.practice.ds.amazon.backtracking;

import java.util.*;

public class MobileKeyPadWordGenerate {
    String [] map ={"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    static List<String> result = new ArrayList<>();
    private List<String> wordGenerator(int []num)
    {
        StringBuilder sb = new StringBuilder();
        wordgenerateHelper(num,sb,0);
        return result;
    }
    private void wordgenerateHelper(int []num,StringBuilder sb,int index)
    {
     if(index == num.length)
     {
         result.add(sb.toString());
         return;
     }
     String currWord =map[num[index]];
     for(int i =0;i<currWord.length();i++)
     {
         sb.append(currWord.charAt(i));
         wordgenerateHelper(num,sb,index+1);
         sb.setLength(sb.length()-1);
     }
    }
    public static void main(String[] args) {
        int number [] = {2,3,4};
        MobileKeyPadWordGenerate generate = new MobileKeyPadWordGenerate();
        generate.wordGenerator(number);
        System.out.println(result);
    }
}
