package com.practice.ds0;
import java.util.*;
class SecretNode{
    int count;
    Set<Integer>indices=new HashSet<>();
    SecretNode(int count)
    {
        this.count = count;
    }
}
public class CowsAndBulls {
    int B=0;
    public String getHint(String secret, String guess) {
        StringBuilder sb = new StringBuilder();
        Map<Character,SecretNode> secretMap = new HashMap<>();
        for(int i =0; i < secret.length();i++)
        {
            if(!secretMap.containsKey(secret.charAt(i)))
            {
                SecretNode sNode = new SecretNode(1);
                sNode.indices.add(i);
                secretMap.put(secret.charAt(i),sNode);
            }
            else
            {
                SecretNode sNode=secretMap.get(secret.charAt(i));
                sNode.count++;
                sNode.indices.add(i);
            }
        }
        Map <Character,Integer> answerMap = new HashMap<>();
        Map <Character,Integer> bulls = new HashMap<>();
        int bullsCount=0;
        for(int i =0; i < guess.length();i++)
        {
            if(!answerMap.containsKey(guess.charAt(i)))
            {
                answerMap.put(guess.charAt(i),1);
            }
            else
            {
                int count = answerMap.get(guess.charAt(i));
                answerMap.put(guess.charAt(i),++count);
            }
        }
        for(int i =0 ; i< guess.length();i++)
        {
            // if(!secretMap.containsKey(guess.charAt(i)))
            //     i++;
            //else
            if (secretMap.containsKey(guess.charAt(i)) &&
                    secretMap.get(guess.charAt(i)).indices.contains(i))
            {
                if(!bulls.containsKey(guess.charAt(i)))
                {
                    bulls.put(guess.charAt(i),1);
                }
                else
                {
                    int count = bulls.get(guess.charAt(i));
                    bulls.put(guess.charAt(i),++count);
                }
            }

        }
        for(char i :bulls.keySet())
        {
            bullsCount += bulls.get(i);
        }
        for(char i :answerMap.keySet())
        {
            if(secretMap.containsKey(i))
                B+= Math.min(answerMap.get(i),secretMap.get(i).count)-bulls.getOrDefault(i,0);
        }
        sb.append(bullsCount).append('A').append(B).append('B');
        return sb.toString();
    }

}
