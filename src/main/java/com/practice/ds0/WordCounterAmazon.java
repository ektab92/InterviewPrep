package com.practice.ds0;
import java.util.*;
/*k = 2
keywords = ["anacell", "cetracular", "betacellular"]
reviews = [
"Anacell provides the best services in the city",
"betacellular has awesome services",
"Best services provided by anacell, everyone should use anacell",
]*/
class StringCountDS implements Comparable<StringCountDS>{
    String word;
    int count;
    StringCountDS(String word,int count)
    {
        this.word=word;
        this.count=count;
    }

    @Override
    public int compareTo(StringCountDS o) {
        if(this.count == o.count)
            return 0;
        if(this.count>o.count)
            return 1;
        else
            return -1;
    }
}
public class WordCounterAmazon {
    Map<String,StringCountDS>stringCountMap = new HashMap<>();
    PriorityQueue<StringCountDS> minHeap = new PriorityQueue<>();
    private String[] countWords(List<String> keywords,List<String> reviews,int k)
    {
        StringCountDS [] result = new StringCountDS[k];
        Comparator<StringCountDS>c = new Comparator<StringCountDS>() {
            @Override
            public int compare(StringCountDS o1, StringCountDS o2) {
                if(o1.count == o2.count)
                    return o1.word.compareTo(o2.word);
                else if(o1.count>o2.count)
                        return -1;
                else
                    return 1;
            }
        };
        //iterate over each review and split on space, check if keywords exists in review and update the map
        for(String review:reviews)
        {
            HashSet<String>set = new HashSet<String> (Arrays.asList(review.toLowerCase().replaceAll("[^a-z\\s]","").split("\\s+")));
            for(String keyword:keywords)
            {
                keyword = keyword.toLowerCase();
                if(set.contains(keyword))
                {
                    StringCountDS stringCount=stringCountMap.getOrDefault(keyword,new StringCountDS(keyword,0));
                    stringCount.count++;
                    stringCountMap.put(keyword,stringCount);
                    //remove the heap object of word with previous count and then add it again, with updated count
                    minHeap.remove(stringCount);
                    if(minHeap.size()<k)
                        minHeap.add(stringCount);
                    else if(minHeap.size() ==k && stringCount.count>= minHeap.peek().count) {
                        minHeap.remove();
                        minHeap.add(stringCount);
                    }

                }
            }
        }
        for(int i =0;i <k;i++)
        {
            result[i]= minHeap.remove();
        }

        Arrays.sort(result,c);
        System.out.println(Arrays.toString(result));
        String newarr [] =new String[k];
        for(String s:stringCountMap.keySet())
        {
            System.out.println(s+" : "+stringCountMap.get(s).count);
        }
        for(int i =0;i<newarr.length;i++)
        {
            newarr[i]=result[i].word;
        }
        System.out.println(Arrays.toString(newarr));
        return newarr;
    }
    public static void main(String[] args) {
        List<String>l = new ArrayList<>();
        //anacell", "cetracular", "betacellular
        l.add("anacell");
        l.add("cetracular");
        l.add("betacellular");
        l.add("tetracell");
        List<String>reviews = new ArrayList<>();
        reviews.add("Anacell provides the best Cetracular+- in the city");
        reviews.add("betacellular has CetraCular+- services");
        reviews.add("Best services provided by cetracular+- , betacellular should betacellular anacell");
        reviews.add("Best cetracular+- provided by tetracell , everyone should use anacell");
        reviews.add("Best tetracell provided by betacellular , tetracell cetracular use anacell");
        reviews.add("Anacell provides the best  in the city");
        reviews.add("Best services provided by cetracular, tetracell cetracular use anacell");
        WordCounterAmazon counter = new WordCounterAmazon();
        counter.countWords(l,reviews,4);
    }
}
