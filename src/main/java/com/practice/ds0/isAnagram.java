package com.practice.ds0;
import java.util.*;
public class isAnagram {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> newmap = new HashMap<>();
        for(int i =0; i<s.length();i++)
        {
            if(!map.containsKey(s.charAt(i)))
            {
                map.put(s.charAt(i),1);
            }
            else
            {
                int count= map.get(s.charAt(i));
                map.put(s.charAt(i),++count);
            }

        }
        for(int i =0; i< t.length();i++)
        {

            if(!map.containsKey(t.charAt(i)))
                return false;
            else
            {
                if(!newmap.containsKey(t.charAt(i)))
                {
                    newmap.put(t.charAt(i),1);
                }
                else
                {
                    int m1Count=map.get(t.charAt(i));
                    int m2Count=newmap.get(t.charAt(i));
                    if(m1Count>m2Count)
                    {
                        newmap.put(t.charAt(i),++m2Count);
                    }
                    else
                        return false;
                }

            }
        }


        return true;
    }

    public static void main(String[] args) {
        isAnagram("aacc","ccac");
    }
}
