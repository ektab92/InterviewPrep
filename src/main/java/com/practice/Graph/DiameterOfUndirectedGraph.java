package com.practice.Graph;
import java.util.*;
public class DiameterOfUndirectedGraph {
    int maxLength=0;
    int bestNode;
    Map<Integer,List<Integer>>graphMap = new HashMap<>();
    List<Integer>children = new ArrayList<>();
    Set<Integer>visited = new HashSet<>();
    public void createGraph(int[][]graph)
    {
        for(int i=0;i<graph.length;i++) {
            children = graphMap.getOrDefault(graph[i][0], new ArrayList<>());
            children.add(graph[i][1]);
            graphMap.put(graph[i][0], children);
            children = graphMap.getOrDefault(graph[i][1], new ArrayList<>());
            children.add(graph[i][0]);
            graphMap.put(graph[i][1], children);
        }
    }
    public int findDiamater()
    {
        findDiamterHelper(0,0);
        System.out.println(bestNode+" : "+maxLength);
        visited.clear();
        findDiamterHelper(bestNode,0);
        System.out.println("Diameter of undirected graph is : "+maxLength);
        return maxLength;
    }
    public void findDiamterHelper(int start,int count)
    {
        if(visited.contains(start))
            return;
        visited.add(start);

        if(maxLength<count)
        {
            maxLength=count;
            bestNode=start;
        }

        for(int c:graphMap.get(start))
        {
            findDiamterHelper(c,count+1);
        }
    }
    public static void main(String[] args) {
        int [][] graph = {{0,1},{1,2},{2,3},{1,4},{4,5},{5,6},{6,7}};
        DiameterOfUndirectedGraph graph1 = new DiameterOfUndirectedGraph();
        graph1.createGraph(graph);
        graph1.findDiamater();
    }
}
