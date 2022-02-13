package interview.crackingthecodinginterview.LinkedList;

import interview.sprint2.LinkedListpublic class ReverseInKGroups {

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        ll.addNode(100);
        ll.addNode(120);
        ll.addNode(500);
        ll.addNode(900);
        ll.addNode(300);
        ll.addNode(600);
        ll.printNode();
    }


    public Node reverse(Node head, int K) {
        int count = 0;
        Node sons = head; //start of next section
        Node prev;
        while(head!=null && count<=K) {
            sons = sons.next;
            prev = head;
            head = head.next.next;
            head.next = null;
        }
    
        if(sons!=null) {
            prev.next = reverse(sons, K);
        }
    
        return prev;
    }
}
