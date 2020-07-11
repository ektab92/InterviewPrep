package com.practice.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    public Map<Integer, GVertex> vertices;
    public List <GEdge> edges;
    public boolean isDirected;

    public Graph(boolean isDirected)
    {
        this.isDirected = isDirected;
        this.vertices = new HashMap<>();
        this.edges = new ArrayList<>();
    }

    public  void addNode(int data)
    {
        if(!vertices.containsKey(data))
            vertices.put(data,new GVertex(data));
    }

    public void addEdge(int source,int target){
        addEdge(source, target, 0);
    }

    public void addEdge(int source,int target, int weight){
        GVertex src = vertices.get(source);
        GVertex dest = vertices.get(target);
        if(src == null )
        {
            src = new GVertex(source);
            vertices.put(source,src);
        }
        if(dest == null )
        {
            dest = new GVertex(target);
            vertices.put(target,dest);
        }

        GEdge edge = new GEdge(src,dest,weight);
        edges.add(edge);
        src.children.add(dest);
        src.edges.add(edge);
        if (!isDirected) {
            dest.children.add(src);
            dest.edges.add(edge);
            GEdge edge1 = new GEdge(dest, src, weight);
            edges.add(edge1);

        }
    }
    public void deleteVertex(int data){
        GVertex vertex =vertices.get(data);
        vertices.remove(data);
        for(GVertex i:vertex.children)
        {
            i.children.remove(vertex);
        }
    }
    public void deleteEdge(int source,int dest)
    {
        GVertex sVertex = vertices.get(source);
        GVertex dVertex = vertices.get(dest);
        GEdge tmp=null;
        for(int i =0; i<edges.size()-1;i++)
        {
            if(edges.get(i).src == sVertex && edges.get(i).dest == dVertex)
            {
                tmp = edges.get(i);
                break;
            }
        }
        edges.remove(tmp);

        if(!isDirected)
            dVertex.children.remove(sVertex);
    }
}
