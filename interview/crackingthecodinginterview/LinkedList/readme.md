## How to arrive at reverse in groups of k
1. Lets say k = 4 
### Place one pointer at node number 5; that will be the next section that we need to look into
```java
public void reverse(Node head, int K) {
    int count = 0;
    Node sons = head; //start of next section
    while(head!=null && count<=K) {
        sons = sons.next;
    }
}

### Now we can safely reverse the linked list from point 1 to k, without having to worry about the rest. Lets do that
```java
public Node reverse(Node head, int K) {
    int count = 0;
    Node sons = head; //start of next section
    while(head!=null && count<=K) {
        sons = sons.next;
    }


    while(head!=null && count<=K) {
        head = head.next.next;
        head.next = null;
    }

    return head; //this will be fixed in the next step. This was deliberately done to match the return type
}


### Now only problem in this solution is that we need to somehow stitch the 1st sections tail to next sections head; since head at the end will be null, we will need a prev counter to hold the pointer to last node and set its next to
the start of next section. 
```java
public Node reverse(Node head, int K) {
    int count = 0;
    Node sons = head; //start of next section
    Node prev;
    while(head!=null && count<=K) {
        sons = sons.next;
    }

    while(head!=null && count<=K) {
        prev = head;
        head = head.next.next;
        head.next = null;
    }

    if(sons!=null) {
        prev.next = reverse(sons);
    }

    return prev;
}

### since there are identical loops we can now go ahead and merge both those logic
``java
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

### Disclaimer
This code has not been tested for correctness, this just contains the logic and was written in a hurry. Only use it for reference. 