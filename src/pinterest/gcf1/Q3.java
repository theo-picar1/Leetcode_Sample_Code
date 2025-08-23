package pinterest.gcf1;

import java.util.Arrays;

public class Q3 {
    // Given an array of integers, return the
    // running sum array.

    public static void main(String[] args) {
        // Test case 1. Expected: [1, 3, 6, 10] ✅
        int[] nums1 = new int[]{1, 2, 3, 4};

        // Test case 2. Expected: [5, 9, 12, 12, 15] ✅
        int[] nums2 = new int[]{5, 4, 3, 0, 3};

        // Test case 3. Expected: [0, 0, 0] ✅
        int[] nums3 = new int[]{0, 0, 0};

        // Test case 4. Expected: [-1, -3, -6, -10]
        int[] nums4 = new int[]{-1, -2, -3, -4};

        // Test case 5. Expected: [] ✅
        int[] nums5 = new int[0];

        System.out.println("Answer: " + Arrays.toString(method(nums1)));
    }

    public static int[] method(int[] nums) {
        if(nums.length == 0) return new int[0];

        // Make the passed in nums the res by modifying in place
        for(int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }

        return nums;
    }
}
