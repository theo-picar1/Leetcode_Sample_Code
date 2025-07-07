package trees;

public class IsSameTree {
    public static void main(String[] args) {
        // ----- Example #1: False -----
//        TreeNode p = new TreeNode(2);
//        p.left = new TreeNode(1);
//        p.right = new TreeNode(3);
//
//        TreeNode q = new TreeNode(2);
//        q.left = new TreeNode(1);
//        q.right = new TreeNode(4);

        // ----- Example #2: True -----
        TreeNode p = new TreeNode(2);
        p.left = new TreeNode(1);
        p.right = new TreeNode(4);
        p.right.left = new TreeNode(3);

        TreeNode q = new TreeNode(2);
        q.left = new TreeNode(1);
        q.right = new TreeNode(4);
        q.right.left = new TreeNode(3);

        boolean result = isSameTree(p, q, "");

        System.out.println("\nTREES ARE THE SAME? " + result);
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