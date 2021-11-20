package interview.crackingthecodinginterview.stack;

public class Stack {
    static Node head;
    static boolean isEmpty = true;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public int pop() {
        if (head == null) {
            throw new Error("List is Empty, cannot pop");
        }

        if (head.next == null) {
            Node tempval = head;
            head = null;
            isEmpty = true; //this is where isEmpty should be updated, anytime an event occurs see if that
                            // impacts some other value in the code
            return tempval.data;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        Node returnval = temp.next;
        temp.next = null;

        return returnval.data;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (isEmpty) {
            isEmpty = false;
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp!=null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public int peek() {
        return head.data;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(100);
        s.push(2);
        s.push(3);
        s.push(5);
        s.push(6);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
