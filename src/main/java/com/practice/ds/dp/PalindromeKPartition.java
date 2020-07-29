package com.practice.ds.dp;
import java.util.*;
public class PalindromeKPartition {
    List<String> result = new ArrayList<>();
    public List<String> minCut(String s,int k) {
        if(s.length() ==0) return result;
        boolean P[][] = new boolean[s.length()][s.length()];
        for(int i =0;i<s.length();i++)
        {
            P[i][i]=true;
        }
        for(int l=2;l<=s.length();l++)
        {
            for(int i=0;i<=s.length()-l;i++)
            {
                int j = l+i-1;
                if(s.charAt(i)==s.charAt(j) && l ==2 )
                {
                    P[i][j]=true;
                }
                else
                if(s.charAt(i)==s.charAt(j) && P[i+1][j-1] )
                {
                    P[i][j]=true;
                }
            }
        }
        int cuts[]= new int [s.length()];
        for(int i=0;i<s.length();i++)
        {
            if(P[0][i])
                cuts[i]=0;
            else
            {
                cuts[i]=Integer.MAX_VALUE;
                for(int j=0;j<i;j++)
                {
                    if(P[j+1][i] && 1+cuts[j]<cuts[i] )
                    {
                        cuts[i]=1+cuts[j];
                    }
                }
            }
        }
        if(cuts[s.length()-1]+1<k)
            result.add("Impossible");
        else
            helper(P,k,s.length()-1,s);
        System.out.println(result);
        return result;
    }
    public boolean helper(boolean [][]P,int k,int j,String s)
    {
        //if j reached beyond start of string and all k partitions are not found

        if(j <0 && k >0) return false;

        //if found k partitions and j has reaching beginning
        if(j <0 && k == 0) return true;

        //if 1 partition was left and from 0 to curr, the string was not palindrome
        if(k == 1 && !P[0][j])
            return false;
        //if 1 partition was left and from 0 to curr, the string was  palindrome
        else if(k == 1 && P[0][j])
        {
            result.add(s.substring(0, j + 1));
            return true;
        }
        //else search in palindrome matric where we found true
        for(int i =0;i<=j;i++)
        {
            if(P[i][j])
            {
                if(helper(P,k-1,i-1,s))
                {
                    result.add(s.substring(i,j+1));
                    return true;
                }
            }
        }
       return false;
    }

    public static void main(String[] args) {
        String s ="ababbbc";
        PalindromeKPartition partition = new PalindromeKPartition();
        partition.minCut(s,3);
    }
}
