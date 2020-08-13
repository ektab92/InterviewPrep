package com.practice.ds0;

import java.util.*;


public class Graph {
    public static class Vertex{
        int data;
        List<Vertex>children ;
        Vertex(int data)
        {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    public static class Edge{
        Vertex source;
        Vertex dest;
        int weight;
        Edge(Vertex source,Vertex dest,int weight)
        {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }
    static Map <Integer,Vertex> vertices;

    List <Edge> edges;
    boolean isdirected;
    public Graph(boolean isdirected)
    {
        this.isdirected = isdirected;
        this.vertices = new HashMap<>();
        this.edges = new ArrayList<>();
    }
    public  void addNode(int data)
    {
        if(!vertices.containsKey(data))
            vertices.put(data,new Vertex(data));
    }
    public void addEdge(int source,int target){
        addEdge(source, target, 0);
    }
    public void addEdge(int source,int target, int weight)
    {
        Vertex src = vertices.get(source);
        Vertex dest = vertices.get(target);
        if(src == null )
        {
            src = new Vertex(source);
            vertices.put(source,src);
        }
        if(dest == null )
        {
            dest = new Vertex(target);
            vertices.put(target,dest);
        }
        Edge edge = new Edge(src,dest,weight);
        edges.add(edge);
        src.children.add(dest);
        if (!isdirected) {
            dest.children.add(src);
            Edge edge1 = new Edge(dest, src, weight);
            edges.add(edge1);
        }
    }
    public void deleteVertex(int data){
        Vertex vertex =vertices.get(data);
        vertices.remove(data);
        for(Vertex i:vertex.children)
        {
            i.children.remove(vertex);
        }
    }
    public void deleteEdge(int source,int dest)
    {
        Vertex sVertex = vertices.get(source);
        Vertex dVertex = vertices.get(dest);
        Edge tmp=null;
        for(int i =0; i<edges.size()-1;i++)
        {
            if(edges.get(i).source == sVertex && edges.get(i).dest == dVertex)
            {
                tmp = edges.get(i);
                break;
            }
        }
        edges.remove(tmp);

        if(!isdirected)
            dVertex.children.remove(sVertex);
    }
    public int countConnectedVertices()
    {
        Stack<Integer>stk = new Stack<>();
        Set <Integer> set = new HashSet<>();
        int count =0;
        for(int v:vertices.keySet())
        {
            if(!set.contains(v)) {
                stk.push(v);
                set.add(v);
                while (!stk.isEmpty()) {
                    int ele = stk.pop();
                    Vertex vtx = vertices.get(ele);
                    for (Vertex vt : vtx.children) {
                        if(!set.contains(v)) {
                            set.add(vt.data);
                            stk.push(vt.data);
                        }
                    }

                }
                count++;
            }

        }
        return 0;
    }

    Stack<Vertex> stk = new Stack<>();
    Set <Integer> finished = new HashSet<>();
    boolean cycle  = false;
    Set <Integer> inProgress = new HashSet<>();
    public boolean detectCycle()
    {
        for(int vertex:vertices.keySet())
        {
           if(!finished.contains(vertex))
           {
               doDFS(vertices.get(vertex));
               if(cycle)
                   return true;
           }
        }
        return false;
    }

    private void doDFS(Vertex vertex) {
        boolean hasCycle = false;
        stk.push(vertex);
        inProgress.add(vertex.data);
        while(!stk.isEmpty())
        {
            Vertex ele = stk.pop();
            System.out.println(ele.data+"-->");
            if(ele.children.size() ==0) {
                finished.add(ele.data);
                inProgress.remove(ele.data);
            }
            for(Vertex v: vertex.children)
            {
                if(finished.contains(v.data)){
                    continue;
                }
                if(!inProgress.contains(v.data))
                {
                    if(!finished.contains(v.data)) {
                        inProgress.add(v.data);
                        stk.push(v);
                    }
                    doDFS(v);
                }
                else {
                    cycle = true;
                }
            }
            inProgress.remove(vertex.data);
            finished.add(vertex.data);
        }
    }
    static List<Integer> topological_list = new ArrayList<>();
    static Set<Vertex> visitedSet  = new HashSet<>();
    public static void topologicalSort(int start)
    {
        Vertex startV=vertices.get(start);
        visitedSet.add(startV);
        if(startV.children.size() == 0) {

            topological_list.add(start);
            topological_list.clear();
            return;
        }
        for(Vertex v: startV.children)
        {
            if(!visitedSet.contains(v))
                topologicalSort(v.data);

        }
        topological_list.add(startV.data);

    }
    public static void main(String[] args) {
        Graph graph = new Graph(true);

        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(1,5);
        graph.addEdge(2,3);
        graph.addEdge(2,6);
        graph.addEdge(6,3);
        graph.addEdge(7,8);
        topologicalSort(1);
        Collections.reverse(topological_list);
        System.out.println(topological_list.toString());
        graph.detectCycle();
        System.out.println("Cycle Exits? "+graph.cycle);
    }
}
