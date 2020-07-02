package com.practice.ds0;

//agbdba
public class LongestPalindromeSubsequence {
    public static int longestPalindrome(String s)
    {
        int N=s.length();
        int dp[][] = new int[N][N];
        //a to a, b to b etc will be length 1
        for(int i=0;i<N;i++)
        {
            dp[i][i]=1;
        }
        //populate DP array

        //start from length 2 as length 1 is handled Above
        //eg ag,sb,etc are 2 length
        //agb,gbd etc are 3 length
        for(int l=2;l<=N;l++)
        {
            //start iterating on each window
            //eg for window 2 -->ag
            //iterate from 0 to 5-2+1 = 4
            //that is ag,gb,bd,da,
            //last index calculated was 4...and it covered 5 as well..by window of length2
            for(int i=0;i<=N-l;i++)
            {
                //end  index of each window
                int j=l+i-1;

                //its a 2 length string and both are equal characters
                if(s.charAt(i)==s.charAt(j) && l==2)
                    dp[i][j]=2;
                //first and last chars of window are equal
                //but length differs
                else if(s.charAt(i)==s.charAt(j))
                {
                    //2 for same chars at start and end of window
                    //and then add values of middle indexes
                    //eg bdb
                    //   234
                    //2+dp[3][3]
                    dp[i][j]=2+dp[i+1][j-1];
                }
                else
                    //understand from dp matrix
                    dp[i][j]=Math.max(dp[i][j-1],dp[i+1][j]);
            }
        }
        System.out.println(dp[0][N-1]);
        findSubString(dp,s,dp[0][N-1]);
        return dp[0][N-1];
    }
    public static String findSubString(int dp[][],String s,int L)
    {
        char [] ans= new char[L];
        int i=0;//starting row
        int j=s.length()-1;//starting column
        System.out.println(j);
        int res=0;
        //execute before diagonal of dp matrix is reached
        while(j>=i)
        {
            if(dp[i][j]==dp[i][j-1])
            {
                j--;
            }
            else if(dp[i][j] == dp[i+1][j])
            {
                i++;
            }

            else
            {
                //insert at ith from start and end
                ans[L-res-1]=s.charAt(j);
                ans[res]=s.charAt(i);
                i++;
                j--;
                res++;
            }
        }
        System.out.println(new String(ans));
        return new String(ans);
    }
    public static void main(String[] args) {
        longestPalindrome("geeksforgeeks");

    }
}
