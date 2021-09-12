package DataStructures;


class Node {
    int data;
    Node next;

    Node(int data) {
        next = null;
        this.data = data;
    }
}


class DLL {
    Node head;

    DLL() {
        head = null;
    }
    

    void addNode(int data) {
        Node temp = head;        
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
    }
    

    void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }


    void printDLL() {
        System.out.println("\nprinting nodes");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
    }


    void reverse() {
        Node current = head, prev = null, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
}

public class DLLDriver {
    public static void main(String[] args) {
        DLL dll = new DLL();
        dll.addFirst(10);
        dll.addFirst(11);
        dll.addFirst(12);
        dll.addFirst(13);

        dll.addNode(14);

        dll.printDLL();

        dll.reverse();
        dll.printDLL();
    }
}
