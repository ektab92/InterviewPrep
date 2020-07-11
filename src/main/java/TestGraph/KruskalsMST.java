package TestGraph;

import com.practice.ds0.UnionFindCycleDetection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.*;
import java.util.PriorityQueue;

public class KruskalsMST
{
    public Map<Integer,MSTVertex> vertexNodeRefMap = new HashMap<>();
    UnionFindCycleDetection unionFind;
    private class MSTEdge implements Comparable<MSTEdge>
    {
        public int src;
        public int dest;
        public int wgt;
        public MSTEdge(int s,int d,int w)
        {
            this.src = s;
            this.dest = d;
            this.wgt = w;
        }
        @Override
        public int compareTo(MSTEdge e1)
        {
            if(this.wgt == e1.wgt)
                return 0;
            if(this.wgt > e1.wgt)
                return 1;
            else
                return -1;
        }

        @Override
        public String toString() {
            return (String.format("{%d , %d , %d}",this.src,this.dest,this.wgt));
        }
    }
    private class MSTVertex
    {
        int id;
        List<MSTEdge>edges;
        MSTVertex(int id)
        {
            this.id=id;
            this.edges= new ArrayList<>();
        }
    }
    public void addEdge(int src,int dest,int wgt)
    {
        MSTVertex s=vertexNodeRefMap.getOrDefault(src,new MSTVertex(src));
        MSTVertex d=vertexNodeRefMap.getOrDefault(dest,new MSTVertex(dest));
        vertexNodeRefMap.put(src,s);
        vertexNodeRefMap.put(dest,d);
        MSTEdge e = new MSTEdge(src,dest,wgt);
        s.edges.add(e);
        d.edges.add(e);
    }


    PriorityQueue<MSTEdge> minHeap = new PriorityQueue<>();
    List<MSTEdge> mstEdges = new ArrayList<>();
    public void printMST()
    {
        unionFind  = new UnionFindCycleDetection(vertexNodeRefMap.size());
        for(MSTVertex v : vertexNodeRefMap.values())
        {
            for(MSTEdge e:v.edges)
            {
                    minHeap.add(e);
            }
        }
        System.out.println(vertexNodeRefMap.size());
        while(mstEdges.size() < vertexNodeRefMap.size()-1)
        {
            MSTEdge currEdge = minHeap.remove();
            if(unionFind.find(currEdge.src) != unionFind.find(currEdge.dest))
            {
                mstEdges.add(currEdge);
                unionFind.union(currEdge.src,currEdge.dest);
            }
        }
        System.out.println(mstEdges);
    }
    public static void main(String[] args) {
        KruskalsMST graph = new KruskalsMST();
        graph.addEdge(1,2,3);
        graph.addEdge(1,3, 6);
        graph.addEdge(2,3, 4);
        graph.addEdge(2,4,4);
        graph.addEdge(3,4,8);
        graph.addEdge(2,5,11);
        graph.addEdge(3,7,11);
        graph.addEdge(4,7,2);
        graph.addEdge(4,6,5);
        graph.addEdge(4,5,-4);
        graph.addEdge(5,8,9);
        graph.addEdge(6,8,1);
        graph.addEdge(7,8,2);
        graph.printMST();
    }

}

