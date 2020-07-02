package com.practice.ds0;
import java.util.*;

public class DistinctEleInWindow {
    static List<Integer> list = new ArrayList<>();
    static Map <Integer,Integer> map = new HashMap<>();
    public static void findDistinct(int [] arr, int size)
    {
       for(int i =0; i< size;i++){
           if(!map.containsKey(arr[i]))
               map.put(arr[i],1);
           else
           {
               int val = map.get(arr[i])+1;
               map.put(arr[i],val);
           }
       }
       list.add(map.size());
       for(int i = 1; i <=arr.length-size;i++)
       {
           int start_key = i-1;
           if(map.get(arr[start_key]) ==1){
               map.remove(arr[start_key]);
           }else{
               map.put(arr[start_key],map.get(arr[start_key])-1);
           }
           int last= i+size-1;
           if(map.containsKey(arr[last])){
               map.put(arr[last], map.get(arr[last])+1);
           }else{
               map.put(arr[last],1);
           }
           list.add(map.size());

       }
        System.out.println(list.toString());
    }
    public static void main(String[] args) {
        int [] arr = {1,2,1,3,4,2,3};
        findDistinct(arr,4);

    }
}
