package greedy;

import java.util.HashMap;
import java.util.Map;

public class MaximumFrequencyAfterSubarrayOperation {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        int k = 1;

        int answer = maxFrequency(nums, k);
        System.out.println("Answer is: " +answer);
    }

    public static int maxFrequency(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for(int num : nums) {
            System.out.println("Choosing either " +map.getOrDefault(num, 0)+ " or " +map.getOrDefault(k, 0)+ " for prev value");
            int prev = Math.max(map.getOrDefault(num, 0), map.getOrDefault(k, 0));
            System.out.println("Prev is now " +prev);

            System.out.println("Putting [" +num+ ", " +prev+ " + 1] into the map");
            map.put(num, prev + 1);

            System.out.println("Choosing either " +res+ " or " +map.get(num)+ " - " +map.getOrDefault(k, 0)+ " for new res value");
            res = Math.max(res, map.get(num) - map.getOrDefault(k, 0));
            System.out.println("Res now has a value of " +res+ "\n");
        }

        return map.getOrDefault(k, 0) + res;
    }
}
