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
    

    public void addNode(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node temp = head;
        while (temp.right != null) {
            temp = temp.right;
        }


        temp.right = new Node(data);
    }


    public void printNode() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + ", ");
            temp = temp.right;
        }
    }


    public Node reverse(Node head, int K) {
        Node curr = head;
        Node right;
        Node left = null;

        while (curr != null) {
            right = curr.right;
            curr.right = left;
            left = curr;

            curr = right;
        }
        return left;
    }


    public Node reverseInKGroups(Node head, int K) {
        Node curr = head;
        Node right = null;
        Node left = null;

        int counter = 0;
        while (curr != null && counter<=K) {
            right = curr.right;
            curr.right = left;
            left = curr;

            curr = right;

            counter++;
        }

        head.right = reverseInK(right, K);
        return left;
    }
}
