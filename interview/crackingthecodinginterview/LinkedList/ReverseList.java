package interview.crackingthecodinginterview.LinkedList;

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class ReverseList {
    public static void main(String args[]) {
        Node head = new Node(100);
        head.next = new Node(200);
        head.next.next = new Node(300);
        head.next.next.next = new Node(2);

        head = reverse(head);


        while (head != null) {
            System.out.print(head.data + "  ");
            head = head.next;
        }
    }



    public static Node reverse(Node node) {
        if (node != null && node.next == null) {
            return node;
        }

        Node rest = reverse(node.next);
        node.next.next = node;
        node.next = null;


        // rest is just the tail of the initial linked list ...., 
        // this will at the end become the head of the reversed linked list
        return rest;
    }
}
