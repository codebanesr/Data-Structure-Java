package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Vertex {
    String label;

    Vertex(String label) {
        this.label = label;
    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        Vertex other = (Vertex)obj;
        return label.equals(other.label);
    }
}
class Graph {
    private Map<Vertex, List<Vertex>> adjlist;

    Graph() {
        this.adjlist = new HashMap<>();
    }


    void addVertex(String label) {
        adjlist.putIfAbsent(new Vertex(label), new ArrayList<>());
    }


    void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        adjlist.get(v1).add(v2);
        adjlist.get(v2).add(v1);
    }

    // remove all edges going to label and remove all edges
    void removeVertex(String label) {
        adjlist.values().stream().forEach(e -> {
            e.remove(new Vertex(label));
        });
        adjlist.remove(new Vertex(label));
    }



    void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);

        List<Vertex> ev1 = adjlist.get(v1);
        List<Vertex> ev2 = adjlist.get(v2);

        ev1.removeIf(x -> x != null);
        ev2.removeIf(x -> x != null);
    }
    
    List<Vertex> getAdjVertices(String label) {
        return adjlist.get(new Vertex(label));
    }
}

public class Dijkstra {
    public static void main(String[] args) {
        
    }
}
