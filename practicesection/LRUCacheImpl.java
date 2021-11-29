package practicesection;

import java.util.*;

class LRUCache<K> {
    class Node {
        K data;
        Node next, prev;

        Node(K data) {
            this.data = data;
        }
    }
    
    Node head;
    HashMap<K, Node> map = new HashMap<>();
    void insert(K data) {
        Node nn = new Node(data);
        if (head == null) {
            head = nn;
            return;
        }

        if (map.containsKey(nn.data)) {
            remove(nn);
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = nn;
        nn.prev = temp;
        nn.next = null;
        map.put(nn.data, nn);
    }

    void deleteNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    void remove(Node node) {
        // we have to delete the previous node not the node that is
        // currently being inserted... therefore we first look into
        // the map and find out the address of a prev node with the same 
        // value that was inserted
        deleteNode(map.get(node.data));
        map.remove(node.data);
    }


    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
    }
}


public class LRUCacheImpl {
    public static void main(String[] args) {
        LRUCache<Integer> lru = new LRUCache<>();
        lru.insert(2);
        lru.insert(21);
        lru.insert(12);
        lru.insert(211);
        lru.insert(121);
        lru.insert(112);
        lru.insert(122);
        lru.insert(211);
        lru.insert(121);
        lru.insert(112);


        lru.print();
    }
}