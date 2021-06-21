package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import graphs.Graph.Vertex;

public class BFS {


    public static void runBFS(Graph graph, String label) {
        Queue<Vertex> q = new LinkedList<>();
        Vertex sv = new Vertex(label);
        q.add(sv);

        Set<Vertex> alreadyBeenThroughQueue = new HashSet<>();
        alreadyBeenThroughQueue.add(sv);
        while(!q.isEmpty()) {
            Vertex v = q.poll();
            System.out.println(v.label);
            Set<Vertex> neighbours = new HashSet<>(graph.getAdjVertices(v.label));
            neighbours.removeAll(alreadyBeenThroughQueue);
            alreadyBeenThroughQueue.addAll(neighbours);
            q.addAll(neighbours);
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
        runBFS(graph, "Bob");
    }
}
