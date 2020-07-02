package com.practice.ds0;

import java.util.Arrays;

public class PermutationCount {
    public static boolean checkInclusion(String s2, String s1) {
        int s2_arr[] = new int[26];
        int s1_arr[] = new int[26];
        int flag=1;

        for(int i =0; i <s2.length();i++)
        {
            s2_arr[s2.charAt(i)-'a']++;
        }
        for(int i =0; i <s2.length();i++)
        {
            s1_arr[s1.charAt(i)-'a']++;
        }
        for(int i =1; i<=s1.length()-s2.length();i++)
        {
            System.out.println("---------------------------");
            System.out.println("i = " + i);
            System.out.println(Arrays.toString(s1_arr));
            System.out.println(Arrays.toString(s2_arr));
            System.out.println("---------------------------");
            for(int j = 0; j < s1_arr.length;j++)
            {
                if(s1_arr[j] != s2_arr[j])
                {
                    flag=0;
                    break;
                }else{
                    flag = 1;
                }
            }
            if(flag ==1)
                return true;
            s1_arr[s1.charAt(i-1)-'a']--;
            s1_arr[s1.charAt(i+s2.length()-1)-'a']++;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1= "eidbaooo";
        String s2="ab";
        checkInclusion(s2,s1);
    }
}
