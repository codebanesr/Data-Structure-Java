package practicesection;

import java.util.*;

class Node {
    int data;
    Node left, right;

    // Function to create a new binary tree node having a given key
    public Node(int key) {
        data = key;
        left = right = null;
    }
}

public class IterativePreorder {
    static void preorderIterative(Node root) {
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            root = st.pop();
            System.out.print(root.data + ", ");

            if(root.right!=null)
                st.push(root.right);

            if(root.left!=null)
                st.push(root.left);
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        preorderIterative(root);
    }
}
