package interview.crackingthecodinginterview.LinkedList;

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class KToLast {
    public static void main(String args[]) {

    }

    public static int ktlIndexRecursive(Node head, int K) {
        if (head == null) {
            return 0;
        }

        int count = ktlIndexRecursive(head.next, K) + 1;
        if (count == K) {
            System.out.println(head.data);
        }

        return count;
    }

    public static int ktlIndexIterative(Node head, int k) {
    }
}
