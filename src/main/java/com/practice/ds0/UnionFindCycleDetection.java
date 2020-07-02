package com.practice.ds0;

import java.util.Arrays;

public class UnionFindCycleDetection {
    int vertexSet[];
    UnionFindCycleDetection(int vertices)
    {
        this.vertexSet = new int[vertices+1];
        Arrays.fill(vertexSet,-1);
    }
    public int union(int v1,int v2)
    {
        int parent1 = find(v1);
        int parent2 = find(v2);
        if(parent1 == parent2)
            return -1;
        if(Math.abs(vertexSet[parent1])>Math.abs(vertexSet[parent2]))
        {
            vertexSet[parent1]+= vertexSet[parent2];
            vertexSet[parent2]=parent1;
        }
        else
        {
            vertexSet[parent2]+=vertexSet[parent1];
            vertexSet[parent1]=parent2;
        }
        return 0;
    }
    private int find(int v1)
    {
        while(vertexSet[v1] >0)
        {
            v1 = vertexSet[v1];
        }
        return v1;
    }
    public static void main(String[] args) {
        UnionFindCycleDetection unionFind = new UnionFindCycleDetection(4);
        System.out.println("Cycle exists between 1 & 2? "+unionFind.union(1,2));
        System.out.println("Cycle exists between 2 & 3? "+unionFind.union(2,3));
        System.out.println("Cycle exists between 3 & 4? "+unionFind.union(3,4));
        System.out.println("Cycle exists between 4 & 1? "+unionFind.union(4,1));
        System.out.println("Cycle exists between 3 & 4? "+unionFind.union(2,4));

    }
}
