package trees;

public class LowestCommonAncestorOfBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        root.left.left.right = new TreeNode(2);

        // Test case 1: p = 3, q = 8
        TreeNode p1 = root.left;
        TreeNode q1 = root.right;

        // Test case 2: p = 3, q = 4
        TreeNode p2 = root.left.left;
        TreeNode q2 = root.left.right;

        System.out.println("Looking for ancestor for " +p2.val+ " and " +q2.val+ "\n");
        System.out.println("Answer: " +lowestCommonAncestor(root, p2, q2));
    }

    public static int lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;

        while(curr != null) {
            // Both node values are less, so ancestor has to be on left
            if(p.val > curr.val && q.val > curr.val) {
                System.out.println("Both values are greater than root, iterating to the right");
                curr = curr.right;
            }
            // Both node values are greater, so ancestor has to be on right
            else if(p.val < curr.val && q.val < curr.val) {
                System.out.println("Both values are lower than root, iterating to the left");
                curr = curr.left;
            }
            // Answer is either one of the nodes or a node that is ancestor to both
            else {
                if(p.val < curr.val && q.val > curr.val) {
                    System.out.println("Found ancestor! p and q are both children of it.\n");
                }
                else if(p.val == curr.val) {
                    System.out.println("Found ancestor! It is p.\n");
                }
                else if(q.val == curr.val) {
                    System.out.println("Found ancestor! It is q.\n");
                }
                return curr.val;
            }
        }

        return 0;
    }
}
