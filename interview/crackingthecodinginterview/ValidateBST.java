package interview.crackingthecodinginterview;

public class ValidateBST {
    public static void main(String[] args) {
        Tree root = new Tree(100);
        System.out.println(isBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE));
    }
    

    public static boolean isBST(Tree root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.data > max || root.data < min) {
            return false;
        }
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }
}
