package TestGraph;
import java.util.*;
public class Vertex {
    public int id;
    public List<Vertex>children;
    public List<Edge> edges;
    public Vertex(int id)
    {
        this.id=id;
        this.children = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
