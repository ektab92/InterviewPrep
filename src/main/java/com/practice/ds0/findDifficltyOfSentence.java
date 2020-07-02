package com.practice.ds0;
import java.util.*;

public class findDifficltyOfSentence {
    static int difficultCount=0;
    static int easyCount =0;
    static int difficulty=0;
    static Set <Character> vowels = new HashSet<>();
    public static void findDifficulty(String s)
    {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        String [] words =s.toLowerCase().trim().split("\\s+");
        for(int  i =0; i<words.length;i++)
        {
            int totalConsonants=0;
            int continousConsonants=0;
            int vowelCount =0;
            for(int j =0; j<words[i].length();j++) {
                if (vowels.contains(words[i].charAt(j))) {
                    continousConsonants = 0;
                    vowelCount++;
                } else {
                    continousConsonants++;
                    totalConsonants++;
                }
                if(continousConsonants>=4)
                    break;

            }
            if(vowelCount < totalConsonants || continousConsonants>=4) {
                difficultCount++;
            }
            else
                easyCount++;
        }
        difficulty = 5*difficultCount+3*easyCount;
        System.out.println(difficulty);
    }

    public static void main(String[] args) {
        String s="mafffabcd amarour amarrrr";
        findDifficulty(s);

    }
}
