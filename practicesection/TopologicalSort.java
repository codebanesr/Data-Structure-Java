
import java.util.*;

public class TopologicalSort {
    HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

    public void addNeighbour(int s, int d) {
        ArrayList<Integer> al = graph.get(s);
        if (al == null) {
            ArrayList<Integer> nl = new ArrayList<>();
            nl.add(d);
            graph.put(s, nl);
        } else {
            al.add(d);
        }
    }


    public void topsort(int sv) {
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();
        topsortutil(sv, stack, visited);

        for (Integer k : stack) {
            System.out.println(k);
        }
    }
    

    public void topsortutil(int v, Stack<Integer> stack, HashSet<Integer> visited) {
        if (graph.get(v) != null) {
            for (Integer neighbour : graph.get(v)) {
                if (!visited.contains(neighbour)) {
                    topsortutil(neighbour, stack, visited);
                    visited.add(neighbour);
                }
            }

        }
        stack.push(v);
    }

    public static void main(String[] args) {
        TopologicalSort ts = new TopologicalSort();
        ts.addNeighbour(1, 2);
        ts.addNeighbour(1, 3);
        ts.addNeighbour(1, 4);
        ts.addNeighbour(4, 5);
        ts.addNeighbour(3, 5);

        ts.topsort(1);
    }
}
