package interview.crackingthecodinginterview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


class Node {
    int data;
    public Node left;
    public Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class ListOfDepths {
    public static void main(String[] args) {
        generateLevelOrder(new Node(10));
    }
    
    public static void generateLevelOrder(Node n) {
        Queue<Node> q = new LinkedList<>();

        q.add(n);
        q.add(new Node(-1));
        while (!q.isEmpty()) {
            Node temp = q.remove();
            if (temp.data != -1) {
                System.out.println(temp.data);
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            } else {
                q.add(new Node(-1));
            }
        }
    }
}
