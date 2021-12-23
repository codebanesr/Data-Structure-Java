public class Stack {
    static Node head;
    static boolean isEmpty = true;
    static int minValue;

    class Node {
        int data;
        Node next;

        Node(int data) {
            if (data < minValue) {
                this.data = data - minValue + data;
                minValue = data;
            } else {
                this.data = data;
            }
        }
    }

    public static int checkIfMinAndModify(int data) {
        if (data < minValue) {
            int temp = minValue;
            minValue = 2 * minValue - data;

            return temp;
        }

        return data;
    }

    public int pop() {
        if (head == null) {
            throw new Error("List is Empty, cannot pop");
        }

        if (head.next == null) {
            Node tempval = head;
            head = null;
            isEmpty = true;
            return checkIfMinAndModify(tempval.data);
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        Node returnval = temp.next;
        temp.next = null;

        return checkIfMinAndModify(returnval.data);
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (isEmpty) {
            isEmpty = false;
            head = newNode;
            minValue = data;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp != null) {
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
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
        System.out.println("---------------------------------------------");
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(100);
        s.push(2);
        s.push(3);
        s.push(5);
        s.push(6);
        s.print();
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}