package interview.crackingthecodinginterview;


/** @Todo this is an incomplete implementation, just a pseudo code coz of lack of time */
class TNode {
    int data;
    public TNode left;
    public TNode right;
    public TNode parent;

    TNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }

    TNode(int data, TNode parent) {
        this.data = data;
        this.left = this.right = null;
        this.parent = parent;
    }
}
public class InorderSuccessor {
    public static void main(String[] args) {

    }

    public static int findSmallest(TNode node) {
        TNode temp = node;
        while(temp.left!=null) {
            temp = temp.left;
        }


        return temp.data;
    }

    public static int inorderSuccessor(TNode node) {
        if (node == null) {
            return -1;
        }

        if(node.right!=null) {
            return findSmallest(node.right);
        }
        
        TNode parent = node.parent;
        while (true) {
            // if node becomes the left child of its parent, its parent comes next in the
            // inorder traversal or we can say its the great element with the lowest value
            // or that its the inorder successor
            if(node!=parent.right) {
                return node.data;
            }
            node = parent;
            parent = parent.parent;
        }
    }
}
