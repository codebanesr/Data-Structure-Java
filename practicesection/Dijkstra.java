package practicesection;

import java.util.*;

class Graph {
    class Edge {
        int destination;
        int distance;

        Edge(int destination, int distance) {
            this.destination = destination;
            this.distance = distance;
        }
    }

    HashMap<Integer, LinkedList<Edge>> map = new HashMap<>();
    final int V;

    Graph(int V) {
        this.V = V;
        for (int i = 0; i < V; i++) {
            map.put(i, new LinkedList<Edge>());
        }
    }

    void addEdge(int src, int destination, int distance) {
        map.get(src).add(new Edge(destination, distance));
    }

    int findNextVertex(int[] distance, HashSet<Integer> visited) {
        int minvalue = Integer.MAX_VALUE;
        int candidateIndex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited.contains(i) && distance[i] < minvalue) {
                minvalue = distance[i];
                candidateIndex = i;
            }
        }

        return candidateIndex;
    }

    int[] dijkstra(int s) {
        int distance[] = new int[this.V];

        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        int counter = 0;
        distance[s] = 0;

        HashSet<Integer> visited = new HashSet<>();
        while (counter < distance.length) {
            int candidateIndex = findNextVertex(distance, visited);
            visited.add(candidateIndex);
            if (candidateIndex == -1) {
                break;
            }

            if (map.get(candidateIndex) != null) {
                for (Edge e : map.get(candidateIndex)) {
                    if (distance[e.destination] > distance[candidateIndex] + e.distance) {
                        distance[e.destination] = distance[candidateIndex] + e.distance;
                    }
                }
            }
            counter++;
        }

        return distance;
    }

    // does the job but isn't totally correct
    public void BFS(int src) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(src);

        while (!q.isEmpty()) {
            int candidate = q.remove();
            System.out.print(candidate +", ");
            for (Edge child : map.get(candidate)) {
                if (!visited.contains(child.destination)) {
                    visited.add(child.destination);
                    q.add(child.destination);
                }
            }
        }
    }
}

public class Dijkstra {
    public static void main(String args[]) {
        Graph graph = new Graph(9);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 7, 11);
        graph.addEdge(1, 0, 7);
        graph.addEdge(2, 1, 8);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 8, 2);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 2, 7);
        graph.addEdge(3, 4, 9);
        graph.addEdge(3, 5, 14);
        graph.addEdge(4, 3, 9);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 4, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 5, 2);
        graph.addEdge(6, 7, 1);
        graph.addEdge(6, 8, 6);
        graph.addEdge(7, 0, 8);
        graph.addEdge(7, 1, 11);
        graph.addEdge(7, 6, 1);
        graph.addEdge(7, 8, 7);
        graph.addEdge(8, 2, 2);
        graph.addEdge(8, 6, 6);
        graph.addEdge(8, 7, 1);

        int[] distance = graph.dijkstra(0);
        System.out.println(Arrays.toString(distance));
        graph.BFS(0);
    }
}
