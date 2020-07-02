package com.practice.ds0;

public class LongestPalindromeSubstr {
    int lVal=0;
    int rVal=0;
    int maxLength=0;
    public String longestPalindrome(String s)
    {
        if(s.length() == 0)
            return "";
        for(int i=0;i<s.length();i++)
        {
            int length= checkPalindrome(s,i,i);
            if(length>maxLength)
            {
                maxLength=length;
            }

        }
        return s.substring(lVal+1,rVal-1);
    }
    private int checkPalindrome(String s,int left,int right)
    {
        if(s.length()==0||left>right)
            return 0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
        {
            left--;
            right++;
        }
        if(lVal >= left)
        {
            lVal=left;
        }
        if(rVal<=right)
        {
            rVal=right;
        }
        return right-left+1;
    }

    public static void main(String[] args) {
        String s="babad";
        LongestPalindromeSubstr strOps = new LongestPalindromeSubstr();
        strOps.longestPalindrome(s);
    }
}
