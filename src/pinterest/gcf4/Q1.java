package pinterest.gcf4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Q1 {
    // Given a stream of integers, return the first unique integer at any point.

    public static void main(String[] args) {
        // Test case 1. Expected: 3: PASSED
        int[] stream1 = {1, 2, 3, 2, 1};
        System.out.println("Answer: " + firstUnique(stream1));

        // Test case 2. Expected: 6: PASSED
        int[] stream2 = {4, 5, 4, 5, 6, 7};
        System.out.println("Answer: " + firstUnique(stream2));

        // Test case 3. Expected: -1: PASSED
        int[] stream3 = {10, 10, 20, 20};
        System.out.println("Answer: " + firstUnique(stream3));

        // Test case 4. Expected: 7: PASSED
        int[] stream4 = {7};
        System.out.println("Answer: " + firstUnique(stream4));

        // Test case 5. Expected: 4: PASSED
        int[] stream5 = {2, 3, 2, 3, 4, 2};
        System.out.println("Answer: " + firstUnique(stream5));

        // Test case 6. Expected: 3: PASSED
        int[] stream6 = {1, 1, 3, 5, 4, 0};
        System.out.println("Answer: " + firstUnique(stream6));
    }

    public static int firstUnique(int[] nums) {
        if(nums.length == 1) return nums[0];

        // LinkedHashMap to preserve insertion order
        Map<Integer, Integer> map = new LinkedHashMap<>();

        // Count frequency of each num in the map
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Find out which num is the unique one
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        // Found no unique number
        return -1;
    }
}
