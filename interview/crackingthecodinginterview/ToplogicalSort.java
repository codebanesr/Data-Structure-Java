package interview.crackingthecodinginterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

/** This code has not been tested and might be prone to bugs, use it only for reference and not for actual coding 
 * use at your own risk
*/
public class ToplogicalSort {
    static int N = 10; //number of nodes
    static Set<Integer> visited;
    static Stack<Integer> stack = new Stack<>();

    public static void topologicalSort(ArrayList<LinkedList<Integer>> adj) {
        for (int i = 0; i < N; i++) {
            // missed the following line while writing this code, node i might have been visited after the first iteration
            if (!visited.contains(i)) {
                topologicalSortUtil(adj, i);
            }
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
    

    public static void topologicalSortUtil(ArrayList<LinkedList<Integer>> adj, int i) {
        LinkedList<Integer> neighbours = adj.get(i);
        visited.add(i);
        for (Integer n : neighbours) {
            if (!visited.contains(n)) {
                topologicalSortUtil(adj, n);
            }
        }

        // this i will only have been called if it had no children or all of its children have been covered
        // in other terms all of its dependencies have been met
        stack.push(i);
    }

    public static void main(String[] args) {
        ArrayList<LinkedList<Integer>> adj = new ArrayList<>();
        topologicalSort(adj);
    }
}
