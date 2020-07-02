package com.practice.ds0;
import java.util.*;

public class AdjLIstGraphs {
    List<List<Integer>> adjList ;
    int vertices;
    AdjLIstGraphs(int vertices)
    {
        this.vertices= vertices;
        this.adjList = new ArrayList<List<Integer>>(vertices);
        for (int i = 0; i < vertices; i++)
            adjList.add(new ArrayList<Integer>());
    }
    public void addEdge(int source, int target){
        //undirected graph so both way entries needs to be done for edges

        adjList.get(source-1).add(target-1);
        adjList.get(target-1).add(source-1);
    }
    public void deleteEdge(int source , int target)
    {

        if(adjList.get(source-1).contains(target-1))
            adjList.get(source-1).remove(target-1);
        if(adjList.get(target-1) != null && adjList.get(target-1).contains(source-1))
            adjList.get(target-1).remove(source-1);
    }
    public void bfs(int start)
    {
        Queue<Integer>q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.add(start-1);

        set.add(start-1);
        while(!q.isEmpty() )
        {
            int ele= q.remove();
            System.out.println((ele+1)+ "--->");
            for(int i:adjList.get(ele))
            {
                if(!set.contains(i)) {
                    q.add(i);
                    set.add(i);
                }
            }

        }
    }
    public void dfs(int start)
    {
        Stack<Integer> stk = new Stack<>();
        Set<Integer>set = new HashSet<>();
        stk.push(start-1);
        set.add(start-1);
        while(!stk.isEmpty())
        {
            int data =stk.pop();
            System.out.println(data +"--->");
            for(int i:adjList.get(data))
            {
                if(!set.contains(i))
                {
                    stk.push(i);
                    set.add(i);
                }
            }
        }
    }
    public static void main(String[] args) {
        AdjLIstGraphs graph = new AdjLIstGraphs(6);
        /*List<Integer> dummy = new ArrayList<>();
        dummy.add(1);
        graph.adjList.add(dummy);*/
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(5,6);
        graph.dfs(2);
    }
}
