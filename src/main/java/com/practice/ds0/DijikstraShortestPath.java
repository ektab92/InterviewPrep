package com.practice.ds0;
import java.util.*;
class Vertices implements Comparable<Vertices>{
    int id;
    int cost;
    List<Edges> edges;
    Vertices(int id)
    {
        this.id = id;
        this.cost = Integer.MAX_VALUE;
        this.edges = new ArrayList<Edges>();
    }
    @Override
    public int compareTo(Vertices o) {
        if(this.cost == o.cost)
            return 0;
        if(this.cost>o.cost)
            return 1;
        else
            return -1;
    }
}
class Edges implements Comparable<Edges>{
    int src;
    int dest;
    int weight;
    Edges(int src,int dest,int wgt)
    {
        this.src=src;
        this.dest=dest;
        this.weight=wgt;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d, %d)", src, dest, weight);
    }

    @Override
    public int compareTo(Edges o) {
        if(this.weight == o.weight)
            return 0;
        if(this.weight>o.weight)
            return 1;
        else
            return -1;
    }
}
public class DijikstraShortestPath {
    PriorityQueue<Vertices> minCostVerticesHeap = new PriorityQueue<>();
    Map<Integer,Vertices> graphNodeMap = new HashMap<>();
    Set<Integer> visitedVertex = new HashSet<>();
    private void computeShortestPath(int [][] graph,int start)
    {
        constructGraph(graph);
        Vertices destVertices =graphNodeMap.get(start);
        //set the cost of starting vertex to 0
        visitedVertex.add(start);
        destVertices.cost=0;
        for(Edges e:destVertices.edges)
        {
           Vertices v = graphNodeMap.get(e.dest);
           v.cost= destVertices.cost+e.weight;
           minCostVerticesHeap.add(v);
        }
        while(minCostVerticesHeap.size() >0)
        {
           Vertices currVertex = minCostVerticesHeap.remove();
           visitedVertex.add(currVertex.id);
           for(Edges e : currVertex.edges)
           {
              Vertices v= graphNodeMap.get(e.dest);
              //for updating the new cost into heap, remove old entry and add new entry to ensure, heapification is triggered
              minCostVerticesHeap.remove(v);
              v.cost = Math.min(currVertex.cost + e.weight, v.cost);

               if(!visitedVertex.contains(v.id)) {
                  minCostVerticesHeap.add(v);
              }
           }
        }
        for(Vertices v : graphNodeMap.values())
        {
            System.out.println("For Vertex : "+v.id+" Cost is : "+v.cost);
        }
    }

    private void constructGraph(int[][] graph) {
        for(int i =0;i<graph.length;i++)
        {
            Vertices v=graphNodeMap.getOrDefault(graph[i][0],new Vertices(graph[i][0]));
            Edges e = new Edges(graph[i][0],graph[i][1],graph[i][2]);
            v.edges.add(e);
            graphNodeMap.put(graph[i][0],v);
        }
        for(int v: graphNodeMap.keySet())
        {
            System.out.println("Vertex : " +v + " List of Edges : "+ graphNodeMap.get(v).edges.toString() );
        }
    }

    public static void main(String[] args) {
        int graph[][] = {{1, 2, 2}, {1, 3, 4}, {2, 4, 4}, {2, 3, 1}, {3, 4, 5}, {4, 6, 2}, {6, 5, 2}, {5, 4, 2}, {5, 3, 3}};
        DijikstraShortestPath shortestPath = new DijikstraShortestPath();
        shortestPath.computeShortestPath(graph,1);
    }
}
