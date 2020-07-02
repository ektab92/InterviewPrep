package com.practice.ds0;
import java.util.*;

public class LetterCasePermutation {
    static List <String> list = new ArrayList<>();
    public static List<String> LetterCasePermutation(String s)
    {
        if(s.length() == 0)
        {
            list.add("");
            return list;
        }

        permutationHelper(s.toCharArray(),0);
        return list;
    }
    public static void permutationHelper(char []s, int index)
    {
        if(s.length == index)
        {
            list.add(new String(s));
            return;
        }
        if(Character.isDigit(s[index]))
            permutationHelper(s,index+1);
        else
        {
            char temp = s[index];
            s[index]=Character.toUpperCase(s[index]);
            permutationHelper(s,index+1);
            s[index]=Character.toLowerCase(s[index]);
            permutationHelper(s,index+1);
            s[index]=temp;
        }

    }
    public static void main(String[] args) {
        LetterCasePermutation("a1B2c");
        System.out.println(list);
    }
}
