package com.practice.ds.amazon.graphs;


import java.util.*;
/*
    1.Create a adjList <Integer,Edges<List>> for the list of edges, number of vertices coming in input
    2.while creating adjList find the min weight Edge.
    3.Push the min wgt edge in the priority queue.
    4.while the result MST Edges list is not of size N-1
        4.1 remove from MST(MinEdge1),check by union find it not forms cycle if included.
        4.2 add that edge to result MSTEdges list,
        4.3 for all the edges connected to this minEdge(MinEdge1), by its src(Es1,Es2..) and dest(Ed1,Ed2,..),
        push all of them in minHeap if none of its src and dest are in visited set.
    5. Mark (MinEdge1) as visited.

 */

public class PrimsMST {
    List<Edge> MSTEdges = new ArrayList<>();
    Edge minEdge = null;
    int minWt = Integer.MAX_VALUE;
    public Map<Integer,List<Edge>> createGraph(int graph[][], int vertices)
    {
        Map<Integer,List<Edge>> adjList= new HashMap<>();
        for(int i=0;i<vertices;i++)
        {
            adjList.put(i,new ArrayList<>());
        }
        for(int i=0;i< graph.length;i++)
        {
            Edge e = new Edge(graph[i][0],graph[i][1],graph[i][2]);
            if(e.wgt<minWt)
            {
                minWt = e.wgt;
                minEdge =e;
            }
            adjList.get(graph[i][0]).add(e);
            Edge e1 = new Edge(graph[i][1],graph[i][0],graph[i][2]);
            adjList.get(graph[i][1]).add(e1);
        }
        return adjList;
    }
    public List<Edge> primsMST(Map<Integer,List<Edge>>adjList,int N)
    {
        PriorityQueue<Edge>minHeap = new PriorityQueue<>();
        minHeap.add(minEdge);
        Set<Integer>visited = new HashSet<>();
        UnionFind unionFind = new UnionFind(N);
        while(MSTEdges.size()<N-1 && !minHeap.isEmpty())
        {
            Edge currEdge = minHeap.remove();
            if (unionFind.Union(currEdge.src, currEdge.dest)) {
                MSTEdges.add(currEdge);
                for (Edge e : adjList.get(currEdge.src)) {
                    if (!visited.contains(e.src) && !visited.contains(e.dest))
                        minHeap.add(e);
                }
                for (Edge e : adjList.get(currEdge.dest)) {
                    if (!visited.contains(e.src) && !visited.contains(e.dest))
                        minHeap.add(e);
                }
            }
            visited.add(currEdge.src);
            visited.add(currEdge.dest);
        }
        for(int i=0;i<MSTEdges.size();i++)
        {
            System.out.println("Edge"+i+" " + MSTEdges.get(i).src+ " "
                                +MSTEdges.get(i).dest+ " "+MSTEdges.get(i).wgt);
        }
        return MSTEdges;
    }
    public static void main(String[] args) {
        int [][]Graph = {{0,1,4},{0,7,8},{1,7,11},{1,2,8},{7,8,7},{7,6,1},
                {2,8,2},{8,6,6},{6,5,2},{2,5,4},{2,3,7},{3,4,9},{3,5,14},
                {5,4,10}};
        PrimsMST mst = new PrimsMST();
        Map<Integer,List<Edge>>adjList=mst.createGraph(Graph,9);
        mst.primsMST(adjList,9);
    }
}
