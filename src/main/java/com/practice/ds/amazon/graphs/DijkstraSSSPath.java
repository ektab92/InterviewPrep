package com.practice.ds.amazon.graphs;

import java.util.*;
/*
  1. Create a AdjList <vertex,List of Edges>
  2. Define a Dist[] ans initialise all values to Infinite except the start index value.
  3. Create a Node Class which stores (vertex,cost/distance) and a comparator which sorts on cost
  4. Create a MinHeap of Node,default push NodeObject(startVertex,0),i.e initial cost is 0.
  5. while Heap is not empty
     5.1 remove from heap the shortest cost node, and iterate over all the edges connected to it.
     5.2 Relax all the connected edges i.e update dist[destVertex] to the new min cost.
     5.3 If the dest node of edge are not visited,push the node Objects in heap.
  6. Mark the vertices as visited.
 */
class NodeInfo implements Comparable<NodeInfo>{
    int vertex;
    int cost;
    NodeInfo(int v,int c)
    {
        this.vertex=v;
        this.cost=c;
    }
    @Override
    public int compareTo(NodeInfo n1)
    {
        if(this.cost == n1.cost)
            return 0;
        if(this.cost> n1.cost)
            return 1;
        else
            return -1;
    }
}
public class DijkstraSSSPath {
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
            Edge e1 = new Edge(graph[i][1],graph[i][0],graph[i][2]);
            adjList.get(graph[i][1]).add(e1);
        }
        return adjList;
    }
    private int [] findShortestPath(Map<Integer,List<Edge>> adjList,int N,int start)
    {
        int []distance = new int[N];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0]=0;
        Set<Integer>visited = new HashSet<>();
        PriorityQueue<NodeInfo> minHeap = new PriorityQueue<>();
        minHeap.add(new NodeInfo(start,0));
        while(!minHeap.isEmpty()) {
            NodeInfo currNode = minHeap.remove();
            for (Edge e : adjList.get(currNode.vertex))
            {
                distance[e.dest]=Math.min(distance[e.dest], currNode.cost+e.wgt);

                if(!visited.contains(e.dest))
                {
                    NodeInfo newNode = new NodeInfo(e.dest,distance[e.dest]);
                    minHeap.add(newNode);
                }
            }
            visited.add(currNode.vertex);
        }
        System.out.println(Arrays.toString(distance));
        return distance;
    }
    public static void main(String[] args) {
        int [][]Graph = {{0,1,4},{0,7,8},{1,7,11},{1,2,8},{7,8,7},{7,6,1},
                {2,8,2},{8,6,6},{6,5,2},{2,5,4},{2,3,7},{3,4,9},{3,5,14},
                {5,4,10}};
        DijkstraSSSPath shortestPath = new DijkstraSSSPath();
        Map<Integer,List<Edge>> adjList=shortestPath.createGraph(Graph,9);
        shortestPath.findShortestPath(adjList,9,0);

    }
}
