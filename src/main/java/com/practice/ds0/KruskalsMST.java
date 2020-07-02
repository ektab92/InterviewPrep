package com.practice.ds0;
import java.util.*;
class ConstructMSTEdge implements  Comparable<ConstructMSTEdge>{
    int src;
    int dest;
    int wgt;
    ConstructMSTEdge(int src,int dest,int wgt)
    {
        this.src=src;
        this.dest=dest;
        this.wgt=wgt;
    }
    @Override
    public int compareTo(ConstructMSTEdge incomingEdge)
    {
        if(this.wgt == incomingEdge.wgt)
            return 0;
        else if (this.wgt>incomingEdge.wgt)
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        return "{" +src +"," + dest +"," + wgt + "}";
    }
}
public class KruskalsMST {
    int costofSpanningTree=0;
    List<ConstructMSTEdge>MSTEdges = new ArrayList<>();
    PriorityQueue<ConstructMSTEdge>minHeap = new PriorityQueue<>();
    //Total O(n)+O(nlogn)+O(n)= O(nlogn)
    private List<ConstructMSTEdge> findMST(int [][]graph,int vertices)
    {
        //worst case order of n
        UnionFindCycleDetection uf = new UnionFindCycleDetection(vertices);
        //Constructing minHeap for n veritces n*log(n)
        for(int i =0; i <graph.length;i++)
        {
            ConstructMSTEdge edge =new ConstructMSTEdge(graph[i][0],graph[i][1],graph[i][2]);
            minHeap.add(edge);
        }
        //O(n)
        while(minHeap.size()>0 && MSTEdges.size()<=vertices-1)
        {
            ConstructMSTEdge minEdge = minHeap.remove();
            if(uf.union(minEdge.src,minEdge.dest)==0)
            {
                MSTEdges.add(minEdge);
                costofSpanningTree+=minEdge.wgt;
            }
        }
        System.out.println("Total Cost of MST is : "+costofSpanningTree);
        return MSTEdges;
    }
    public static void main(String[] args) {
        int graph[][]  = {{1,2,1},{1,6,4},{1,4,5},{2,3,6},{3,6,2},{6,5,10},{4,5,9},{3,4,7}};
        KruskalsMST mstUtility = new KruskalsMST();
        List<ConstructMSTEdge>edges = mstUtility.findMST(graph,6);
        System.out.println(edges);
    }
}
