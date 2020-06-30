package com.practice.ds;

import java.util.List;

public class GVertex {

    public int id;
    public List<GEdge> edges;
    public List<GVertex> children;

    public GVertex(int id){
        this.id = id;
    }
}
