package interview.crackingthecodinginterview;

import java.util.*;

public class BSTSequence {
    public static void main(String argos[]) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        ArrayList<LinkedList<Integer>> result = build(arr, 0, arr.length - 1);

        System.out.println(result);
    }

    // return type for this function is going to be a list of subtrees starting at
    // index i….k
    public static ArrayList<LinkedList<Integer>> build(Tree node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();
        if (end == arr.length) {
            break;
        }

        if (end >= start) {
            
        }

        for (int i = start; i <= end; i++) {
            ArrayList<LinkedList<Integer>> left = build(arr, start, i);
            ArrayList<LinkedList<Integer>> right = build(arr, i, end);

            ArrayList<LinkedList<Integer>> weave = new ArrayList<LinkedList<Integer>>();

            // create a tree with left and right subtrees
            // iterate over left and right subtrees and add them to the root
            for (int j = 0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    Node node = new Node(i);
                    node.left = left.get(i);
                    node.right = right.get(j);

                    weave.add(node);
                }
            }
        }

        return weave;
    }
}
