package com.practice.ds0;
import java.util.*;

public class RevereseVowels {
    public static String reverseVowels(String s) {
        if(s.length()==0)
            return "";
        if(!s.isEmpty() && s.trim().isEmpty())
            return s;
        Set <Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int i = 0;
        int j = s.length()-1;
        s = s.trim();
        char[] arr = s.toCharArray();
        while(i<j){
            if(set.contains(arr[i]) && set.contains(arr[j]))
            {
                Character temp = arr[i];
                arr[i] = arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
            else
            {
                if(!set.contains(arr[i]))
                {
                    i++;
                }
                else if(!set.contains(arr[j]))
                {
                    j--;
                }
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        reverseVowels(" apG0i4maAs::sA0m4i0Gp0");
    }
}
