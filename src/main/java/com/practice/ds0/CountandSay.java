package com.practice.ds0;

public class CountandSay {
    public static String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }
        if(n == 2)
            return "11";
        String start = "11";
        StringBuilder result = new StringBuilder();
        for(int i =3;i <=n;i++) {
            int j = 1;
            int tempCount = 1;
            while (j < start.length()) {

                if (start.charAt(j) == start.charAt(j - 1)) {
                    tempCount++;
                } else {
                    result.append(tempCount + "" + start.charAt(j - 1));
                    tempCount = 1;
                }
                j++;
            }
            result.append(tempCount + "" + start.charAt(j - 1));
            start = result.toString();
            result.setLength(0);

        }

        System.out.println(start);
        return start;

    }
    public static String countAndSay2(int n) {
        if(n == 1)
            return "1";
        if(n == 2)
            return "11";
        String start = "11";
        StringBuilder result = new StringBuilder();
        for(int i = 3; i <=n ;i++)
        {
            int count =1;
            char prev = start.charAt(0);
            for(int j =1;j <start.length();j++)
            {
                if(start.charAt(j)==prev)
                {
                    count++;

                }
                else
                {
                    result.append(count).append(prev);
                    prev = start.charAt(j);
                    count =1;
                }
            }
            //to append the last char which wont be considered in above loop
            result.append(count).append(prev);
            start = result.toString();
            result.setLength(0);
        }
        return start;

    }
    public static void main(String[] args) {
        countAndSay(5);
    }
}
