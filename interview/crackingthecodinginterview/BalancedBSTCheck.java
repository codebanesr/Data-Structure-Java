package interview.crackingthecodinginterview;


class Height {
    int height;
}

public class BalancedBSTCheck {

    public static boolean isBalanced(Tree root, Height currentHeight) {
        if (root == null) {
            return true;
        }

        Height left = new Height();
        Height right = new Height();

        // a reference to this is also present at the caller
        currentHeight.height = Math.max(left.height, right.height) + 1;

        // we are not trying to get the height of these trees in return value, that will be
        // copied by reference
        boolean isLeftBalanced = isBalanced(root.right, right);
        boolean isRightBalanced = isBalanced(root.right, right);

        if (isLeftBalanced && isRightBalanced && Math.abs(left.height - right.height) < 2) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Tree root = new Tree(100);
        System.out.println(isBalanced(root, new Height()));
    }
}
