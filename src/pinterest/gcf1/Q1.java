package pinterest.gcf1;

import java.util.Arrays;

public class Q1 {
    // Given an array of integers, return an array where each element
    // is replaced by the product of its previous and next neighbor
    // (if missing, use 1).

    public static void main(String[] args) {
        // Test case 1. Expected: [3, 8, 3] ✅
        int[] nums1 = new int[]{2, 3, 4};

        // Test case 2. Expected: [4, 0, 4] ✅
        int[] nums2 = new int[]{0, 4, 5};

        // Test case 3. Expected: [-2, 3, 8, 15, -4] ✅
        int[] nums3 = new int[]{1, -2, 3, -4, 5};

        // Test case 4. Expected: [1] ✅
        int[] nums4 = new int[]{5};

        // Test case 5: Expected [] ✅
        int[] nums5 = new int[0];

        System.out.println("Answer: " + Arrays.toString(method(nums5)));
    }

    public static int[] method(int[] nums) {
        // End immediately for single element arrays to prevent out of bounds error
        if(nums.length == 1) return new int[]{1};

        int[] res = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            // If at the start, append next element
            if(i == 0) {
                res[i] = nums[i + 1];
            }
            // If at end, append prev element
            else if(i == nums.length - 1) {
                res[i] = nums[i - 1];
            }
            // Otherwise, do multiplication as normal
            else {
                res[i] = nums[i - 1] * nums[i + 1];
            }
        }

        return res;
    }
}
