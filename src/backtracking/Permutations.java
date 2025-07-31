package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    private static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        List<List<Integer>> answer = permute(nums);
        System.out.println("All possible permutations/combinations are: " +answer);
    }

    public static List<List<Integer>> permute(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    private static void dfs(int[] nums, int index) {
        if(index == nums.length) {
            List<Integer> perm = new ArrayList<>();

            System.out.println("Went through all nums in the array. Adding manipulated nums, " +Arrays.toString(nums)+ ", to perm...");
            for(int num : nums) {
                perm.add(num);
            }

            res.add(perm);
            System.out.println("Added nums to perm. Res so far is " +res+ "\n");
            return;
        }

        System.out.println("Starting at nums[" +index+ "] now...");
        for(int i = index; i < nums.length; i++) {
            System.out.println("BEGINNING OF FOR LOOP");
            System.out.println("Swapping nums[" +index+ "], " +nums[index]+ ", with nums[" +i+ "], " +nums[i]);
            swap(nums, index, i);
            System.out.println("Nums so far: " +Arrays.toString(nums));

            System.out.println("Backtracking...\n");
            dfs(nums, index + 1);

            System.out.println("Swapping nums[" +index+ "], " +nums[index]+ ", with nums[" +i+ "], " +nums[i]);
            swap(nums, index, i);
            System.out.println("Nums so far: " +Arrays.toString(nums));
            System.out.println("END OF FOR LOOP\n");
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
