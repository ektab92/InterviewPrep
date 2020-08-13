package com.practice.ds.amazon.graphs;

import java.util.*;

public class DiameterOfUndirectedGraph {
    static Set<Integer>visited = new HashSet<>();
    public static Map<Integer,List<Integer>> createGraph(int [][]graph)
    {
        Map<Integer,List<Integer>> adjList = new HashMap<>();
        for(int i=0;i< graph.length;i++)
        {
            adjList.put(i,new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++)
        {
            List<Integer>children=adjList.getOrDefault(graph[i][0],new ArrayList<>());
            children.add(graph[i][1]);
            adjList.put(graph[i][0],children);
            children=adjList.getOrDefault(graph[i][1],new ArrayList<>());
            children.add(graph[i][0]);
            adjList.put(graph[i][1],children);

        }
        return adjList;
    }
    static int maxLevel=0;
    static int deepestNode=-1;
    public static void doDFS(Map<Integer,List<Integer>> adjList,int start,int level)
    {
        if(level>maxLevel)
        {
            maxLevel=level;
            deepestNode=start;
        }
        if(visited.contains(start)) return ;
        visited.add(start);
        //System.out.println(start);
        //if(adjList.get(start).size()==0) return ;
        for(int i:adjList.get(start))
        {
            if(!visited.contains(i))
                doDFS(adjList,i,level+1);
        }
    }
    public static int findDiameter(Map<Integer,List<Integer>> adjList)
    {
        for(int i:adjList.keySet())
        {
            if(!visited.contains(i))
            {
                doDFS(adjList,i,1);
            }
        }
        maxLevel=0;
        System.out.println("deepest node : "+deepestNode);
        visited = new HashSet<>();
        doDFS(adjList,deepestNode,1);
        System.out.println("diameter : "+maxLevel);
        return maxLevel;
    }
    public static void main(String[] args) {
        int [][] graph = {{0,1},{1,2},{2,3},{1,4},{4,5},{5,6},{6,7}};
        Map<Integer,List<Integer>> adjList=createGraph(graph);
        findDiameter(adjList);
    }
}
