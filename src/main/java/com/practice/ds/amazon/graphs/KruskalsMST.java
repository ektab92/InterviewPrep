package com.practice.ds.amazon.graphs;

import java.util.*;
/*
    1. Create an Edge class with comparable on weight
    2. Create a MinHeap, by pushing all the edges
    3. now , while we did no reach collecting N-1 edges, where N i no of vertices,
       remove from MST, check with Unionfind method that there is no cycle , and if no cycle
       is made after selecting this edge, add this edge to the result
    4. Time Complexity =ELogE  Space Complexity =|E|+|N-1|
 */

class Edge implements Comparable<Edge>{
    int src;
    int dest;
    int wgt;

    Edge(int s, int d, int w) {
        src = s;
        dest = d;
        wgt = w;
    }
    @Override
    public int compareTo(Edge e1) {
        if(this.wgt == e1.wgt)
            return 0;
        if(this.wgt>e1.wgt)
            return 1;
        else
            return -1;
    }
}
public class KruskalsMST {
    List<List<Integer>>MSTEdges = new ArrayList<>();
    int mstSum =0;
    public List<List<Integer>> findMSTEdges(int [][]Graph,int N)
    {
        PriorityQueue<Edge>minHeap = new PriorityQueue<>();
        UnionFind unionFind = new UnionFind(N);
        for(int i=0;i<Graph.length;i++)
        {
            Edge e = new Edge(Graph[i][0],Graph[i][1],Graph[i][2]);
            minHeap.add(e);
        }
        while(MSTEdges.size()<N-1)
        {
           Edge currEdge= minHeap.remove();
           List<Integer>edgeVal = new ArrayList<>();
           if(unionFind.Union(currEdge.src, currEdge.dest)) {
               edgeVal.add(currEdge.src);
               edgeVal.add(currEdge.dest);
               mstSum+= currEdge.wgt;
               MSTEdges.add(new ArrayList<>(edgeVal));
           }
        }
        System.out.println(MSTEdges+" : "+mstSum);
        return MSTEdges;
    }

    public static void main(String[] args) {
        int [][]Graph = {{0,1,4},{0,7,8},{1,7,11},{1,2,8},{7,8,7},{7,6,1},
                        {2,8,2},{8,6,6},{6,5,2},{2,5,4},{2,3,7},{3,4,9},{3,5,14},
                        {5,4,10}};
        KruskalsMST mst = new KruskalsMST();
        mst.findMSTEdges(Graph,9);
    }
}
