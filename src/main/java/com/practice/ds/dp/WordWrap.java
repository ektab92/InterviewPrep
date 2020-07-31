package com.practice.ds.dp;
import java.util.*;
class WordWrap {
    public List<String> fullJustify(String[] word, int width) {
        List<String> result = new ArrayList<>();
        int dp[][] = new int[word.length][word.length];
        for(int i=0;i<word.length;i++)
        {
            int len=0;
            for(int j=i;j<word.length;j++)
            {
                len+=word[j].length();
                if(len>width)
                    dp[i][j]=Integer.MAX_VALUE;
                else
                    dp[i][j]=(width-len)*(width-len);
                len+=1;
            }
        }
        /*for(int i=0;i<word.length;i++){
            System.out.println(Arrays.toString(dp[i]));
        }*/
        int cost[]=new int[word.length];
        Arrays.fill(cost,Integer.MAX_VALUE);
        int partition[] = new int[word.length];
        for(int i=word.length-1;i>=0;i--)
        {
            for(int j=word.length-1;j>=i;j--)
            {
                if(dp[i][j]!=Integer.MAX_VALUE)
                {
                    if(j+1<word.length)
                    {
                        if(dp[i][j]+cost[j+1]<cost[i])
                        {
                            cost[i]=dp[i][j]+cost[j+1];
                            partition[i]=j+1;
                        }
                    }
                    else
                    {
                        cost[i]=dp[i][j];
                        partition[i]=j+1;
                    }
                }

            }
        }
        int i=0;
        StringBuilder sb = new StringBuilder();
        while(i<word.length)
        {

            for(int j=i;j<partition[i];j++)
                sb.append(word[j]+" ");
            result.add(sb.toString().trim());
            sb.setLength(0);
            i = partition[i];
        }
        //System.out.println(Arrays.toString(cost));
        //System.out.println(Arrays.toString(partition));
        return result;
    }
}
