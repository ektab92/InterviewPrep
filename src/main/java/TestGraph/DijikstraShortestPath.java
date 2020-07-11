package TestGraph;

import java.util.ArrayList;
import java.util.*;

public class DijikstraShortestPath {
    Map<Integer,DVertex>vertexRefMap = new HashMap<>();

    private class DEdge{
        DVertex src;
        DVertex dest;
        int wgt;
        DEdge(DVertex src,DVertex dest,int wgt)
        {
            this.src=src;
            this.dest=dest;
            this.wgt=wgt;
        }

    }
    private class DVertex implements Comparable<DVertex> {
        int id;
        int cost;
        List<DEdge>edges ;
        DVertex(int id,int c)
        {
            this.id=id;
            this.cost=c;
            edges = new ArrayList<>();
        }
        @Override
        public int compareTo(DVertex v)
        {
            if(this.cost == v.cost)
                return 0;
            if(this.cost> v.cost)
                return 1;
            else
                return -1;
        }
    }
    public void addEdge(int src,int dest,int wgt)
    {
        DVertex s = vertexRefMap.getOrDefault(src,new DVertex(src,Integer.MAX_VALUE));
        DVertex d = vertexRefMap.getOrDefault(dest,new DVertex(dest,Integer.MAX_VALUE));
        DEdge e = new DEdge(s,d,wgt);
        s.edges.add(e);
        vertexRefMap.put(src,s);
        vertexRefMap.put(dest,d);
    }

    PriorityQueue<DVertex> minHeap = new PriorityQueue<>();
    Set<Integer>processed = new HashSet<>();
    private void findShortestPath(int start)
    {
        DVertex sVertex = vertexRefMap.get(start);
        sVertex.cost=0;
        for(DEdge e: sVertex.edges)
        {
            e.dest.cost = Math.min(e.dest.cost,sVertex.cost+e.wgt);
        }
        for(DVertex v:vertexRefMap.values())
        {
            if(v != sVertex)
                minHeap.add(v);
        }
        while(minHeap.size() >0)
        {
            DVertex currV = minHeap.remove();
            processed.add(currV.id);
            for(DEdge e: currV.edges)
            {
                if(!processed.contains(e.dest)) {
                    minHeap.remove(e.dest);
                    e.dest.cost = Math.min(e.dest.cost, currV.cost + e.wgt);
                    minHeap.add(e.dest);
                }
            }
        }
        for(DVertex v:vertexRefMap.values())
        {
            System.out.println(v.id +" "+v.cost);
        }
    }


    public static void main(String[] args) {
        DijikstraShortestPath graph = new DijikstraShortestPath();
        graph.addEdge(1,2,3);
        graph.addEdge(1,3, 6);
        graph.addEdge(2,3, 4);
        graph.addEdge(2,4,4);
        graph.addEdge(3,4,8);
        graph.addEdge(2,5,11);
        graph.addEdge(3,7,11);
        graph.addEdge(4,7,2);
        graph.addEdge(4,6,5);
        graph.addEdge(4,5,2);
        graph.addEdge(5,8,9);
        graph.addEdge(6,8,1);
        graph.addEdge(7,8,2);
        graph.findShortestPath(1);
    }
}
