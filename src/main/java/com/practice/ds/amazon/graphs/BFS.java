package com.practice.ds.amazon.graphs;

import java.util.*;

public class BFS {
    static Set<Integer>visited = new HashSet<>();
    static Queue<Integer>q = new LinkedList<>();
    public static void doBFS(Map<Integer, List<Integer>> adjList,int start)
    {
        if(visited.contains(start)) return;
        q.add(start);
        while(!q.isEmpty())
        {
            int curr = q.remove();
            System.out.println(curr);
            visited.add(curr);
            for(int i:adjList.get(curr))
            {
                if(!visited.contains(i))
                    q.add(i);
            }
        }
    }
    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {2}, {5}, {}, {3, 5}, {}};
        Map<Integer, List<Integer>> adjList = new HashMap();
        int connectedComp = 0;
        for (int i = 0; i < graph.length; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            List<Integer> children = adjList.getOrDefault(i, new ArrayList<>());
            for (int j = 0; j < graph[i].length; j++) {
                children.add(graph[i][j]);
            }
            adjList.put(i, children);
        }
        for(int i:adjList.keySet())
        {
            if(!visited.contains(i))
            {
                doBFS(adjList,i);
            }
        }
    }
}
