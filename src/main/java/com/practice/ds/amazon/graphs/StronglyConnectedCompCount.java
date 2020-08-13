package com.practice.ds.amazon.graphs;

import java.util.*;
/*
1. Find PostOrderDFS(populate the stack)
2. Reverse the graph
3. While stack is not empty, for every node that gets popped out,
   do dfs on reversed graph and count connected components.
 */
public class StronglyConnectedCompCount {
    static Set<Integer>visited = new HashSet<>();
    Stack<Integer>postOrderDFS =new Stack<>();
    public int countSCC(Map<Integer, List<Integer>> adjList,int start)
    {
        int SCCCount=0;
        for(int i:adjList.keySet())
        {
            if(!visited.contains(i))
            {
                postOrderDFS(adjList,i);
            }
        }
        Map<Integer, List<Integer>> reversedGraph=reverseGraph(adjList);
        visited = new HashSet<>();
        while(!postOrderDFS.isEmpty())
        {
            int i=postOrderDFS.pop();
            if(!visited.contains(i)) {
                dfsRec(reversedGraph, i);
                SCCCount++;
            }
        }
        System.out.println("Strongly connected comp: "+SCCCount);
        return SCCCount;
    }
    public void postOrderDFS(Map<Integer, List<Integer>> adjList , int start)
    {
        if(visited.contains(start)) return;
        visited.add(start);
        if(adjList.get(start).size() == 0)
        {
            postOrderDFS.push(start);
            return;
        }
        for(int i:adjList.get(start))
        {
            if(!visited.contains(i))
                postOrderDFS(adjList,i);
        }
        postOrderDFS.push(start);
    }
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
    public Map<Integer, List<Integer>> reverseGraph(Map<Integer, List<Integer>> adjList)
    {
        Map<Integer, List<Integer>> reverseGraph = new HashMap<>();
        for(int i:adjList.keySet())
        {
            for(int j:adjList.get(i))
            {
                List<Integer>children=reverseGraph.getOrDefault(j,new ArrayList<>());
                children.add(i);
                reverseGraph.put(j,children);
            }
        }
        return reverseGraph;
    }
    public static void main(String[] args) {
        int[][] graph = {{1},{2},{0,3},{4},{5},{3,6},{}};
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        TopologicalSort topologicalSort = new TopologicalSort();
        for(int i=0;i< graph.length;i++)
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
        StronglyConnectedCompCount compCount = new StronglyConnectedCompCount();
        compCount.countSCC(adjList,0);

    }
}
