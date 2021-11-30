package practicesection;

import java.util.*;

class Prims {
    class Edge {
        int destination;
        int distance;
        int src;

        Edge(int destination, int distance, int src) {
            this.src = src;
            this.destination = destination;
            this.distance = distance;
        }
    }

    Set<Integer> vv = new HashSet<>();

    // HashMap<Integer, LinkedList<Edge>> map = new HashMap<>();
    PriorityQueue<Edge> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.distance, y.distance));

    void addEdge(int src, int destination, int distance) {
        pq.add(new Edge(destination, distance, src));
    }

    Edge getNextEdge() throws Exception {
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (vv.contains(e.src) && vv.contains(e.destination)) {
                continue;
            } else {
                vv.add(e.src);
                vv.add(e.destination);
                return e;
            }
        }

        throw new Exception("Queue empty");
    }

    void printMST() {
        int cost = 0;
        while (!pq.isEmpty()) {
            try {
                Edge e = getNextEdge();
                cost += e.distance;
                System.out.println(e.src + "----" + e.destination);
            } catch (Exception e) {
                // do nothing
            }
        }

        System.out.println("total cost " + cost);
    }

    public static void main(String args[]) {
        Prims p = new Prims();

        p.addEdge(0, 1, 10);
        p.addEdge(0, 2, 6);
        p.addEdge(0, 3, 5);
        p.addEdge(1, 3, 15);
        p.addEdge(2, 3, 4);

        p.printMST();
    }
}
