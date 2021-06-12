package graphs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import graphs.Graph.Vertex;

public class DFS {
    public static void runDFS(Graph graph, String vertex) {
        Set<Vertex> set = new HashSet();
        runDFSUtil(vertex, graph, set);
    }


    public static void runDFSUtil(String sv, Graph graph, Set<Vertex> set) {
        System.out.println(sv);
        set.add(new Vertex(sv));

        for(Vertex v: graph.getAdjVertices(sv)) {
            if(!set.contains(v))
                runDFSUtil(v.label, graph, set);
        }
    }
    public static void main(String args[]) {
        Graph graph = new Graph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        
        System.out.println("Starting algorithm \n\n\n\n");
        runDFS(graph, "Bob");
    }
}
