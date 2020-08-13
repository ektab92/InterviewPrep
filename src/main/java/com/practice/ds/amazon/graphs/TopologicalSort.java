package com.practice.ds.amazon.graphs;

import java.util.*;

public class TopologicalSort {
    Set<Integer>visited = new HashSet<>();
    Stack<Integer>postOrderDFS= new Stack<>();
    public Stack<Integer> getPostOrderDFS()
    {
        return postOrderDFS;
    }
    public  List<Integer> topologicalSort(Map<Integer, List<Integer>> adjList)
    {
        List<Integer>topoList = new ArrayList<>();
        for(int i: adjList.keySet())
        {
            if(!visited.contains(i))
            {
                sortHelper(adjList,i);
            }
        }
        while(!postOrderDFS.isEmpty())
        {
            topoList.add(postOrderDFS.pop());
        }
        return topoList;
    }
    public void sortHelper(Map<Integer, List<Integer>> adjList , int start)
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
                sortHelper(adjList,i);
        }
        postOrderDFS.push(start);
    }
    public static void main(String[] args) {
        int[][] graph = {{1},{2,3},{4},{4,5,6},{},{7},{7},{}};
        Map<Integer, List<Integer>> adjList = new HashMap();
        TopologicalSort sort = new TopologicalSort();
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
        sort.topologicalSort(adjList);
    }


}
