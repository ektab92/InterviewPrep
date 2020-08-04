package com.practice.ds.strings;

public class DistBtwnSubsqnce {
    private void findDistance(String s,String target)
    {
        int i=0;int j=0;
        int  firstEnd=-1;
        int secondStart=-1;
        while(j<target.length() && i<s.length())
        {
            if(s.charAt(i)==target.charAt(j))
            {
                if(firstEnd>=0 && secondStart<0)
                {
                    secondStart=i;
                }
                j++;
                if(j==target.length())
                {
                    if(firstEnd == -1) {
                        firstEnd = i;
                        j = 0;
                    }
                    else
                    {
                        break;
                    }
                }
            }
            i++;
        }
        if(j==target.length())
            System.out.println(secondStart-firstEnd);
        else
            System.out.println(-1);
        System.out.println("last occurence "+ firstEnd);
        System.out.println("second occurence first char "+secondStart);
    }
    public static void main(String[] args) {
        DistBtwnSubsqnce stringOps = new DistBtwnSubsqnce();
        String s ="helggglvvvoghthuuellppo";
        //String s="progxrammerxxproxgxrammer";
        //String s="ekmmgtxxaytzeykuuta";
        //String target="ekta";
        //String target ="programmer";
        String target = "hello";
        stringOps.findDistance(s,target);
    }
}
