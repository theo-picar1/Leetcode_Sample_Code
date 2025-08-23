package pinterest.gcf1;

import java.util.Arrays;

public class Q6 {
    // Given an array of integers, return a new array where each element is replaced with the
    // absolute difference between itself and the average of its neighbors
    // (use 0 if a neighbor does not exist).

    public static void main(String[] args) {
        // Test case 1. Expected: [1, 0, 3] ✅
        int[] nums1 = new int[]{2, 3, 4};

        // Test case 2. Expected: [0, 8] ✅
        int[] nums2 = new int[]{5, 10};

        // Test case 3. Expected: [7] ✅
        int[] nums3 = new int[]{7};

        // Test case 4. Expected: [2, 0, 2] ✅
        int[] nums4 = new int[]{-2, 0, 2};

        // Test case 5. Expected: [] ✅
        int[] nums5 = new int[]{};

        System.out.println("Answer: " + Arrays.toString(method(nums5)));
    }

    public static int[] method(int[] nums) {
        if(nums.length == 0) return new int[0];
        else if(nums.length == 1) return nums;

        int[] res = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                res[i] = Math.abs(nums[i] - (nums[i + 1] / 2));
            }
            else if(i == nums.length - 1) {
                res[i] = Math.abs(nums[i] - (nums[i - 1] / 2));
            }
            else {
                int product = (nums[i - 1] + nums[i + 1]) / 2;
                res[i] = Math.abs(nums[i] - product);
            }
        }

        return res;
    }
}
