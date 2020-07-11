package com.practice.samples;

import com.practice.ds.Graph;

public class GraphSample {


    public static Graph getGraph() {
        Graph DAG = new Graph(true);
        DAG.addEdge(1,2,3);
        DAG.addEdge(1,3, 6);
        DAG.addEdge(2,3, 4);
        DAG.addEdge(2,4,4);
        DAG.addEdge(3,4,8);
        DAG.addEdge(2,5,11);
        DAG.addEdge(3,7,11);
        DAG.addEdge(4,7,2);
        DAG.addEdge(4,6,5);
        DAG.addEdge(4,5,-4);
        DAG.addEdge(5,8,9);
        DAG.addEdge(6,8,1);
        DAG.addEdge(7,8,2);
        return DAG;
    }

    public static void main(String[] args) {
        Graph g = GraphSample.getGraph();

    }

}
