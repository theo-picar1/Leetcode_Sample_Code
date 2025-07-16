package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    // Global variable to keep track of result
    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
//        Example 1:
        int[] nums = {2,5,6,9};
        int target = 9;
//        Output: [[2,2,5],[9]]

//        Example 2:
//        int[] nums = {3,4,5};
//        int target = 16;
//        Output: [[3,3,3,3,4],[3,3,5,5],[4,4,4,4],[3,4,4,5]]

//        Example 3:
//        int[] nums = {3};
//        int target = 5;
//        Output: []

        List<List<Integer>> answer = combinationSum(nums, target);

        System.out.println(answer);
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> temp = new ArrayList<>();

        backtrack(nums, target, temp, 0);

        return res;
    }

    public static void backtrack(int[] nums, int target, List<Integer> temp, int index) {
        // Found a combination
        if(target == 0) {
            List<Integer> combination = new ArrayList<>(temp);

            System.out.println(combination + " adds up to the target! Adding it to the result\n");

            res.add(combination); // Important. just doing temp will cause it to change as we're doing modifications
            return;
        }
        // To big of a sum or we have already went through to entire nums array
        else if(target < 0) {
            System.out.println(temp + " is too big, returning...\n");
            return;
        }
        else if(index >= nums.length) {
            System.out.println("Checked all other numbers in the array, returning...\n");
            return;
        }

        System.out.println("Adding " + nums[index] + " to " +  temp);
        temp.add(nums[index]);
        backtrack(nums, target - nums[index], temp, index); // Keep adding current num to se if that's valid

        System.out.println("Removing end value in " + temp);
        temp.remove(temp.size() - 1); // Move back up one level
        backtrack(nums, target, temp, index + 1); // Check the num next to the current num to see if that's fine. If not, this side is done
    }
}
