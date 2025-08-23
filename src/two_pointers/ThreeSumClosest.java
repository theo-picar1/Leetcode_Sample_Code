package two_pointers;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;

        int answer =threeSumClosest(nums, target);

        System.out.println("THE ANSWER IS: " +answer);
    }

    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length, minSum = Integer.MAX_VALUE, res = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int diff = Math.abs(target - sum);

                    if(diff < minSum) {
                        System.out.println("The sum " +sum+ " is the closest sum so far (It is less than " +minSum+ "). Updating res...");
                        res = sum;
                    }
                }
            }
        }

        return res;
    }
}
