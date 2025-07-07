package trees;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        // Example 1: root = [1,2,3,null,null,4], true
        TreeNode ex1 = new TreeNode(1);
        ex1.left = new TreeNode(2);
        ex1.right = new TreeNode(3);
        ex1.right.left = new TreeNode(4);

        // Example 2: root = [1,2,3,null,null,4,null,5], false
        TreeNode ex2 = new TreeNode(1);
        ex2.left = new TreeNode(2);
        ex2.right = new TreeNode(3);
        ex2.right.left = new TreeNode(4);
        ex2.right.left.left = new TreeNode(5);

        // Example 3: root = [], true
        TreeNode ex3 = null;

        boolean balanced = isBalanced(ex2);

        System.out.println("BALANCED?: " + balanced);
    }

    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private static int checkHeight(TreeNode node) {
        // No more levels below current node so height for that is 0
        if (node == null) return 0;

        System.out.println("Checking left side... ");
        int left = checkHeight(node.left);
        if (left == -1) {
            System.out.println("The left side unbalanced\n");
            return -1; // Left subtree is unbalanced
        }

        System.out.println("Checking right side...");
        int right = checkHeight(node.right);
        if (right == -1) {
            System.out.println("The right side unbalanced\n");
            return -1; // Right subtree is unbalanced
        }

        System.out.println("Left + right = " + left + " + " + right);
        if (Math.abs(left - right) > 1) {
            System.out.println("One side has a difference of more than 1. Immediately breaking recursion");
            return -1; // The tree is unbalances. No need to keep going so break it
        }

        System.out.println("Current height = 1 + max(" + left + ", " + right + ")\n");
        return 1 + Math.max(left, right); // Increment height
    }
}
