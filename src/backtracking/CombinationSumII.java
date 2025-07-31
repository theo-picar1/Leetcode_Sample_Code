package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CombinationSumII {
    private static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = {9,2,2,4,6,1,5};
        int target = 8;
        List<List<Integer>> answer = combinationSum2(candidates, target);
        System.out.println("All possible combinations: " +answer);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        dfs(candidates, target, list, 0);
        return res;
    }

    public static void dfs(int[] candidates, int target, List<Integer> list, int i) {
        if(target == 0) {
            System.out.println("Combination " +list+ " adds up to the target! Adding it to res...\n");
            res.add(new ArrayList<>(list));
            return;
        }
        else if(target < 0 || i >= candidates.length) {
            System.out.println("Sum is either too big or we have reached the end of the array! Returning...\n");
            return;
        }

        System.out.println("Starting at index " +i);
        for(int index = i; index < candidates.length; index++) {
            if(index > i && candidates[index] == candidates[index - 1]) {
                System.out.println("Current candidate [" +candidates[index]+ "], index " +index+ ", is a duplicate of the previous candidate [" +candidates[index-1]+ "], index " +index+ ". Skipping...");
                continue;
            }
            if(candidates[i] > target) {
                System.out.println("Current candidate [" +candidates[index]+ "], index " +index+ ", is too big to add to the list! Moving on to the next candidate\n");
                break;
            }

            list.add(candidates[index]);
            System.out.println("Adding candidate [" +candidates[index]+ "], index " +index+ ", to the list. List so far is " +list);

            System.out.println("Backtracking...");
            dfs(candidates, target - candidates[index], list, index + 1);

            System.out.println("Removing candidate [" +list.getLast()+ "] from the list...");
            list.removeLast();
            System.out.println("List so far is " +list+ "\n");
        }
    }
}
