public class AVL {
    class Node {
        Node left, right;
        private int data, height;

        public int getHeight() {
            return height;
        }

        public int getData() {
            return data;
        }


        public void updateHeight(int height) {
            this.height = height;
        }
    }

    int height(Node n) {
        return n.height;
    }


    void updateHeight(Node n) {
        n.updateHeight(1 + Math.max(n.right.height, n.left.height));
    }

    int balanceFactor(Node n) {
        return n.right.height - n.left.height;
    }

    void leftRotate(Node n) {
        Node hinge = n.left;
        Node temp = hinge.right;
        hinge.right = n;
        n.left = temp;

        updateHeight(n);
        updateHeight(hinge);
    }

    void rightRotate(Node n) {
        // similarly do right rotation
        int bfn = balanceFactor(n);
        int bfnRight = balanceFactor(n.right);
        int bfnLeft = balanceFactor(n.left);


        if (bfn < -1) {
            if(bfnLeft <= 0) {

            }
        }

    }
    


    void rebalance(Node n) {
        // balance factor for n;
        int bfn = 
    }

    void rotateLR(Node n) {

    }

    void rotateRL(Node n) {

    }


    void insert(int data) {

    }

    void remove(int data) {

    }
}
