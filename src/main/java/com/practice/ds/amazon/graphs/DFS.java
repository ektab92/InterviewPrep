package com.practice.ds.amazon.graphs;

import java.util.*;

public class DFS {
    public static Set<Integer>visited = new HashSet<>();
    public static void dfsRec(Map<Integer,List<Integer>>adjList,int start)
    {
        if(visited.contains(start)) return ;
        visited.add(start);
        System.out.println(start +"-->");
        if(adjList.get(start).size() == 0  )
            return ;
        for(int i:adjList.get(start))
        {
            if(!visited.contains(i))
                dfsRec(adjList,i);
        }
    }
    static Stack<Integer>stk = new Stack<>();
    public static void doDFSIter(Map<Integer,List<Integer>>adjList,int start)
    {
        if(visited.contains(start)) return;
        stk.push(start);
        while(!stk.isEmpty())
        {
            int curr = stk.pop();
            visited.add(curr);
            System.out.println(curr+" -> ");
            for(int i:adjList.get(curr))
            {
                if(!visited.contains(i))
                    stk.push(i);
            }
        }
    }
    public static void main(String[] args) {
        int[][] graph = {{1,3},{2},{5},{},{3,5},{}};
        Map<Integer,List<Integer>>adjList = new HashMap();
        int connectedComp=0;
        for(int i =0;i< graph.length;i++)
        {
            adjList.put(i,new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++)
        {
            List<Integer>children  = adjList.getOrDefault(i,new ArrayList<>());
            for(int j=0;j< graph[i].length;j++)
            {
                children.add(graph[i][j]);
            }
            adjList.put(i,children);
        }
        //Rec DfS Call
        for(int i:adjList.keySet())
        {
            if(!visited.contains(i)) {
                dfsRec(adjList, i);
                connectedComp++;
            }
        }

        //Iterative DFS Call
        visited = new HashSet<>();
        connectedComp=0;
        System.out.println("DFS Iterative Result: ");
        for(int i:adjList.keySet())
        {
            if(!visited.contains(i)) {
                doDFSIter(adjList, i);
                connectedComp++;
            }
        }
        System.out.println("Connected components : "+connectedComp);
    }
}
