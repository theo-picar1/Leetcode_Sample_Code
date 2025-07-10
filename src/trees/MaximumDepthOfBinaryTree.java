package trees;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        // ----- Example #1: 2 -----
//        TreeNode p = new TreeNode(2);
//        p.left = new TreeNode(1);
//        p.right = new TreeNode(3);
//
//        ----- Example #2: 2
//        TreeNode q = new TreeNode(2);
//        q.left = new TreeNode(1);
//        q.right = new TreeNode(4);

        // ----- Example #2: 3 -----
        TreeNode p = new TreeNode(2);
        p.left = new TreeNode(1);
        p.right = new TreeNode(4);
        p.right.left = new TreeNode(3);

        int answer = maxDepth(p);

        System.out.println("Depth of tree is " + answer);
    }

    public static int maxDepth(TreeNode root) {
        // If no node, return 0
        if(root == null) return 0;

        // Get heights of left and right subtrees
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        System.out.println("Calculating 1 + max(left (" +left+ ") + right (" +right+ "))");
        System.out.println("Height so far is " + (1 + Math.max(left, right)) + "\n");

        // Increment the height
        return 1 + Math.max(left, right);
    }
}
