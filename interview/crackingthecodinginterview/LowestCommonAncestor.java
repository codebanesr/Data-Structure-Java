package interview.crackingthecodinginterview;

class Tree {
    int data;
    Tree left, right;

    Tree(int data) {
        this.data = data;
        left = right = null;
    }
}

public class LowestCommonAncestor {
    public static void main(String argos[]) {
        Tree tree = new Tree(1);
        tree.left = new Tree(2);
        tree.right = new Tree(3);
        tree.left.left = new Tree(4);
        tree.left.right = new Tree(5);
        tree.right.left = new Tree(6);
        tree.right.right = new Tree(7);

        Tree answer = findCommonAncestor(tree, 4, 5);
        System.out.println(answer.data);
    }

    public static Tree findCommonAncestor(Tree node, int a, int b) {
        if (node == null) {
            return null;
        }

        if (node.data == a || node.data == b) {
            return node;
        }

        Tree left = findCommonAncestor(node.left, a, b);
        Tree right = findCommonAncestor(node.right, a, b);

        if ((left == null && right != null) || (left != null && right == null)) {
            return left == null ? right : left;
        }

        if (left != null && right != null)
            return node;

        return null;
    }
}
