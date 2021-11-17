package interview.crackingthecodinginterview;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//        1
//     /     \
//    2       3
//   /  \    / \
//  4    5  6   7


// key   values
//  0 ->  1, 5, 6
// -1 ->  2
// -2 ->  4
//  1 ->  3
//  2 ->  7


// Output :- 4 2 1 3 7

class Node {
    int data;
    public Node left;
    public Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Pair {
    public int level;
    public int data;

    Pair(int level, int data) {
        this.level = level;
        this.data = data;
    }

    @Override
    public String toString() {
        return this.data + "";
    }
}

public class TopOrder {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        System.out.println(
            "Following are nodes in top view of Binary Tree");
        solveTopOrder(root, 0, 0);
        printPostOrder();
    }
    

    static HashMap<Integer, Pair> hm = new HashMap<>();
    static List<Integer> order = new LinkedList<>();

    public static void solveTopOrder(Node root, int breadth, int level) {
        if (root == null) {
            return;
        }

        solveTopOrder(root.left, breadth - 1, level + 1);
        // condition check for adding it to the list
        if (!hm.containsKey(breadth)) {
            hm.put(breadth, new Pair(level, root.data));
        } else {
            if (hm.get(breadth).level > level) {
                hm.put(breadth, new Pair(level, root.data));
            }
        }
        solveTopOrder(root.right, breadth + 1, level + 1);

    }
    
    public static void printPostOrder() {
        List l = hm.entrySet().stream().sorted((x, y) -> {
            return Integer.compare(x.getKey(), y.getKey());
        }).collect(Collectors.toList());

        System.out.println(Arrays.toString(l.toArray()));
    }
}
