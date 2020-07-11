package TestGraph;
import java.util.*;

public class Graph {
    public Map<Integer,Vertex>vertexNodeRefMap = new HashMap<>();
    public Graph()
    {
        
    }
    //ForDirected Graph
    public void addEdge(int src,int dest,int wgt)
    {
        Vertex s=vertexNodeRefMap.getOrDefault(src,new Vertex(src));
        Vertex d=vertexNodeRefMap.getOrDefault(dest,new Vertex(dest));
        vertexNodeRefMap.put(src,s);
        vertexNodeRefMap.put(dest,d);
        Edge e = new Edge(src,dest,wgt);
        s.children.add(d);
        s.edges.add(e);
    }
    Set<Vertex>visited = new HashSet<>();
    Stack<Integer>stk = new Stack<>();
    List<Integer>topoLSortList = new ArrayList<>();
    public  void postOrderDFS(Vertex start)
    {
        if(visited.contains(start))
            return;
        visited.add(start);
        
        if(start.children.size()==0) 
        {
            stk.push(start.id);
            return;
        }
        for(Vertex v:start.children)
        {
            if(!visited.contains(v))
                postOrderDFS(v);
        }
        stk.push(start.id);
    }
    public void topoLSort(Vertex start)
    {
        postOrderDFS(start);
        while(!stk.isEmpty())
        {
            topoLSortList.add(stk.pop());
        }
        System.out.println(topoLSortList);
    }
    public int [] maxLengthPathVal()
    {
        int pathLength[] = new int [topoLSortList.size()+1];
        Arrays.fill(pathLength,Integer.MAX_VALUE);
        pathLength[1]=0;
        for(int i=0;i<topoLSortList.size();i++)
        {
            Vertex currV = vertexNodeRefMap.get(topoLSortList.get(i));
            for(Edge e :currV.edges)
            {
                pathLength[e.dest] = Math.min(pathLength[e.dest],pathLength[currV.id]+e.wgt);
            }
        }
        System.out.println(Arrays.toString(pathLength));
        return pathLength;
    }

    public static void main(String[] args) {
        Graph DAG = new Graph();
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
        DAG.topoLSort(DAG.vertexNodeRefMap.get(1));
        DAG.maxLengthPathVal();
    }
}
