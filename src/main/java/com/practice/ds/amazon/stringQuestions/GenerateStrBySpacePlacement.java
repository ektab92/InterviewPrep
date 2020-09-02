package com.practice.ds.amazon.stringQuestions;

import java.util.*;

public class GenerateStrBySpacePlacement {
    List<String>result = new ArrayList<>();

    private void generateStrings(String str)
    {
        int newLength = 2*str.length();
        char[] newStr = new char[newLength];
        newStr[0]=str.charAt(0);
        helper(str,newStr,1,1);
        System.out.println(result);
    }
    private void helper(String s1 , char[] s2,int i,int j )
    {
       if(i == s1.length())
       {
           s2[j]='\0';
           result.add(new String(s2));
           return;
       }
       //inserting space
       s2[j]=' ';
       s2[j+1]=s1.charAt(i);
       helper(s1,s2,i+1,j+2);
       //not inserting space
        s2[j]=s1.charAt(i);
        helper(s1,s2,i+1,j+1);
    }
    public static void main(String[] args) {
        GenerateStrBySpacePlacement strOps = new GenerateStrBySpacePlacement();
        strOps.generateStrings("suman");
    }
}
