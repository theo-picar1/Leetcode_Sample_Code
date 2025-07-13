package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        // Level 1
        TreeNode root = new TreeNode(5);

        // Level 2
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);

        // Level 3
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        // Level 4
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        // Level 5
        root.left.left.right = new TreeNode(2);

        List<List<Integer>> answer = levelOrder(root);
        System.out.println("All levels and their values: " +answer);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<List<Integer>> levels = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int currentLevel = 1;
        while(!queue.isEmpty()) {
            List<Integer> values = new ArrayList<>();

            System.out.println("\nCurrently at level " +currentLevel+ ", checking for nodes at level " +(currentLevel + 1));
            for(int i = queue.size(); i > 0; i--) {
                TreeNode curr = queue.poll();

                if(curr != null) {
                    System.out.println("Adding node " +curr.val+ "'s value to the list and its children to the queue");
                    values.add(curr.val);

                    queue.offer(curr.left);
                    queue.offer(curr.right);
                }
            }

            if(!values.isEmpty()) {
                currentLevel++;
                levels.add(values);
            }
            else {
                System.out.println("No more values to check, ending for loop");
            }
        }

        return levels;
    }
}
