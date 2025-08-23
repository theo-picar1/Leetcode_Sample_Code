package pinterest.gcf2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q3 {
    // Given an array of integers, return the count of subarrays with sum divisible by 3.

    public static void main(String[] args) {
        // Test case 1. Expected: 2 ✅
        int[] arr1 = {1, 2, 3};
        System.out.println("Answer: " + method(arr1));

        // Test case 2. Expected: 2 ✅
        int[] arr2 = {3, 6};
        System.out.println("Answer: " + method(arr2));

        // Test case 3. Expected: 1 ✅
        int[] arr3 = {1, 1, 1};
        System.out.println("Answer: " + method(arr3));

        // Test case 4. Expected: 3 ✅
        int[] arr4 = {3, 3, 3};
        System.out.println("Answer: " + method(arr4));

        // Test case 5. Expected: 2 ✅
        int[] arr5 = {2, 1, 2, 1, 2};
        System.out.println("Answer: " + method(arr5));

        // Test case 6. Expected: 0 ✅
        int[] arr6 = {0, 0, 0};
        System.out.println("Answer: " + method(arr6));

        // Test case 7. Expected: 2 ✅
        int[] arr7 = {-1, -2, -3};
        System.out.println("Answer: " + method(arr7));

        // Test case 8. Expected: 1 ✅
        int[] arr8 = {9};
        System.out.println("Answer: " + method(arr8));
    }

    public static int method(int[] nums) {
//        int[] arr1 = {1, 2, 3};

        // Store remainders and the amount of times they have already appeared
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefix = 0, res = 0;
        for(int num : nums) {
            prefix += num;

            int remainder = (prefix % 3 + 3) % 3;

            if(map.containsKey(remainder)) {
                res += map.get(remainder);
            }

            map.put(remainder, map.getOrDefault(map, 0) + 1);
        }

        return res;
    }
}
