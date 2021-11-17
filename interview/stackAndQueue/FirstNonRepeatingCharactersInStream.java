package interview.stackAndQueue;

import java.util.LinkedList;


class Node {
    int data;
    Node next;
}

public class FirstNonRepeatingCharactersInStream {
    // A DLL to store 1st 2nd 3rd and so on non repeating characters ....,
    LinkedList<Integer> dll = new LinkedList<>();


    // An array inDLL to mark where in the DLL does an element occur of size 256, and initialize them with null
    Node inDLL[] = new Node[256];

    // A boolean array repeated to mark whether or not an element in the array has been repeated
    boolean isrepeated[] = new boolean[256];

    for(Integer x: stream) {
        
        if (inDLL[x] != null && isrepeated[x]) {
            continue;
        }
        if (inDLL[x] == null && !isrepeated[x]) {
            dll.addFirst(x);
        } else if (inDLL[x] != null && !isrepeated[x]) {
            isrepeated[x] = true;
            dll.remove(x);
        }
    }
}
