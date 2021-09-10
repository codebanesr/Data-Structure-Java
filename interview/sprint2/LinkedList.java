package interview.sprint2;

public class LinkedList {
    Node head;

    class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
