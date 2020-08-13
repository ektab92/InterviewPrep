package com.practice.ds.amazon.graphs;

import java.util.*;

public class FindCycle {
    static Set<Integer>inProgress = new HashSet<>();
    static Set<Integer>completed = new HashSet<>();
    static boolean hasCycle = false;

    public static boolean findCycleUndirected(int[][] G,int noOfVertex)
    {
        UnionFind unionFind = new UnionFind(noOfVertex);
        for(int i=0;i<G.length;i++)
        {
           if(!unionFind.Union(G[i][0],G[i][1]))
            {
                System.out.println("cycle Found");
                return true;
            }
        }
        return false;
    }
    public static void findCycle(Map<Integer, List<Integer>> adjList,int start)
    {
        if(completed.contains(start)) return;
        inProgress.add(start);
        for(int i:adjList.get(start))
        {
            if (inProgress.contains(i))
            {
                hasCycle = true;
                return;
            }
            else if (!completed.contains(i))
            {
                findCycle(adjList,i);
            }
        }
        completed.add(start);
        inProgress.remove(start);
    }
    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {2}, {5}, {}, {3, 5}, {1}};
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
        //for cycle detection in directed graph
        for(int i:adjList.keySet())
        {
            if(!completed.contains(i)) {
                findCycle(adjList, i);
                if(hasCycle) {
                    System.out.println("Found Cycle");
                    break;
                }

            }

        }

        //for cycle detection in undirected graph
        int[][] undirectedGraphEdges = {{0,1},{1,2},{0,2}};
        findCycleUndirected(undirectedGraphEdges,3);
    }
}
