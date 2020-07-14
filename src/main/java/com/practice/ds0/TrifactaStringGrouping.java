package com.practice.ds0;
import java.util.*;
/* iterate over each string in the input, prepare a set of unique character for each string,
    make a map of String, String, which stores word and its unque character(convert above set to String and then save as value of map)
    now you have string, uniqyechar map
    iterate over this map and prepare another map which has key as common values of map 1 and value as key of map1, (means words of given string)
 */
public class TrifactaStringGrouping {
    public List<List<String>> groupStrings(String [] input)
    {
        Set <Character> distinctChars;
        Map<String,String> wordUniqueCharSet = new HashMap<>();
        Map<String,List<String>>resultGroup = new HashMap<>();
        StringBuilder sb;
        for(int i =0;i <input.length;i++)
        {
            sb = new StringBuilder();
            distinctChars = new TreeSet<>();
            for(int j =0; j < input[i].length();j++)
            {

                distinctChars.add(input[i].charAt(j));
            }
            for(char k :distinctChars)
            {
                sb.append(k);
            }
            wordUniqueCharSet.put(input[i],sb.toString());
        }
        for(String k : wordUniqueCharSet.keySet())
        {
            List  similarWords = resultGroup.getOrDefault(wordUniqueCharSet.get(k),new ArrayList<>());
            similarWords.add(k);
            resultGroup.put(wordUniqueCharSet.get(k),similarWords);
        }
      return new ArrayList<>(resultGroup.values());
    }

    public static void main(String[] args) {
        String [] input = {"make","ekame","mkea","mmkket","tmek","ktme","amop","pmo","mnop","pnmo","aekm"};
        TrifactaStringGrouping stringGrouping = new TrifactaStringGrouping();
        List <List<String>> result =stringGrouping.groupStrings(input);
        for(List<String> l : result)
        {
            System.out.println(l);
        }
    }
}
