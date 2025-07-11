package trees;

public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        // Example 1: Expected output = true
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        TreeNode subRoot1 = new TreeNode(2);
        subRoot1.left = new TreeNode(4);
        subRoot1.right = new TreeNode(5);

        System.out.println("Example 1: \n");
        boolean result = isSubtree(root1, subRoot1);
        System.out.println("Final result: " + result);

        // Example 2: Expected output = false
//        TreeNode root2 = new TreeNode(1);
//        root2.left = new TreeNode(2);
//        root2.right = new TreeNode(3);
//        root2.left.left = new TreeNode(4);
//        root2.left.right = new TreeNode(5);
//        root2.left.left.left = new TreeNode(6);
//
//        TreeNode subRoot2 = new TreeNode(2);
//        subRoot2.left = new TreeNode(4);
//        subRoot2.right = new TreeNode(5);
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Three base cases for this

        // First is to just make sure subRoot is not null. This only matters for the first check.
        if(subRoot == null) {
            System.out.println("Subroot is null, so no longer need to do recursion at all! Done!");
            return true;
        }

        // Second is to make sure that the current node we're on for the main tree is not null. If it becomes null, then the side we're checking will never have the subRoot
        if(root == null) {
            System.out.println("No more nodes on this side, time to check the other side!");
            return false;
        }

        // Thirs is to make sure the subtree of the node we're checking has the same structure of the subRoot
        if(isSameTree(root, subRoot, "")) {
            System.out.println("The current node we're on is the same as subRoot! Done!");
            return true;
        }

        // If the first recursion is true, the method is finished, and we don't need to check the right side anymore
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q, String side) {
        if (p != null && q != null) {
            System.out.println("\n ***** Checking p node '" + p.val + "' and q node '" + q.val + "'. *****");
        }

        // If both nodes are null, can conclude that (left or right) side are the same
        if (p == null && q == null) {
            System.out.println(side + " sides are both null, returning true!");
            return true;
        }

        // Keep going as long as both nodes are not null and their values are the same
        if (p != null && q != null && p.val == q.val) {
            System.out.println("Nodes are the same, checking next level...");
            return isSameTree(p.left, q.left, "Left") && isSameTree(p.right, q.right, "Right");
        }

        // If none above, side is not the same
        System.out.println(side + " side is not the same. Returning false");
        return false;
    }
}
