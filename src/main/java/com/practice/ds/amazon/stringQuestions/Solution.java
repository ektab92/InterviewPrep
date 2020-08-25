package com.practice.ds.amazon.stringQuestions;

class Solution {
    public String minWindow(String s, String t) {
        int []sMap = new int[256];
        int []tMap = new int[256];
        int minLength=Integer.MAX_VALUE;
        int length=0;
        //boolean unEqual=false;
        int bestL=0;
        int bestR=0;
        for(int i =0;i<t.length();i++)
        {
            tMap[t.charAt(i)]++;
        }
        int l =0,r=0,i=0;
        while(r<s.length())
        {
            sMap[s.charAt(r)]++;
            r++;
            for(i=0;i<tMap.length;i++)
            {
                if(tMap[i] >sMap[i])
                {
                    //unEqual = true;
                    break;
                }
            }
            if(i == tMap.length)
            {
                length = r-l;
                if(minLength>length)
                {
                    bestL=l;
                    bestR=r;
                    minLength=length;
                }
                while(sMap[s.charAt(l)]-1 >= tMap[s.charAt(l)])
                {
                    sMap[s.charAt(l)]--;
                    l++;
                }
                length = r-l;
                if(minLength>length)
                {
                    bestL=l;
                    bestR=r;
                    minLength=length;
                }
            }
        }
        if(s.substring(bestL,bestR).length() == 0)
            return "impossible";
       return s.substring(bestL,bestR);
    }

    public static void main(String[] args) {
        //"ADOBECODEBANCP"
        //"ABC"
        String s = "ADODECODEDANCPACC";
        String t = "ABC";
        Solution solution = new Solution();
        System.out.println(solution.minWindow(s,t));
    }
}
