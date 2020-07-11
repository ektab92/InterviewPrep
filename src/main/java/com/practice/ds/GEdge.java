package com.practice.ds;

public class GEdge {
    public GVertex src;
    public GVertex dest;
    public int wgt;
    GEdge(GVertex s,GVertex d,int w){
        this.src = s;
        this.dest = d;
        this.wgt = w;
    }


}
