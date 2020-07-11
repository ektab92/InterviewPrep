package com.practice.Graph;

import java.util.*;

import com.practice.ds.GEdge;
import com.practice.ds.GVertex;
import com.practice.ds.Graph;
import com.practice.samples.GraphSample;

public class MaxLengthPathBtwnNodes {
    static Set<Integer> visited = new HashSet<>();
    static Stack<Integer> stack = new Stack<>();
    static List<Integer> topoLSortList = new ArrayList<>();
    static List<Integer> dfsList = new ArrayList<>();
    public static void recDFS(Graph g, int start)
    {
        dfsList.add(start);
        visited.add(start);
        GVertex sVertex=g.vertices.get(start);
        if(sVertex.children.size()==0|| !visited.contains(sVertex.id))
        {
            return;
        }
        for(GVertex v :sVertex.children)
        {
            if(!visited.contains(v.id))
                recDFS(g,v.id);
        }

    }
    public static void postOrderDFS(Graph g, int start){

        GVertex sVertex = g.vertices.get(start);
        if( visited.contains(sVertex.id))
            return;
        visited.add(start);
        if(sVertex.children.size()==0 )
        {
            stack.push(sVertex.id);
            return;
        }
        for(GVertex c:sVertex.children)
        {
            if(!visited.contains(c))
            {
                postOrderDFS(g,c.id);
            }
        }
        stack.push(sVertex.id);
    }

    public static List<Integer> topologicalSort(Graph g,int start)
    {
        postOrderDFS(g,start);
        while(!stack.isEmpty())
        {
            topoLSortList.add(stack.pop());
        }
        return topoLSortList;
    }

    public static int findLongestPathValue(Graph g)
    {
        int []pathDist = new int [topoLSortList.size()+1];
        Arrays.fill(pathDist,Integer.MAX_VALUE);
        pathDist[0]=0;//to ignore 0 indexing
        pathDist[1]=0;// this is the place to start

        for(int i = 0; i< topoLSortList.size(); i++)
        {
            GVertex v = g.vertices.get(topoLSortList.get(i));
            for(GEdge e: v.edges)
            {
                pathDist[e.dest.id]=Math.min(pathDist[e.dest.id],e.wgt+pathDist[e.src.id]);
            }
        }
        System.out.println(Arrays.toString(pathDist));
        System.out.println(pathDist[pathDist.length-1]);
        return pathDist[pathDist.length-1];
    }
    public static void main(String[] args) {
        Graph g = GraphSample.getGraph();
        topologicalSort(g,1);
        System.out.println(topoLSortList);
        findLongestPathValue(g);
        //recDFS(g,1);
        //System.out.println(dfsList);
    }
}
