package com.practice.ds.amazon.graphs;

import java.util.*;

public class UnionFind {
    int arr[];
    int capacity;
    UnionFind(int capacity)
    {
        this.arr=new int[capacity];
        Arrays.fill(arr,-1);
    }
    public int findParent(int vertex)
    {
        while(arr[vertex]>0)
        {
            vertex=arr[vertex];
        }
        return vertex;
    }
    public boolean Union(int src,int dest)
    {
        int p1=findParent(src);
        int p2=findParent(dest);
        //both the nodes have same parent, cycle found
        if(p1 == p2) return false;
        if(Math.abs(arr[p1])>Math.abs(arr[p2]))
        {
            arr[p1]=arr[p1]+arr[p2];
            arr[p2]=p1;
        }else
        {
            arr[p2]=arr[p1]+arr[p2];
            arr[p1]=p2;
        }
        return true;
    }


}
