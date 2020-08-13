package com.practice.ds.amazon.graphs;

import java.util.*;

public class ShortestPathInDAG {

    Set<Integer> visited = new HashSet<>();
    Stack<Integer>postOrderDFS= new Stack<>();

    public Map<Integer, List<Edge>> createGraph(int graph[][], int vertices)
    {
        Map<Integer,List<Edge>> adjList= new HashMap<>();
        for(int i=0;i<vertices;i++)
        {
            adjList.put(i,new ArrayList<>());
        }
        for(int i=0;i< graph.length;i++)
        {
            Edge e = new Edge(graph[i][0],graph[i][1],graph[i][2]);
            adjList.get(graph[i][0]).add(e);
        }
        return adjList;
    }
    public  List<Integer> topologicalSort(Map<Integer, List<Edge>> adjList)
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
        System.out.println(topoList);
        return topoList;
    }
    public void sortHelper(Map<Integer, List<Edge>> adjList,int start)
    {
        if(visited.contains(start)) return ;
        visited.add(start);
        if(adjList.get(start).size()==0) {
            postOrderDFS.push(start);
            return;
        }
        for(Edge e:adjList.get(start))
        {
            if(!visited.contains(e.dest))
                sortHelper(adjList,e.dest);
        }
        postOrderDFS.push(start);
    }
    public int [] findShortestPath(Map<Integer,List<Edge>> adjList,int N)
    {
        int [] dist = new int[N];
        Arrays.fill(dist,Integer.MAX_VALUE);
        List<Integer> topoList=topologicalSort(adjList);
        dist[topoList.get(0)]=0;
        for(int i=0;i<topoList.size();i++)
        {
            for(Edge e:adjList.get(topoList.get(i)))
            {
                dist[e.dest]=Math.min(dist[e.dest],dist[e.src]+e.wgt);
            }
        }
        System.out.println(Arrays.toString(dist));
        return dist;
    }

    public static void main(String[] args) {
        int [][]Graph = {{0,1,4},{0,7,8},{1,7,11},{1,2,8},{7,8,7},{7,6,1},
                {2,8,2},{8,6,6},{6,5,2},{2,5,4},{2,3,7},{3,4,9},{3,5,14},
                {5,4,10}};
        ShortestPathInDAG dag = new ShortestPathInDAG();
        Map<Integer,List<Edge>> adjList = dag.createGraph(Graph,9);
        dag.findShortestPath(adjList,9);
    }
}
