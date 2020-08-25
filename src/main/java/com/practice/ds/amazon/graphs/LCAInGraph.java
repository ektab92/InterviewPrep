package com.practice.ds.amazon.graphs;

import java.util.*;

public class LCAInGraph {
    public static Set<Integer>visited = new HashSet<>();
    static List<Integer>nodes = new ArrayList<>();
    static List<Integer>n1Path = new ArrayList<>();
    static List<Integer>n2Path = new ArrayList<>();
    static boolean nodeFound = false;
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
    public int findRoot(int []vertices,Map<Integer, List<Edge>> adjList)
    {
        int i=0;
        for(Edge e:adjList.get(i++))
        {
            if(vertices[e.dest] == -1)
                vertices[e.dest]=i;
        }
        for(int k=0;k< vertices.length;k++)
        {
            if(vertices[k]== -1)
                return k;
        }
        return -1;
    }
    public static void dfsRec(Map<Integer, List<Edge>> adjList,int start,int node)
    {
        if(visited.contains(start)) return ;
        visited.add(start);
        if(start ==node)
        {
            nodeFound = true;
            nodes.add(start);
            return;
        }
        if(adjList.get(start).size() == 0  )
            return ;
        for(Edge e:adjList.get(start))
        {
            if(!visited.contains(e.dest))
                nodes.add(e.src);
                dfsRec(adjList,e.dest,node);
                if(!nodeFound)
                    nodes.remove(nodes.size()-1);
        }
    }
    public int findLCA(Map<Integer, List<Edge>> adjList,int n1,int n2)
    {
        int []vertices = new int[adjList.size()];
        Arrays.fill(vertices,-1);
        int root=findRoot(vertices,adjList);
        System.out.println("root is "+root);
        if(root != -1)
        {
            dfsRec(adjList,root,n1);
            n1Path= new ArrayList<>(nodes);
            System.out.println(n1Path);
            nodes = new ArrayList<>();
            nodeFound = false;
            dfsRec(adjList,root,n2);
            n2Path= new ArrayList<>(nodes);
            System.out.println(n2Path);

        }
        for(int i=0;i<n1Path.size();i++)
        {
            if(n1Path.get(i) != n2Path.get(i))
            {
                System.out.println("LCA : "+n1Path.get(i));
                return n1Path.get(i);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int [][]Graph = {{0,1,4},{0,7,8},{1,7,11},{1,2,8},{7,8,7},{7,6,1},
                {2,8,2},{8,6,6},{6,5,2},{2,5,4},{2,3,7},{3,4,9},{3,5,14},
                {5,4,10}};
        LCAInGraph dag = new LCAInGraph();
        Map<Integer, List<Edge>> adjList = dag.createGraph(Graph,9);
        dag.findLCA(adjList,5,3);
    }
}
